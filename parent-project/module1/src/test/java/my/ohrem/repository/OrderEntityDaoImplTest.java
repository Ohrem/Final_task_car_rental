package my.ohrem.repository;
import lombok.SneakyThrows;
import my.ohrem.model.CarEntity;
import my.ohrem.model.OrderEntity;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import static my.ohrem.repository.BaseDaoTest.iDatabaseConnection;
import static my.ohrem.repository.BaseDaoTest.testMysqlJdbcDataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderEntityDaoImplTest extends BaseDaoTest {
    @Autowired
    OrderEntityDao targetObject;

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

        conn.createStatement().executeUpdate("delete from orders");
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from orders;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        OrderEntity order = OrderEntity.builder()
                .beginDate(LocalDate.of(2023, 11, 10))
                .endDate(LocalDate.of(2023,12,10))
                .message("commit message")
                .build();

        //When
        targetObject.create(order);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from orders;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("delete from orders");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();
    }
    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("OrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        OrderEntity order = targetObject.findOrderEntityById(1L);

        //Then
        assertEquals("2023-01-01", order.getBeginDate().toString());
        assertEquals("2023-01-06", order.getEndDate().toString());
        assertEquals("first message", order.getMessage());
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void update() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("OrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from orders;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(3, initialSize);

        //When
        OrderEntity order = targetObject.findOrderEntityById(2L);
        assertNotNull(order);

        OrderEntity updatedOrder = OrderEntity.builder()
                .id(2L)
                .beginDate(LocalDate.parse("2023-10-28"))
                .endDate(LocalDate.parse("2023-11-04"))
                .message("first updated message")
                .build();

        targetObject.update(updatedOrder);

        assertEquals(LocalDate.parse("2023-10-28"), updatedOrder.getBeginDate());
        assertEquals(LocalDate.parse("2023-11-04"), updatedOrder.getEndDate());
        assertEquals("first updated message", updatedOrder.getMessage());

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from orders;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(3, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table orders;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("OrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        OrderEntity order = targetObject.findOrderEntityById(3L);
        assertNotNull(order);
        targetObject.delete(order);
        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from orders;");
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
                .build(UserEntityDaoImplTest.class.getResourceAsStream("OrderDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<OrderEntity> orders = targetObject.readAll();

        //Then
        assertEquals(orders.size(), 3);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

}
