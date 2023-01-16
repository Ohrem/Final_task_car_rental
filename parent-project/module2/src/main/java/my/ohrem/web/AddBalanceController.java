package my.ohrem.web;

import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.request.AddBalanceRequest;
import my.ohrem.request.CreatePaymentEntityRequest;
import my.ohrem.service.service.UserService;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class AddBalanceController {

    @Autowired
    private UserService userService;

    @Autowired
    private GetUserFromContextHolderService getUserService;

    @GetMapping("/addBalance.html")
    public ModelAndView addBalanceAccess() {
        return new ModelAndView("addBalance");
    }

    @PostMapping("/addBalance.html")
    public String addBalance(AddBalanceRequest request) {
        UserEntity user = getUserService.getUserFromSecurityContextHolder();

        if (request.getAddBalanceSum() > 0)
            user.setBalance(user.getBalance() + request.getAddBalanceSum());

        userService.update(user);

        return "redirect:/userResultInfo.html";
    }
}
