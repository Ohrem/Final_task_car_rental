package my.ohrem.web.admin.view;

import my.ohrem.model.OrderEntity;
import my.ohrem.repository.OrderEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewOrderController {

    @Autowired
    private OrderEntityDao orderEntityDao;

    @GetMapping("/{order.id}/viewOrderAdmin.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView viewOrder(@PathVariable("order.id") long id) {
        ModelAndView modelAndView = new ModelAndView("showSelectedOrder");
        OrderEntity order = orderEntityDao.findOrderEntityById(id);

        modelAndView.addObject("beginDate", order.getBeginDate().toString());
        modelAndView.addObject("endDate", order.getEndDate().toString());
        modelAndView.addObject("message", order.getMessage());

        return modelAndView;
    }
}
