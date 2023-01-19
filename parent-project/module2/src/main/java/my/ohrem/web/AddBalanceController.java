package my.ohrem.web;

import my.ohrem.model.UserEntity;
import my.ohrem.request.AddBalanceRequest;
import my.ohrem.service.service.UserService;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddBalanceController {

    @Autowired
    private UserService userService;

    @Autowired
    private GetUserFromContextHolderService getUserService;

    @GetMapping("/addBalance.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView addBalanceAccess() {
        return new ModelAndView("addBalance");
    }

    @PostMapping("/addBalance.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String addBalance(AddBalanceRequest request) {
        UserEntity user = getUserService.getUserFromSecurityContextHolder();

        if (request.getAddBalanceSum() > 0)
            user.setBalance(user.getBalance() + request.getAddBalanceSum());

        userService.update(user);

        return "redirect:/userResultInfo.html";
    }

}
