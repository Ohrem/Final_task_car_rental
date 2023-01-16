package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.CreatePaymentEntityService;
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
    private GetUserFromContextHolderService userGetFromContextHolderService;

    @Autowired
    private CreatePaymentEntityService paymentEntityService;

//    @GetMapping("/getAllUsers.html")
////    @Secured("ADMIN")
//    public ModelAndView getAllUsers() {
//        return new ModelAndView("getAllUsers",
//                Map.of("users", userService.getAll()));
//    }

    @GetMapping("/getAllCars.html")
    public ModelAndView getAllCars() {
        return new ModelAndView("getAllCars",
                Map.of("cars", carService.getAllAvailable()));
    }

    @GetMapping("/userResultInfo.html")
    public ModelAndView getUserResultInfo() {
        UserEntity user = userGetFromContextHolderService.getUserFromSecurityContextHolder();
        ModelAndView modelAndView;

        if (user.getOrderEntity() != null) {
            modelAndView = new ModelAndView("userResultInfo"); //TODO add jsp

            modelAndView.addObject("paymentSum", paymentEntityService.countFinalSum(user.getOrderEntity()));
            modelAndView.addObject("restPayment", user.getOrderEntity().getPaymentEntity().getPaymentSum());
            modelAndView.addObject("orderCar", user.getOrderEntity().getCarEntity());
            modelAndView.addObject("remainingDays", DAYS.between(user.getOrderEntity().getBeginDate(), user.getOrderEntity().getEndDate()));
        } else modelAndView = new ModelAndView("createOrder");

        return modelAndView;
    }
}