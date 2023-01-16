package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class    CarListController {
    @Autowired
    private CarService carService;

    @GetMapping("/car-list.html")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "getAllCars",
                Map.of("cars", carService.getAllAvailable())
        );
    }

    @ResponseBody
    @GetMapping("/image/{car.id}/photo.jpg")
    public byte[] getCarImage(@PathVariable("car.id") long carId) {
        System.out.println("Call getImage: " + carId);
        CarEntity car = carService.getCarEntity(carId);
        return car.getCarPhoto().getPhoto();
    }
}
