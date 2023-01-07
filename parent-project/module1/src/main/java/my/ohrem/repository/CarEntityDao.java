package my.ohrem.repository;

import my.ohrem.model.CarEntity;

public interface CarEntityDao {

    void create(CarEntity car);

    CarEntity findById(long id);

    void update(CarEntity car);

    void delete(long id);

    void delete(CarEntity car);
}
