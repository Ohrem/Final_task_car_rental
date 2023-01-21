package my.ohrem.web.admin.list;

import my.ohrem.repository.OrderEntityDao;
import my.ohrem.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OrderListController {
    @Autowired
    private PaginationUtil paginationUtil;

    @GetMapping("/order-list.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView getOrderList(@RequestParam("page") Integer pageNumber) {
        return paginationUtil.createPaginationForOrderList(pageNumber, "getAllOrders");
    }
}
