package my.ohrem.repository;

import my.ohrem.model.CarDescription;
import my.ohrem.model.CarEntity;

import java.util.List;

public interface CarDescriptionDao {

    void create(CarDescription carDescription);

    CarDescription findById(long id);

    void update(CarDescription carDescription);

    void delete(long id);

    void delete(CarDescription carDescription);

    List<CarDescription> readAll();
}
