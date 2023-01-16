package my.ohrem.web;

import lombok.SneakyThrows;
import my.ohrem.model.CarEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.UserService;
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
    public String showCarList() {
        return "add_car";
    }

    @PostMapping("/add-car.html")
    @Secured("ROLE_ADMIN")
    @SneakyThrows
    public String addCar(@RequestParam("photo") MultipartFile file, CarEntity car) {
        System.out.println("Call addCar: " + car);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        carService.addNewCar(car, file.getBytes());
        return "redirect:/car-list.html";
    }
}
