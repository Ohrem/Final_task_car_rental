package my.ohrem.web;

import my.ohrem.model.UserEntity;
import my.ohrem.model.UserRole;
import my.ohrem.request.UpdateUserRequest;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class UpdateUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}/updateUserAdmin.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView updateUser(@PathVariable("user_id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateUserAdmin");

        modelAndView.addObject("userId", id);

        return modelAndView;
    }

    @PostMapping("/updateUserAdmin.html")
    @Secured("ROLE_ADMIN")
    public String updateUserPost(@RequestParam("photo") MultipartFile file, UpdateUserRequest request) throws IOException {
        UserEntity user = userService.getById(request.getUserId());

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setBalance(request.getBalance());

        switch (request.getRole()) {
            case "USER":
                user.setRole(UserRole.USER);
                break;
            case "ADMIN":
                user.setRole(UserRole.ADMIN);
                break;
            default:
                user.setRole(UserRole.USER);
                break;
        }

        userService.add(user, file.getBytes());
        return "redirect:/user-list.html";
    }
}
