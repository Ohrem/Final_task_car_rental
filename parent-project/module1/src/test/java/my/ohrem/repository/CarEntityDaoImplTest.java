package my.ohrem.repository;
import lombok.SneakyThrows;
import my.ohrem.model.CarEntity;
import my.ohrem.model.UserEntity;
import my.ohrem.model.UserRole;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarEntityDaoImplTest extends BaseDaoTest {
    @Autowired
    CarEntityDao targetObject;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        conn.createStatement().executeUpdate("delete from car");
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from car;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        CarEntity car = CarEntity.builder()
                .brand("BMW")
                .model("M5 Competition")
                .color("blue")
                .price(130.23)
                .isAvailable(true)
                .build();

        //When
        targetObject.create(car);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from car;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("delete from car");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();
    }
    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        CarEntity car = targetObject.findById(99);

        //Then
        assertEquals("Volvo", car.getBrand());
        assertEquals("V60 crossCountry", car.getModel());
        assertEquals("red", car.getColor());
        assertEquals(true, car.getIsAvailable());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
    @Test
    @SneakyThrows
    public void update() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from car;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(3, initialSize);

        //When
        CarEntity car = targetObject.findById(100);
        assertNotNull(car);

        CarEntity updatedCar = CarEntity.builder()
                .id(100L)
                .brand("FERRARI")
                .model("F8")
                .color("red")
                .price(Double.valueOf("999.99"))
                .isAvailable(true)
                .build();

        targetObject.update(updatedCar);

        assertEquals("FERRARI", updatedCar.getBrand());
        assertEquals("F8", updatedCar.getModel());
        assertEquals("red", updatedCar.getColor());
        assertEquals(Double.valueOf("999.99"), updatedCar.getPrice());
        assertEquals(true, updatedCar.getIsAvailable());

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from car;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(3, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table car;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        CarEntity user = targetObject.findById(100);
        assertNotNull(user);
        targetObject.delete(user);
        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from car;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(2, actualSize);

        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table car;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<CarEntity> cars = targetObject.readAll();

        //Then
        assertEquals(cars.size(), 3);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
    @Test
    @SneakyThrows
    public void countAllAvailable() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("CarDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from car where isAvailable = false;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(1, initialSize);

        //Then
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table car;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}
