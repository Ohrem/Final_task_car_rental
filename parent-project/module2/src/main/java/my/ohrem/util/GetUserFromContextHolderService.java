package my.ohrem.util;

import my.ohrem.model.UserEntity;
import my.ohrem.repository.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserFromContextHolderService {

    @Autowired
    private UserEntityDao userEntityDao;

    public UserEntity getUserFromSecurityContextHolder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();

        UserEntity user = userEntityDao.findSingleUserByEmail(currentEmail);

        System.out.println(user);

        return user;
    }
}
