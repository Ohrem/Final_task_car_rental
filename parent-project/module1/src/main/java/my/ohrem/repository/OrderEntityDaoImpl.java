package my.ohrem.repository;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
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
public class OrderEntityDaoImpl implements OrderEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(OrderEntity order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    public List<OrderEntity> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from OrderEntity", OrderEntity.class).list();
    }

    @Override
    public void update(OrderEntity order) {
        create(order);
    }

    @Override
    public void delete(OrderEntity order) {
        OrderEntity loadedOrder = sessionFactory.getCurrentSession().load(OrderEntity.class, order.getId());
        sessionFactory.getCurrentSession().delete(loadedOrder);
    }

    @Override
    public OrderEntity findOrderEntityById(Long id) {
        return sessionFactory.getCurrentSession().get(OrderEntity.class, id);
    }
    @Override
    public List<OrderEntity> readAllPageable(Integer page, Integer entryAmount) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<OrderEntity> carEntityQuery = currentSession.createQuery("from OrderEntity" , OrderEntity.class);
        carEntityQuery.setFirstResult((page - 1) * entryAmount);
        carEntityQuery.setMaxResults(entryAmount);

        return carEntityQuery.list();
    }

    @Override
    public Long countAllAvailable() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from orders");
        return  ((BigInteger) query.uniqueResult()).longValue();
    }
}