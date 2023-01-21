package my.ohrem.web.common;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.request.add.CreateOrderForUserRequest;
import my.ohrem.request.add.CreatePaymentEntityRequest;
import my.ohrem.request.ProcessPaymentRequest;
import my.ohrem.service.service.*;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class CreateOrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CarService carService;

    @Autowired
    private CreateOrderService createOrderService;

    @Autowired
    private CreatePaymentEntityService createPaymentEntityService;

    @Autowired
    private GetUserFromContextHolderService userGetFromContextHolderService;

    @Autowired
    private CreatePaymentEntityService paymentEntityService;

    @GetMapping("/createOrder.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView getCreateOrder() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();
        ModelAndView modelAndView;

        if (user.getOrderEntity() == null) {
            modelAndView = new ModelAndView("createOrder");
            modelAndView.addObject("cars", carService.getAllAvailable());
        } else {
            if (user.getOrderEntity().getPaymentEntity() == null) {
                return new ModelAndView("createPaymentEntity");
            }
            modelAndView = new ModelAndView("userResultInfo");
            modelAndView.addObject("paymentSum", paymentEntityService.countFinalSum(user.getOrderEntity()));
            modelAndView.addObject("restPayment", user.getOrderEntity().getPaymentEntity().getPaymentSum());
            modelAndView.addObject("orderCar", user.getOrderEntity().getCarEntity());
            modelAndView.addObject("remainingDays", DAYS.between(user.getOrderEntity().getBeginDate(), user.getOrderEntity().getEndDate()));
            modelAndView.addObject("userBalance", user.getBalance());
            modelAndView.addObject("isPaid", user.getOrderEntity().getPaymentEntity().getIsPaid().toString());
            modelAndView.addObject("comment", "You already have an active order");
        }
        return modelAndView;
    }

    @GetMapping("/{carId}/createOrderSelectedCar.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView getCreateOrderSelectedCar(@PathVariable("carId") long id) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();
        ModelAndView modelAndView;

        if (user.getOrderEntity() == null) {
            modelAndView = new ModelAndView("createOrderSelectedCar");
            CarEntity car = carService.getCarEntity(id);
            if (car.getIsAvailable())
                modelAndView.addObject("car", car);
            else return new ModelAndView("carAvailableError");
        } else {
            if (user.getOrderEntity().getPaymentEntity() == null) {
                return new ModelAndView("createPaymentEntity");
            }
            modelAndView = new ModelAndView("userResultInfo");
            modelAndView.addObject("paymentSum", paymentEntityService.countFinalSum(user.getOrderEntity()));
            modelAndView.addObject("restPayment", user.getOrderEntity().getPaymentEntity().getPaymentSum());
            modelAndView.addObject("orderCar", user.getOrderEntity().getCarEntity());
            modelAndView.addObject("remainingDays", DAYS.between(user.getOrderEntity().getBeginDate(), user.getOrderEntity().getEndDate()));
            modelAndView.addObject("userBalance", user.getBalance());
            modelAndView.addObject("isPaid", user.getOrderEntity().getPaymentEntity().getIsPaid().toString());
            modelAndView.addObject("comment", "You already have an active order");
        }
        return modelAndView;
    }

    @GetMapping("/processPayment.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView getProcessPayment() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        ModelAndView modelAndView = new ModelAndView("paymentProcessing");

        modelAndView.addObject("paymentSum", user.getOrderEntity().getPaymentEntity().getPaymentSum());
        modelAndView.addObject("userBalance", user.getBalance());

        return modelAndView;
    }

    @PostMapping("/createOrder.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView createOrderForUser(CreateOrderForUserRequest request) throws ParseException {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        System.out.println("REQUEST IN CREATEORDERSERVICE: " + request);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate beginDate = LocalDate.parse(request.getBeginDate(), formatter);
        LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);

        if (beginDate.isBefore(LocalDate.now())
            || endDate.isBefore(beginDate)
            || endDate.isAfter(LocalDate.now().plusYears(1))) {
            return new ModelAndView("dateError"); //TODO add dateError jsp page
        }

        if (user.getOrderEntity() != null) {
            return new ModelAndView("index"); //TODO redirect to order delete page
        }

        CarEntity carEntity = createOrderService.findCarAndCheckIfAvailable(request.getCarId());

        OrderEntity orderEntity = OrderEntity.builder()
                .beginDate(beginDate)
                .endDate(endDate)
                .message(request.getMessage())
                .carEntity(carEntity)
                .build();

        carEntity.setOrderEntity(orderEntity);

        String redirect = createOrderService.createOrderForUser(orderEntity, user);

        createOrderService.updateDb(orderEntity, carEntity);

        return new ModelAndView(redirect);
    }

    @GetMapping("/paymentEntity.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView paymentEntityGet() {
        return new ModelAndView("createPaymentEntity");
    }

    @PostMapping("/paymentEntity.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String createPaymentEntity(CreatePaymentEntityRequest request) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate paymentDate = LocalDate.parse(request.getPaymentDate(), formatter);

        if (paymentDate.isBefore(LocalDate.now())
            || paymentDate.isAfter(user.getOrderEntity().getBeginDate())) {
            return "redirect:/dateError.html";
        }

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentDate(paymentDate)
                .isPaid(false)
                .build();

        createPaymentEntityService.createPaymentEntity(paymentEntity, userGetFromContextHolderService.getUserFromSecurityContextHolder());

        return "redirect:/processPayment.html"; //TODO add redirect
    }

    @PostMapping("/processPayment.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String paymentProcessing(ProcessPaymentRequest request) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        PaymentEntity paymentEntity = user.getOrderEntity().getPaymentEntity();

        if ((request.getCheckoutPayment() > paymentEntity.getPaymentSum()) || request.getCheckoutPayment() <= 0) {
            return "redirect:/paymentError.html";
        }

        if (user.getBalance() - request.getCheckoutPayment() <= 0) {
            return "redirect:/addBalance.html";
        }

        user.setBalance(user.getBalance() - request.getCheckoutPayment());
        paymentEntity.setPaymentSum(paymentEntity.getPaymentSum() - request.getCheckoutPayment());

        if (paymentEntity.getPaymentSum() == 0) {
            paymentEntity.setIsPaid(true);
            userService.update(user);
            paymentService.update(paymentEntity);
        }

        userService.update(user);
        paymentService.update(paymentEntity);

        return "redirect:/userResultInfo.html";
    }
}
