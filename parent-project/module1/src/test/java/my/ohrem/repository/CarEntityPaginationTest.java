package my.ohrem.repository;

import lombok.SneakyThrows;
import my.ohrem.model.CarEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarEntityPaginationTest extends BaseDaoTest{

    @Autowired
    CarEntityDao carEntityDao;

    @Test
    @SneakyThrows
    public void testPagination() {
        int page = 2;
        int entryAmount = 3;
        List<CarEntity> carEntities = carEntityDao.readAllPageable(page, entryAmount);

        assertNotNull(carEntities);
    }

    @Test
    @SneakyThrows
    public void testCount() {
        Long count = carEntityDao.countAllAvailable();
        System.out.println("TOTAL AVAILABLE COUNT IS: " + count);
    }
}