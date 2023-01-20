package my.ohrem.service.service;

import my.ohrem.model.CarEntity;
import my.ohrem.repository.CarEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCarService {

    private final CarEntityDao carInfoDao;

    @Autowired
    @Qualifier("simpleHttpClient")
    private HttpClient httpClient;

    @Autowired
    public SearchCarService(CarEntityDao carInfoDao) {
        this.carInfoDao = carInfoDao;
    }

    public List<CarEntity> search(String pattern) {
        if (pattern == null) {
            return Collections.emptyList();
        }
        return carInfoDao.readAll().stream()
                .filter(carInfo -> carInfo
                        .getBrand()
                        .toLowerCase()
                        .contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }
}
