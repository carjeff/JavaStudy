package connection_pool.dbcp;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author JeffCar
 * @date 12/23/2020 - 3:40 AM
 */
public class DbcpTest {
    private static DataSource source;
    static {

        try {
            Properties properties = new Properties();

            FileInputStream fis = new FileInputStream(new File("src/dbcp.properties"));
            properties.load(fis);
            source = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        Connection connection = source.getConnection();
        return connection;
    }
    @Test
    public void testGetConnection() throws SQLException {
        BasicDataSource  source = new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&rewriteBatchedStatements=true");
        source.setUsername("root");
        source.setPassword("chezijie");
        Connection connection = source.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test() throws Exception {

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream(new File("src/dbcp.properties"));
        properties.load(fis);
        DataSource source = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = source.getConnection();
        System.out.println(connection);
    }


}
