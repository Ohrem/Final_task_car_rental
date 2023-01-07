package my.ohrem.repository;

import my.ohrem.model.PaymentEntity;

import java.util.List;

public interface PaymentEntityDao {

    void create(PaymentEntity payment);

    List<PaymentEntity> readAll();

    void update(PaymentEntity payment);

    void delete(PaymentEntity payment);

}