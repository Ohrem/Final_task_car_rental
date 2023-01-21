package my.ohrem.web.admin.update;

import my.ohrem.model.CarDescription;
import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarDescriptionDao;
import my.ohrem.request.update.UpdateCarRequest;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static my.ohrem.util.ValidationUtil.isValidAddCarRequest;

@Controller
public class UpdateCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarDescriptionDao carDescriptionDao;

    @GetMapping("/{car.id}/updateCarAdmin.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView updateCar(@PathVariable("car.id") long id) {
        ModelAndView modelAndView = new ModelAndView("updateCarAdmin");

        modelAndView.addObject("carId", id);

        return modelAndView;
    }

    @PostMapping("/updateCarAdmin.html")
    @Secured("ROLE_ADMIN")
    public String updateCarPost(@RequestParam("photo") MultipartFile file, UpdateCarRequest request) throws IOException {
        CarEntity car = carService.getCarEntity(request.getCarId());
        CarDescription carDescription;

        System.out.println("UPDATECARREQUEST: " + request);

        if(!isValidAddCarRequest(request))
            return "redirect:/addCarError.html";

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

        carService.addPhotoToCarEntity(car, file.getBytes());

        carService.update(car);
        carDescriptionDao.update(carDescription);

        return "redirect:/car-list.html?page=1";
    }

}
