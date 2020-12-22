package connection_pool.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
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
 * @date 12/23/2020 - 4:06 AM
 */
public class druidTest {
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File("src/druid.properties"));

            properties.load(fileInputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    @Test
    public void test() throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File("src/druid.properties"));

        properties.load(fileInputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
