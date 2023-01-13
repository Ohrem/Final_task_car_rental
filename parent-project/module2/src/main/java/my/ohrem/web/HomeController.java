package my.ohrem.web;
import my.ohrem.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @GetMapping({"/","index.html"})
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("cars", carService.getAll());

        System.out.println("Call homePage");
        return modelAndView;
    }

}