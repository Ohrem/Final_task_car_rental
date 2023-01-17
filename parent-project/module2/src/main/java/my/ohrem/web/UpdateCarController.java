package my.ohrem.web;

import my.ohrem.model.CarDescription;
import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarDescriptionDao;
import my.ohrem.request.AddCarRequest;
import my.ohrem.request.PassIdRequest;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarDescriptionDao carDescriptionDao;

    @GetMapping("/{car.id}/updateCarAdmin.html")
    public ModelAndView updateCar(@PathVariable("car.id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateCarAdmin");

        modelAndView.addObject("carId", id);

        return modelAndView;
    }

    @PostMapping("/updateCarAdmin.html")
    public String updateCarPost(AddCarRequest request) {
        CarEntity car = carService.getCarEntity(request.getCarId());
        CarDescription carDescription;

        if (car.getCarDescription() == null) {
            carDescription = CarDescription.builder()
                    .description(request.getDescription())
                    .build();

            carDescription.setCar(car);
        } else {
            carDescription = car.getCarDescription();
            carDescription.setDescription(request.getDescription());
        }

        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setColor(request.getColor());
        car.setPrice(request.getPrice());
        car.setCarDescription(carDescription);
        car.setIsAvailable(request.getIsAvailable());

        carDescription.setCar(car);

        carService.update(car);
        carDescriptionDao.update(carDescription);

        return "redirect:/car-list.html";
    }

}
