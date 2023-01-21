package my.ohrem.request.add;

import lombok.Data;

@Data
public class AddCarRequest {
    private Long carId;
    private String brand;
    private String model;
    private String color;
    private Double price;
    private String description;
    private Boolean isAvailable;
}
