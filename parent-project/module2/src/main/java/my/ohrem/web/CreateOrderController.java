package my.ohrem.web;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        OrderEntity orderEntity = OrderEntity.builder()
                .beginDate(LocalDate.parse(request.getBeginDate(), formatter))
                .endDate(LocalDate.parse(request.getEndDate(), formatter))
                .message(request.getMessage())
                .build();

        System.out.println("ORDERENTITY: " + orderEntity);

        createOrderService.addCarToOrder(request.getCarId(), user, orderEntity);

        String redirect = createOrderService.createOrderForUser(orderEntity, user);
        return new ModelAndView(redirect);
    }

    @PostMapping("/paymentEntity.html")
    public String createPaymentEntity(CreatePaymentEntityRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentDate(LocalDate.parse(request.getPaymentDate(), formatter))
                .build();

        createPaymentEntityService.createPaymentEntity(paymentEntity, userGetFromContextHolderService.getUserFromSecurityContextHolder());

        return "redirect:/processPayment.html"; //TODO add redirect
    }

    @PostMapping("/processPayment.html")
    public ModelAndView paymentProcessing(ProcessPaymentRequest request) {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        PaymentEntity paymentEntity = user.getOrderEntity().getPaymentEntity();

        if(request.getCheckoutPayment() > paymentEntity.getPaymentSum()) {
            return new ModelAndView("error"); //TODO create error page
        }

        if(user.getBalance() - request.getCheckoutPayment() <= 0) {
            //TODO add money to the balance service redirect
        }

        user.setBalance(user.getBalance() - request.getCheckoutPayment());
        paymentEntity.setPaymentSum(paymentEntity.getPaymentSum() - request.getCheckoutPayment());

        if(paymentEntity.getPaymentSum() == 0) {
            paymentEntity.setIsPaid(true);
            //TODO redirect to successful payment page
        }

        userService.update(user);
        paymentService.update(paymentEntity);

        return new ModelAndView("index"); //TODO add redirect
    }
}
