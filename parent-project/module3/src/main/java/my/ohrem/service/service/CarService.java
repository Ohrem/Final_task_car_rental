package my.ohrem.service.service;
import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    private CarEntityDao carEntityDao;

    @Transactional(propagation = Propagation.NESTED)
    public void add(CarEntity car) {
        carEntityDao.create(car);
    }

}