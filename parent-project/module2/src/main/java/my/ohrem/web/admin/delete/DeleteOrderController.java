package my.ohrem.web.admin.delete;

import my.ohrem.model.OrderEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.OrderEntityDao;
import my.ohrem.service.service.CarService;
import my.ohrem.service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteOrderController {

    @Autowired
    private OrderEntityDao orderEntityDao; //TODO service!

    @Autowired
    private CarService carService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{order.id}/deleteOrderAdmin.html")
    @Secured("ROLE_ADMIN")
    public String deleteOrder(@PathVariable("order.id") long id) {
        OrderEntity order = orderEntityDao.findOrderEntityById(id);

        order.getCarEntity().setIsAvailable(true);

        carService.update(order.getCarEntity());
        paymentService.delete(order.getPaymentEntity());

        return "redirect:/order-list.html?page=1";
    }
}
