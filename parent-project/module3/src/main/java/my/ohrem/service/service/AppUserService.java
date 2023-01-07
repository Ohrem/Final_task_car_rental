package my.ohrem.service.service;

import my.ohrem.model.UserEntity;
import my.ohrem.repository.UserEntityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    UserEntityDaoImpl userEntityDao;

    public List<UserEntity> findUserByEmail(String username) {
        return userEntityDao.findUserByEmail(username);
    }
}
