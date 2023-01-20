package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.OrderEntityDao;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.CreatePaymentEntityService;
import my.ohrem.service.service.PaymentService;
import my.ohrem.service.service.UserService;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderEntityDao orderEntityDao; //TODO create service!!!

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private GetUserFromContextHolderService userGetFromContextHolderService;

    @Autowired
    private CreatePaymentEntityService paymentEntityService;

    @GetMapping("/userResultInfo.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView getUserResultInfo() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();
        ModelAndView modelAndView;

        if(user.getOrderEntity() != null && user.getOrderEntity().getPaymentEntity() == null) {
            return new ModelAndView("createPaymentEntity"); //если мы вышли из процесса и paymentEntity не был создан
        }

        if (user.getOrderEntity() != null && user.getOrderEntity().getPaymentEntity() != null) {
            modelAndView = new ModelAndView("userResultInfo"); //TODO add jsp

            modelAndView.addObject("paymentSum", paymentEntityService.countFinalSum(user.getOrderEntity()));
            modelAndView.addObject("restPayment", user.getOrderEntity().getPaymentEntity().getPaymentSum());
            modelAndView.addObject("orderCar", user.getOrderEntity().getCarEntity());
            modelAndView.addObject("remainingDays", DAYS.between(user.getOrderEntity().getBeginDate(), user.getOrderEntity().getEndDate()));
            modelAndView.addObject("userBalance", user.getBalance());
            modelAndView.addObject("isPaid", user.getOrderEntity().getPaymentEntity().getIsPaid().toString());

        } else {
            modelAndView = new ModelAndView("createOrder");
            modelAndView.addObject("cars", carService.getAllAvailable());
        }

        return modelAndView;
    }

    @GetMapping("/cancelOrder.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String cancelOrder() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();

        OrderEntity orderEntity = user.getOrderEntity();
        orderEntity.getCarEntity().setIsAvailable(true);

        carService.update(orderEntity.getCarEntity());
        paymentService.delete(orderEntity.getPaymentEntity());

        return "redirect:/index.html";
    }
}