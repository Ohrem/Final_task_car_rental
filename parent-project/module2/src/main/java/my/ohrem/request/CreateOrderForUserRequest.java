package my.ohrem.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateOrderForUserRequest {
    private String beginDate;
    private String endDate;
    private String message;
    private Long carId;
}
