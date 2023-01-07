package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.model.PaymentEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.repository.CarEntityDaoImpl;
import my.ohrem.repository.OrderEntityDaoImpl;
import my.ohrem.repository.PaymentEntityDaoImpl;
import my.ohrem.repository.UserEntityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CreateOrderService {

    @Autowired
    private OrderEntityDaoImpl orderEntityDao;

    @Autowired
    private CarEntityDaoImpl carEntityDao;

    @Autowired
    private UserEntityDaoImpl userEntityDao;

    @Autowired
    private PaymentEntityDaoImpl paymentEntityDao;

    private UserEntity getUserFromSecurityContextHolder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();

        return userEntityDao.findUserByEmail(currentEmail).get(0);
    }

    public void createOrderForUser(OrderEntity orderEntity) {
        UserEntity user = getUserFromSecurityContextHolder();

        orderEntity.setUserEntities(user);
        user.setOrderEntity(orderEntity);

        orderEntityDao.create(orderEntity);
    }

    public void addCarToOrder(Long id) {
        UserEntity user = getUserFromSecurityContextHolder();

        OrderEntity orderEntity = user.getOrderEntity();

        CarEntity carEntity = carEntityDao.findById(id);
        carEntity.setIsAvailable(false);

        orderEntity.setCarEntity(carEntity);
        carEntity.setOrderEntity(orderEntity);

        carEntityDao.update(carEntity);
        orderEntityDao.update(orderEntity);
    }

    public void createPaymentAndAddToOrder(LocalDate paymentDate) {
        UserEntity user = getUserFromSecurityContextHolder();

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

    public void performPaymentForOrder() {
        UserEntity user = getUserFromSecurityContextHolder();

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
