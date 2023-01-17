package my.ohrem.web;

import lombok.SneakyThrows;
import my.ohrem.model.CarDescription;
import my.ohrem.model.CarEntity;
import my.ohrem.request.UpdateCarRequest;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddCarController {
    @Autowired
    private CarService carService;

    @GetMapping("/add-car.html")
    @Secured("ROLE_ADMIN")
    public String showCarList() {
        return "add_car";
    }

    @PostMapping("/add-car.html")
    @Secured("ROLE_ADMIN")
    @SneakyThrows
    public String addCar(@RequestParam("photo") MultipartFile file, UpdateCarRequest request) {
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        CarDescription carDescription = new CarDescription();
        carDescription.setDescription(request.getDescription());

        CarEntity car = CarEntity.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .price(request.getPrice())
                .carDescription(carDescription)
                .isAvailable(true)
                .build();

        carDescription.setCar(car);

        carService.add(car, file.getBytes());
        return "redirect:/car-list.html";
    }
}
