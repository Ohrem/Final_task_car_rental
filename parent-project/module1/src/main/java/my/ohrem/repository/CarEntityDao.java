package my.ohrem.repository;

import my.ohrem.model.CarEntity;

import java.util.List;

public interface CarEntityDao {

    void create(CarEntity car);

    CarEntity findById(long id);

    void update(CarEntity car);

    void delete(long id);

    void delete(CarEntity car);

    List<CarEntity> readAll();

    List<CarEntity> readAllPageable(Integer page, Integer entryAmount);

    Long countAllAvailable();
}
