package my.ohrem.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateOrderRequest {
    private Long orderId;
    private String beginDate;
    private String endDate;
    private String message;
}
