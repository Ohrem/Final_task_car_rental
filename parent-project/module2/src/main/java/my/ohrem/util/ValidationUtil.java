package my.ohrem.util;

import my.ohrem.request.*;
import my.ohrem.request.add.AddUserForAdminRequest;
import my.ohrem.request.update.UpdateCarRequest;
import my.ohrem.request.update.UpdateUserRequest;
import my.ohrem.service.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationUtil {

    @Autowired
    private UserService userService;

    public static Boolean isValidRegistrationRequest(RegisterUserRequest request) {
        String regexEmail = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
        String regexName = "^([A-Za-z]{1,18})$";
        String regexSurname = "^([A-Za-z]{1,25})$";
        String regexPassword = "^[a-zA-Z0-9].{4,}";
        String regexPhone = "^(\\+)?[0-9]{12}";

        return !StringUtils.isEmpty(request.getPassword())
               && !StringUtils.isEmpty(request.getRepeatPassword())
               && !StringUtils.isEmpty(request.getName())
               && !StringUtils.isEmpty(request.getSurname())
               && !StringUtils.isEmpty(request.getPhone())
               && !StringUtils.isEmpty(request.getEmail())
               && request.getPassword().equals(request.getRepeatPassword())
               && request.getEmail().matches(regexEmail)
               && request.getName().matches(regexName)
               && request.getSurname().matches(regexSurname)
               && request.getPassword().matches(regexPassword)
               && request.getRepeatPassword().matches(regexPassword)
               && request.getPhone().matches(regexPhone);
    }

    public static Boolean isValidAdminAddUserRequest(AddUserForAdminRequest request) {
        String regexEmail = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
        String regexName = "^([A-Za-z]{1,18})$";
        String regexSurname = "^([A-Za-z]{1,25})$";
        String regexPassword = "^[a-zA-Z0-9].{4,}";
        String regexPhone = "^(\\+)?[0-9]{12}";

        return !StringUtils.isEmpty(request.getPassword())
               && !StringUtils.isEmpty(request.getName())
               && !StringUtils.isEmpty(request.getSurname())
               && !StringUtils.isEmpty(request.getPhone())
               && !StringUtils.isEmpty(request.getEmail())
               && request.getEmail().matches(regexEmail)
               && request.getName().matches(regexName)
               && request.getSurname().matches(regexSurname)
               && request.getPassword().matches(regexPassword)
               && request.getPhone().matches(regexPhone);
    }

    public static Boolean isValidAdminUpdateUserRequest(UpdateUserRequest request) {
        String regexEmail = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
        String regexName = "^([A-Za-z]{1,18})$";
        String regexSurname = "^([A-Za-z]{1,25})$";
        String regexPassword = "^[a-zA-Z0-9].{4,}";
        String regexPhone = "^(\\+)?[0-9]{12}";

        return !StringUtils.isEmpty(request.getPassword())
               && !StringUtils.isEmpty(request.getName())
               && !StringUtils.isEmpty(request.getSurname())
               && !StringUtils.isEmpty(request.getPhone())
               && !StringUtils.isEmpty(request.getEmail())
               && !StringUtils.isEmpty(request.getRole())
               && request.getEmail().matches(regexEmail)
               && request.getName().matches(regexName)
               && request.getSurname().matches(regexSurname)
               && request.getPassword().matches(regexPassword)
               && request.getPhone().matches(regexPhone)
               && (request.getRole().equals("USER")
                   || request.getRole().equals("ADMIN"));
    }

    public static Boolean isValidAddCarRequest(UpdateCarRequest request) {
        return !StringUtils.isEmpty(request.getBrand())
               && !StringUtils.isEmpty(request.getModel())
               && !StringUtils.isEmpty(request.getColor())
               && request.getPrice() != null
               && request.getIsAvailable() != null;
    }
}
