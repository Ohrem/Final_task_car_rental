package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarEntityDao carEntityDao;

    @Transactional
    public void addNewCar(CarEntity car) {
        //TODO: add field validations; check product name duplication;
        carEntityDao.create(car);
    }

    public List<CarEntity> getAll() {
        return carEntityDao.readAll().stream()
                .filter(car -> car.getIsAvailable().equals(true))
                .collect(Collectors.toList());
    }

    public CarEntity getCarEntity(Long carId) {
        return carEntityDao.findById(carId);
    }
}