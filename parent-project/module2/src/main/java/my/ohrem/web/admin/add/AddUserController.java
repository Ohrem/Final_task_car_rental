package my.ohrem.web.admin.add;

import lombok.SneakyThrows;
import my.ohrem.model.UserEntity;
import my.ohrem.model.UserRole;
import my.ohrem.request.add.AddUserForAdminRequest;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static my.ohrem.util.ValidationUtil.isValidAdminAddUserRequest;


@Controller
public class AddUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/add-user.html")
    @Secured("ROLE_ADMIN")
    public String showEmployeeList() {
        return "add_user";
    }

    @PostMapping("/add-user.html")
    @Secured("ROLE_ADMIN")
    @SneakyThrows
    public String addUser(@RequestParam("photo") MultipartFile file, AddUserForAdminRequest request) {
        System.out.println("Call addEployee: " + request);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        if(!isValidAdminAddUserRequest(request) || userService.findUserByEmail(request.getEmail()) != null)
            return "redirect:/registrationError.html"; //TODO admin registration error

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

        return "redirect:/user-list.html?page=1";
    }
}
