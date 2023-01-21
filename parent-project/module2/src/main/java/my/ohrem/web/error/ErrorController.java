package my.ohrem.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/dateError.html")
    public ModelAndView dateError() {
        return new ModelAndView("dateError");
    }

    @GetMapping("/securityError.html")
    public ModelAndView securityError() {
        return new ModelAndView("securityError");
    }

    @GetMapping("/paymentError.html")
    public ModelAndView paymentError() {
        return new ModelAndView("paymentError");
    }

    @GetMapping("/registrationError.html")
    public ModelAndView registrationError() {
        return new ModelAndView("registrationError");
    }

    @GetMapping("/addCarError.html")
    public ModelAndView addCarError() {
        return new ModelAndView("addCarError");
    }

    @GetMapping("/balanceError.html")
    public ModelAndView balanceError() {
        return new ModelAndView("balanceError");
    }
}