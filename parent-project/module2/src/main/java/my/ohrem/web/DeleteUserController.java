package my.ohrem.web;

import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}/deleteUserAdmin.html")
    @Secured("ROLE_ADMIN")
    public String deleteUser(@PathVariable("user_id") long id) {
        userService.delete(id);

        return "redirect:/user-list.html";
    }
}
