package my.ohrem.web;

import lombok.SneakyThrows;
import my.ohrem.model.UserEntity;
import my.ohrem.request.AddUserForAdminRequest;
import my.ohrem.service.service.AppUserService;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AddUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/add-user.html")
    public String showEmployeeList() {
        return "add_user";
    }

    @PostMapping("/add-user.html")
    @Secured("ROLE_ADMIN")
    @SneakyThrows
    public String addUser(@RequestParam("photo") MultipartFile file, AddUserForAdminRequest request) {
        System.out.println("Call addEployee: " + request);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password("{noop}" + request.getPassword())
                .phone(request.getPhone())
                .role(request.getRole())
                .balance(0.0)
                .build();

        userService.add(user, file.getBytes());
        return "redirect:/user-list.html";
    }
}
