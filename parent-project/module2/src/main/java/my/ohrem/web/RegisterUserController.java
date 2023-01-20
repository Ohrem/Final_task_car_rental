package my.ohrem.web;

import my.ohrem.model.UserEntity;
import my.ohrem.model.UserRole;
import my.ohrem.request.RegisterUserRequest;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static my.ohrem.util.ValidationUtil.isValidRegistrationRequest;

@Controller
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register.html")
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("registerUser");
    }

    @PostMapping("/register.html")
    public String postRegistrationPage(@RequestParam("photo") MultipartFile file, RegisterUserRequest request) throws IOException {
        System.out.println("Call addEployee: " + request);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        if(!isValidRegistrationRequest(request) || userService.findUserByEmail(request.getEmail()) != null)
            return "redirect:/registrationError.html";

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password("{noop}" + request.getPassword())
                .phone(request.getPhone())
                .role(UserRole.USER)
                .balance(0.0)
                .build();

        userService.add(user, file.getBytes());

        return "redirect:/login";
    }
}
