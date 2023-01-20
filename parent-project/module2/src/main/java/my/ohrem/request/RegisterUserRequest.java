package my.ohrem.request;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;
    private String phone;
}
