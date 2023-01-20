package my.ohrem.restreceiver.mapper;

import lombok.Data;

@Data
public class RestMapperFromServer {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
