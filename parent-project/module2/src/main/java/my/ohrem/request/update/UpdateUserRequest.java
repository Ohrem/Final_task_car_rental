package my.ohrem.request.update;

import lombok.Data;
import my.ohrem.model.UserPhoto;
import my.ohrem.model.UserRole;

@Data
public class UpdateUserRequest {
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String role;
    private Double balance;
    private UserPhoto userPhoto;
}