package my.ohrem.web;

import my.ohrem.model.CarEntity;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewCarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{car.id}/viewCar.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView viewCar(@PathVariable("car.id") long id) {
        ModelAndView modelAndView = new ModelAndView("showSelectedCar");
        CarEntity carEntity = carService.getCarEntity(id);

        System.out.println("CarEntity in viewCar: " + carEntity);

        modelAndView.addObject("carId", carEntity.getId());
        modelAndView.addObject("brand", carEntity.getBrand());
        modelAndView.addObject("model", carEntity.getModel());
        modelAndView.addObject("color", carEntity.getColor());
        modelAndView.addObject("price", carEntity.getPrice());

        if (carEntity.getCarDescription() != null)
            modelAndView.addObject("description", carEntity.getCarDescription().getDescription());


        return modelAndView;
    }
}
