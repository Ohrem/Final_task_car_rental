package my.ohrem.dao;

import my.ohrem.model.UserEntity;

import java.util.List;

public interface UserDao {

    void create(UserEntity user);

    UserEntity findById(long id);

    void update(UserEntity user);

    void delete(UserEntity user);

    List<UserEntity> findAll();
}
