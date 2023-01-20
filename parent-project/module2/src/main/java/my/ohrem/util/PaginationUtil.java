package my.ohrem.util;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.OrderService;
import my.ohrem.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class PaginationUtil {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    public ModelAndView createPaginationForCarList(Integer pageNumber, String redirectToJSP) {
        final int recordsPerPage = 5;

        if (pageNumber == null)
            pageNumber = 1;

        ModelAndView modelAndView = new ModelAndView(redirectToJSP);

        List<CarEntity> pagination = carService.getAllAvailableWithPagination(pageNumber, recordsPerPage);

        Long allAvailableCount = carService.countAllAvailable();
        double numberOfPagesForAllAvailable = Math.ceil(allAvailableCount * 1.0 / recordsPerPage);

        modelAndView.addObject("cars", pagination);
        modelAndView.addObject("currentPage", pageNumber);
        modelAndView.addObject("numberOfPages", numberOfPagesForAllAvailable);

        return modelAndView;
    }

    public ModelAndView createPaginationForUserList(Integer pageNumber, String redirectToJSP) {
        final int recordsPerPage = 5;

        if (pageNumber == null)
            pageNumber = 1;

        ModelAndView modelAndView = new ModelAndView(redirectToJSP);

        List<UserEntity> pagination = userService.getAllAvailableWithPagination(pageNumber, recordsPerPage);

        Long allAvailableCount = userService.countAllAvailable();
        double numberOfPagesForAllAvailable = Math.ceil(allAvailableCount * 1.0 / recordsPerPage);

        modelAndView.addObject("users", pagination);
        modelAndView.addObject("currentPage", pageNumber);
        modelAndView.addObject("numberOfPages", numberOfPagesForAllAvailable);

        return modelAndView;
    }

    public ModelAndView createPaginationForOrderList(Integer pageNumber, String redirectToJSP) {
        final int recordsPerPage = 5;

        if (pageNumber == null)
            pageNumber = 1;

        ModelAndView modelAndView = new ModelAndView(redirectToJSP);

        List<OrderEntity> pagination = orderService.getAllAvailableWithPagination(pageNumber, recordsPerPage);

        Long allAvailableCount = orderService.countAllAvailable();
        double numberOfPagesForAllAvailable = Math.ceil(allAvailableCount * 1.0 / recordsPerPage);

        modelAndView.addObject("orders", pagination);
        modelAndView.addObject("currentPage", pageNumber);
        modelAndView.addObject("numberOfPages", numberOfPagesForAllAvailable);

        return modelAndView;
    }
}
