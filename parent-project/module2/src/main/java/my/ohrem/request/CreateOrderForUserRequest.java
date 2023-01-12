package my.ohrem.request;

import lombok.Data;

@Data
public class CreateOrderForUserRequest {
    private String beginDate;
    private String endDate;
    private String message;
    private Long carId;
}
