package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CarListController {
    @Autowired
    private CarService carService;

    @GetMapping("/car-list.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "getAllCars",
                Map.of("cars", carService.getAllAvailable())
        );
    }

    @GetMapping("/car-list-user.html")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ModelAndView showCarListForUsers() {
        return new ModelAndView(
                "getAllCarsForUsers",
                Map.of("cars", carService.getAllAvailable())
        );
    }

    @ResponseBody
    @GetMapping("/image/{car.id}/carPhoto.jpg")
    public byte[] getCarImage(@PathVariable("car.id") long carId) {
        System.out.println("Call getImage: " + carId);
        CarEntity car = carService.getCarEntity(carId);
        return car.getCarPhoto().getPhoto();
    }

}
