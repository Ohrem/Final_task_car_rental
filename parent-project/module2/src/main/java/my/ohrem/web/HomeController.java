package my.ohrem.web;
import my.ohrem.model.UserEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.util.GetUserFromContextHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private CarService carService;

    @Autowired
    private GetUserFromContextHolderService getUserService;

    @GetMapping({"/","index.html"})
    public ModelAndView homePage() {
        UserEntity user = getUserService.getUserFromSecurityContextHolder();

        ModelAndView modelAndView = new ModelAndView("index");

        if(user != null) {
            modelAndView.addObject("loggedUser", user.getRole().toString());
            modelAndView.addObject("balance", user.getBalance());
        }

        modelAndView.addObject("cars", carService.getAllAvailable());

        System.out.println("Call homePage");
        return modelAndView;
    }
}