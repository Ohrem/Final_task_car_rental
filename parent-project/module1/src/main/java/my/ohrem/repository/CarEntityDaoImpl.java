package my.ohrem.repository;

import my.ohrem.config.MysqlJdbcDataSource;
import my.ohrem.model.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        List<CarEntity> cars = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection()) {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
            while (resultSet.next()) {
                final CarEntity carInfo = new CarEntity();
                carInfo.setId(resultSet.getLong("id"));
                carInfo.setBrand(resultSet.getString("brand"));
                carInfo.setModel(resultSet.getString("model"));
                carInfo.setColor(resultSet.getString("color"));
                carInfo.setPrice(resultSet.getDouble("price"));
                cars.add(carInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}