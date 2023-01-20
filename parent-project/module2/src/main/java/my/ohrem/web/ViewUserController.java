package my.ohrem.web;

import my.ohrem.model.UserEntity;
import my.ohrem.service.service.UserService;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GetUserFromContextHolderService getUserFromContextHolderService;

    @GetMapping("/{user_id}/viewUserAdmin.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView viewUser(@PathVariable("user_id") long id) {
        ModelAndView modelAndView = new ModelAndView("showSelectedUser");
        UserEntity user = userService.getById(id);

        modelAndView.addObject("userId", user.getId());
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("surname", user.getSurname());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("phone", user.getPhone());
        modelAndView.addObject("role", user.getRole().toString());
        modelAndView.addObject("balance", user.getBalance());

        return modelAndView;
    }

    @GetMapping("/myProfile.html")
    @Secured("ROLE_USER")
    public ModelAndView viewMyProfile() {
        ModelAndView modelAndView = new ModelAndView("myProfile");
        UserEntity user = userService.getById(getUserFromContextHolderService.getUserFromSecurityContextHolder().getId());

        modelAndView.addObject("userId", user.getId());
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("surname", user.getSurname());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("phone", user.getPhone());
        modelAndView.addObject("role", user.getRole().toString());
        modelAndView.addObject("balance", user.getBalance());

        return modelAndView;
    }
}
