package my.ohrem.repository;

import my.ohrem.config.MysqlJdbcDataSource;
import my.ohrem.model.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarEntityDaoImpl implements CarEntityDao {

    private final MysqlJdbcDataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    public CarEntityDaoImpl() {
        this.dataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(CarEntity car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public CarEntity findById(long id) {
        return sessionFactory.getCurrentSession().get(CarEntity.class, id);
    }


    @Override
    public void update(CarEntity car) {
        create(car);
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void delete(long id) {
        sessionFactory.getCurrentSession().createQuery("delete from CarEntity where id=" + id).executeUpdate();
    }

    @Override
    public void delete(CarEntity car) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(car);
        session.delete(car);
    }

    @Override
    public List<CarEntity> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from CarEntity", CarEntity.class).list();
    }

    public List<CarEntity> findCarByBrand(String brand) {
        List<CarEntity> carEntityList = sessionFactory.getCurrentSession().createQuery("from CarEntity", CarEntity.class).list();

        return carEntityList.stream()
                .filter(car -> car.getBrand().equals(brand))
                .collect(Collectors.toList());
    }
}