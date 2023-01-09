package my.ohrem.web;

import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Transactional
    public void add(User user, byte[] photo){

    }

    @GetMapping("/getAllUsers.html")
    @Secured("ADMIN")
    public ModelAndView getAllUsers() {
        return new ModelAndView("getAllUsers",
                Map.of("users", userService.getAll()));
    }
}