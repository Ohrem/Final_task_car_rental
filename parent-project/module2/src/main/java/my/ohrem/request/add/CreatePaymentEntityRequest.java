package my.ohrem.request.add;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePaymentEntityRequest {
    private String paymentDate;
}
