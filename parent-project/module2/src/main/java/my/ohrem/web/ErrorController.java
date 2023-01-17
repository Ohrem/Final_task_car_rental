package my.ohrem.web;

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
}
