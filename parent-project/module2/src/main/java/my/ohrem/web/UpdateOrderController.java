package my.ohrem.web;

import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.OrderEntityDao;
import my.ohrem.request.UpdateOrderRequest;
import my.ohrem.service.service.CreatePaymentEntityService;
import my.ohrem.service.service.PaymentService;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class UpdateOrderController {

    @Autowired
    private OrderEntityDao orderEntityDao; //TODO create order service

    @Autowired
    private CreatePaymentEntityService createPaymentEntityService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @GetMapping("/{order.id}/updateOrderAdmin.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView updateOrder(@PathVariable("order.id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateOrderAdmin");

        modelAndView.addObject("orderId", id);

        return modelAndView;
    }

    @PostMapping("/updateOrderAdmin.html")
    @Secured("ROLE_ADMIN")
    public String updateOrderPost(UpdateOrderRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate beginDate = LocalDate.parse(request.getBeginDate(), formatter);
        LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);

        OrderEntity order = orderEntityDao.findOrderEntityById(request.getOrderId());
        PaymentEntity paymentEntity = order.getPaymentEntity();
        UserEntity user = order.getUserEntity();

        if (beginDate.isBefore(LocalDate.now())
            || endDate.isBefore(beginDate)
            || endDate.isAfter(LocalDate.now().plusYears(1))) {
            return "redirect:/securityError.html";
        }

        double finalSum = createPaymentEntityService.countFinalSum(order);

        double returningAmount = finalSum - paymentEntity.getPaymentSum();

        user.setBalance(user.getBalance() + returningAmount);

        order.setBeginDate(beginDate);
        order.setEndDate(endDate);
        order.setMessage(request.getMessage());

        paymentEntity.setPaymentSum(createPaymentEntityService.countFinalSum(order));
        paymentEntity.setIsPaid(false);

        userService.update(user);
        paymentService.update(paymentEntity);
        orderEntityDao.update(order);

        return "redirect:/order-list.html?page=1";
    }
}
