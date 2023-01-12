package my.ohrem.service.service;

import my.ohrem.model.PaymentEntity;
import my.ohrem.repository.PaymentEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //TODO add all CRUD methods
public class PaymentService {

    @Autowired
    private PaymentEntityDao paymentEntityDao;

    @Transactional
    public void update(PaymentEntity paymentEntity) {
        paymentEntityDao.update(paymentEntity);
    }
}
