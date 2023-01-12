package my.ohrem.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePaymentEntityRequest {
    private String paymentDate;
}
