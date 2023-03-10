package my.ohrem.repository;

import my.ohrem.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class UserEntityDaoImpl implements UserEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(UserEntity user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public UserEntity findById(long id) {
        return sessionFactory.getCurrentSession().get(UserEntity.class, id);
    }

    @Override
    public void update(UserEntity user) {
        create(user);
    }

    @Override
    public void delete(UserEntity user) {
        UserEntity loadedUser = sessionFactory.getCurrentSession().load(UserEntity.class, user.getId());
        sessionFactory.getCurrentSession().delete(loadedUser);
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from UserEntity ", UserEntity.class).list();
    }

    @Override
    public List<UserEntity> findUserByEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("from UserEntity au where au.email=:email", UserEntity.class)
                .setParameter("email", email)
                .list();
    }

    @Override
    public UserEntity findSingleUserByEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("from UserEntity user where user.email=:email", UserEntity.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public List<UserEntity> readAllPageable(Integer page, Integer entryAmount) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<UserEntity> userEntityQuery = currentSession.createQuery("from UserEntity", UserEntity.class);
        userEntityQuery.setFirstResult((page - 1) * entryAmount);
        userEntityQuery.setMaxResults(entryAmount);

        return userEntityQuery.list();
    }

    @Override
    public Long countAllAvailable() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from app_user");
        return  ((BigInteger) query.uniqueResult()).longValue();
    }
}