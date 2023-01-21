package my.ohrem.web.admin.list;
import my.ohrem.model.UserEntity;

import my.ohrem.service.service.UserService;
import my.ohrem.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserListController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaginationUtil paginationUtil;

    @GetMapping("/user-list.html")
    @Secured("ROLE_ADMIN")
    public ModelAndView showEmployeeList(@RequestParam("page") Integer pageNumber) {
        return paginationUtil.createPaginationForUserList(pageNumber, "getAllUsers");
    }

    @ResponseBody
    @GetMapping("/image/{user.id}/userPhoto.jpg")
    public byte[] getImage(@PathVariable("user.id") long userId) {
        System.out.println("Call getImage: " + userId);
        UserEntity user = userService.getById(userId);
        return user.getUserPhoto().getPhoto();
    }
}

