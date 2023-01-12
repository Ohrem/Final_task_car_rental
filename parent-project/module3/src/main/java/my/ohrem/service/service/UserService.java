package my.ohrem.service.service;

import my.ohrem.model.UserEntity;
import my.ohrem.repository.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserEntityDao userEntityDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(UserEntity user) { //TODO Add photo
        userEntityDao.create(user);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return userEntityDao.findAll();
    }

    public UserEntity getById(long userId) {
        return userEntityDao.findById(userId);
    }

    @Transactional
    public void update(UserEntity user) {
        userEntityDao.update(user);
    }

}
