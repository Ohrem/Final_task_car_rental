package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.model.UserPhoto;
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

    @Transactional
    public void add(UserEntity user, byte[] photo) {
        if (user.getUserPhoto() == null) {
            UserPhoto userPhoto = new UserPhoto();
            userPhoto.setUser(user);
            userPhoto.setPhoto(photo);
            user.setUserPhoto(userPhoto);
        }
        userEntityDao.create(user);
    }
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

    public void delete(long id) { //TODO check
        userEntityDao.delete(userEntityDao.findById(id));
    }

    public List<UserEntity> getAllAvailableWithPagination(Integer pageNumber, Integer pageAmount) {
        return userEntityDao.readAllPageable(pageNumber, pageAmount);
    }

    public UserEntity findUserByEmail(String email) {
        return userEntityDao.findSingleUserByEmail(email);
    }

    public Long countAllAvailable() {
        return userEntityDao.countAllAvailable();
    }

}
