package my.ohrem.web;
import my.ohrem.model.UserEntity;

import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserListController {
    @Autowired
    private UserService userService;

    @GetMapping("/user-list.html")
    public ModelAndView showEmployeeList() {
        return new ModelAndView(
                "getAllUsers",
                Map.of("users", userService.getAll())
        );
    }

    @ResponseBody
    @GetMapping("/image/{user.id}/userPhoto.jpg")
    public byte[] getImage(@PathVariable("user.id") long userId) {
        System.out.println("Call getImage: " + userId);
        UserEntity user = userService.getById(userId);
        return user.getUserPhoto().getPhoto();
    }
}

