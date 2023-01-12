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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
            return "index";
        }

        orderEntity.setUserEntity(user);
        user.setOrderEntity(orderEntity);

        orderEntityDao.create(orderEntity);

        return "createPaymentEntity";
    }

    public void addCarToOrder(Long id, UserEntity user) {
        OrderEntity orderEntity = user.getOrderEntity();

        CarEntity carEntity = carEntityDao.findById(id);
        carEntity.setIsAvailable(false);

        orderEntity.setCarEntity(carEntity);
        carEntity.setOrderEntity(orderEntity);

        carEntityDao.update(carEntity);
        orderEntityDao.update(orderEntity);
    }

    public void createPaymentAndAddToOrder(LocalDate paymentDate, UserEntity user) {
        OrderEntity orderEntity = user.getOrderEntity();
        CarEntity carEntity = orderEntity.getCarEntity();

        long between = ChronoUnit.DAYS.between(orderEntity.getBeginDate(), orderEntity.getEndDate());
        Double paymentSum = carEntity.getPrice() * between;

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .orderEntity(orderEntity)
                .paymentDate(paymentDate)
                .paymentSum(paymentSum)
                .isPaid(false)
                .build();

        orderEntity.setPaymentEntity(paymentEntity);
        paymentEntity.setOrderEntity(orderEntity);

        paymentEntityDao.create(paymentEntity);
        orderEntityDao.update(orderEntity);
    }

    public void performPaymentForOrder(UserEntity user) {
        OrderEntity orderEntity = user.getOrderEntity();
        PaymentEntity paymentEntity = orderEntity.getPaymentEntity();

        Double paymentSum = paymentEntity.getPaymentSum();

        if (user.getBalance() >= paymentSum) {
            user.setBalance(user.getBalance() - paymentSum);
            paymentEntity.setIsPaid(true);

            paymentEntityDao.update(paymentEntity);
            userEntityDao.update(user);
        } else return; //TODO add exception
    }
}
