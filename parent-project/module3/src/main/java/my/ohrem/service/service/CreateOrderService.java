package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.CarEntityDao;
import my.ohrem.repository.OrderEntityDao;
import my.ohrem.repository.PaymentEntityDao;
import my.ohrem.repository.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateOrderService {

    @Autowired
    private OrderEntityDao orderEntityDao;

    @Autowired
    private CarEntityDao carEntityDao;

    @Autowired
    private UserEntityDao userEntityDao;

    @Autowired
    private PaymentEntityDao paymentEntityDao;

    public String createOrderForUser(OrderEntity orderEntity, UserEntity user) {
        System.out.println(user);

        if(user.getOrderEntity() != null){
            return "index"; //TODO redirect to order delete page
        }

        orderEntity.setUserEntity(user);
        user.setOrderEntity(orderEntity);

        orderEntityDao.create(orderEntity);

        return "createPaymentEntity";
    }

    public void addCarToOrder(Long id, UserEntity user, OrderEntity orderEntity) {
        CarEntity carEntity = carEntityDao.findById(id);

        carEntity.setIsAvailable(false);

        orderEntity.setCarEntity(carEntity);
        carEntity.setOrderEntity(orderEntity);

        carEntityDao.update(carEntity);
        orderEntityDao.update(orderEntity);
    }
}