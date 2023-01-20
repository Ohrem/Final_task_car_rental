package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import my.ohrem.repository.OrderEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderEntityDao orderEntityDao;

    public List<OrderEntity> getAllAvailableWithPagination(Integer pageNumber, Integer pageAmount) {
        return orderEntityDao.readAllPageable(pageNumber, pageAmount);
    }

    public Long countAllAvailable() {
        return orderEntityDao.countAllAvailable();
    }
}
