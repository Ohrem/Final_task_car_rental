package my.ohrem.request.add;

import lombok.Data;
import lombok.ToString;
import my.ohrem.model.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString
public class AddUserForAdminRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
