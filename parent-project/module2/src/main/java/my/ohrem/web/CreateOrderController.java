package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.request.CreateOrderForUserRequest;
import my.ohrem.request.CreatePaymentEntityRequest;
import my.ohrem.request.ProcessPaymentRequest;
import my.ohrem.service.service.*;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @GetMapping("/createOrder.html")
//    @Secured("ADMIN")
    public ModelAndView getCreateOrder() {
        ModelAndView modelAndView = new ModelAndView("createOrder");
        modelAndView.addObject("allCars", carService.getAllAvailable());

        return modelAndView;
    }

    @GetMapping("/processPayment.html")
    public ModelAndView getProcessPayment() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        ModelAndView modelAndView = new ModelAndView("paymentProcessing");

        modelAndView.addObject("paymentSum", user.getOrderEntity().getPaymentEntity().getPaymentSum());
        modelAndView.addObject("userBalance", user.getBalance());

        return modelAndView;
    }

    @PostMapping("/createOrder.html")
//    @Secured("ADMIN")
    public ModelAndView createOrderForUser(CreateOrderForUserRequest request) throws ParseException {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        System.out.println("REQUEST IN CREATEORDERSERVICE: " + request);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate beginDate = LocalDate.parse(request.getBeginDate(), formatter);
        LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);

        if(beginDate.isBefore(LocalDate.now())
                || endDate.isBefore(beginDate)
                || endDate.isAfter(LocalDate.now().plusYears(1))) {
            return new ModelAndView("dateError"); //TODO add dateError jsp page
        }

//        if(request.getBeginDate() == null || request.getEndDate() == null || request.getCarId() == null) {
//            return new ModelAndView("errorPage"); //TODO error page
//        }

        if(user.getOrderEntity() != null){
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

    @PostMapping("/paymentEntity.html")
    public String createPaymentEntity(CreatePaymentEntityRequest request) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate paymentDate = LocalDate.parse(request.getPaymentDate(), formatter);

        if(paymentDate.isBefore(LocalDate.now())
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
    public String paymentProcessing(ProcessPaymentRequest request) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        PaymentEntity paymentEntity = user.getOrderEntity().getPaymentEntity();

        if(request.getCheckoutPayment() > paymentEntity.getPaymentSum()) {
            return "redirect:/error.html"; //TODO create error page and add controller!!!!!
        }

        if(user.getBalance() - request.getCheckoutPayment() <= 0) {
            return "redirect:/addBalance.html"; //TODO add money to the balance service redirect
        }

        user.setBalance(user.getBalance() - request.getCheckoutPayment());
        paymentEntity.setPaymentSum(paymentEntity.getPaymentSum() - request.getCheckoutPayment());

        if(paymentEntity.getPaymentSum() == 0) {
            paymentEntity.setIsPaid(true);
            userService.update(user);
            paymentService.update(paymentEntity);
            return "redirect:/userResultInfo.html";
        }

        userService.update(user);
        paymentService.update(paymentEntity);

        return "redirect:/index.html"; //TODO add redirect
    }
}
