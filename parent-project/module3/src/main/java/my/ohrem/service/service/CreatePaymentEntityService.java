package my.ohrem.service.service;

import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.OrderEntityDao;
import my.ohrem.repository.PaymentEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class CreatePaymentEntityService {

    @Autowired
    private PaymentEntityDao paymentEntityDao;

    @Autowired
    private OrderEntityDao orderEntityDao;

    public void createPaymentEntity(PaymentEntity paymentEntity, UserEntity user) {
        OrderEntity orderEntity = user.getOrderEntity();

        double finalSum = countFinalSum(orderEntity);

        paymentEntity.setPaymentSum(finalSum);

        orderEntity.setPaymentEntity(paymentEntity);
        paymentEntity.setOrderEntity(orderEntity);

        paymentEntityDao.create(paymentEntity);
        orderEntityDao.update(orderEntity);
    }

    public double countFinalSum(OrderEntity orderEntity) {
        Double price = orderEntity.getCarEntity().getPrice();
        long between = DAYS.between(orderEntity.getBeginDate(), orderEntity.getEndDate());

        return price * between;
    }
}
