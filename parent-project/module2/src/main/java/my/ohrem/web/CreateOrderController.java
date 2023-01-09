package my.ohrem.web;

import my.ohrem.model.OrderEntity;
import my.ohrem.request.CreateOrderForUserRequest;
import my.ohrem.service.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class CreateOrderController {

    @Autowired
    private CreateOrderService createOrderService;

    @GetMapping("/createOrder.html")
//    @Secured("ADMIN")
    public String getCreateOrder() {
        return "createOrder";
    }

    @PostMapping("/createOrder.html")
//    @Secured("ADMIN")
    public ModelAndView createOrderForUser(CreateOrderForUserRequest request) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        OrderEntity orderEntity = OrderEntity.builder()
                .beginDate(LocalDate.parse(request.getBeginDate(), formatter))
                .endDate(LocalDate.parse(request.getEndDate(), formatter))
                .message(request.getMessage())
                .build();

        System.out.println("ORDERENTITY: " + orderEntity);

        createOrderService.createOrderForUser(orderEntity);
        return new ModelAndView("index");
    }
}
