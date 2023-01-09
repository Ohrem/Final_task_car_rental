package my.ohrem.repository;

import my.ohrem.model.UserEntity;

import java.util.List;

public interface UserEntityDao {

    void create(UserEntity user);

    UserEntity findById(long id);

    void update(UserEntity user);

    void delete(UserEntity user);

    List<UserEntity> findAll();

    List<UserEntity> findUserByEmail(String username);
}
