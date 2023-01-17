package my.ohrem.repository;

import my.ohrem.config.MysqlJdbcDataSource;
import my.ohrem.model.CarDescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarDescriptionDaoImpl implements CarDescriptionDao {

    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public CarDescriptionDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(CarDescription carDescription) {
        sessionFactory.getCurrentSession().saveOrUpdate(carDescription);
    }

    @Override
    public CarDescription findById(long id) {
        return sessionFactory.getCurrentSession().get(CarDescription.class, id);
    }


    @Override
    public void update(CarDescription carDescription) {
        create(carDescription);
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void delete(long id) {
        sessionFactory.getCurrentSession().createQuery("delete from CarDescription where id=" + id).executeUpdate();
    }

    @Override
    public void delete(CarDescription car) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(car);
        session.delete(car);
    }

    @Override
    public List<CarDescription> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from CarDescription", CarDescription.class).list();
    }

}
