package my.ohrem.web;

import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteCarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{car.id}/deleteCarAdmin.html")
    public String deleteCarAdmin(@PathVariable("car.id") long id) {
        carService.delete(id);

        return "redirect:/car-list.html";
    }
}
