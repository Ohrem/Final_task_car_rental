package my.ohrem.dao;

import lombok.Data;
import lombok.SneakyThrows;
import my.ohrem.DataConfig;
import my.ohrem.MysqlJdbcDataSource;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/outlet_test.jdbc.properties")
@ContextConfiguration(classes = DataConfig.class)
public class BaseDaoTest {

    // JDBC data source
    static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    static IDatabaseConnection iDatabaseConnection;

    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("outlet_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "outlet_test");
    }
}

