package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarListController {
    @Autowired
    private CarService carService;

    @Autowired
    private PaginationUtil paginationUtil;

    @GetMapping("/car-list.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView showCarList(@RequestParam("page") Integer pageNumber) {
        return paginationUtil.createPaginationForCarList(pageNumber, "getAllCars");
    }

    @GetMapping("/car-list-user.html")
    public ModelAndView showCarListForUsers(@RequestParam("page") Integer pageNumber) {
        return paginationUtil.createPaginationForCarList(pageNumber, "getAllCarsForUsers");

    }

    @ResponseBody
    @GetMapping("/image/{car.id}/carPhoto.jpg")
    public byte[] getCarImage(@PathVariable("car.id") long carId) {
        System.out.println("Call getImage: " + carId);
        CarEntity car = carService.getCarEntity(carId);
        return car.getCarPhoto().getPhoto();
    }
}
