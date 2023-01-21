package my.ohrem.request.update;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateCarRequest {
    private Long carId;
    private String brand;
    private String model;
    private String color;
    private Double price;
    private String description;
    private Boolean isAvailable;
}