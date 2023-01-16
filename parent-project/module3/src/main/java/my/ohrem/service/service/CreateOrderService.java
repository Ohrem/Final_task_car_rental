package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
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
        System.out.println("USER" + user);

        orderEntity.setUserEntity(user);
        user.setOrderEntity(orderEntity);

        orderEntityDao.create(orderEntity);

        return "createPaymentEntity";
    }

    public CarEntity findCarAndCheckIfAvailable(Long id) {
        CarEntity carEntity = carEntityDao.findById(id);

        if (carEntity.getIsAvailable()) {
            carEntity.setIsAvailable(false);
            return carEntity;
        } else return null;
    }

    public void updateDb(OrderEntity orderEntity, CarEntity carEntity) {
        orderEntityDao.update(orderEntity);
        carEntityDao.update(carEntity);
    }
}