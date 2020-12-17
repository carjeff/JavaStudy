import org.junit.Test;

import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author JeffCar
 * @date 12/16/2020 - 8:28 PM
 */
public class Connection {

    @Test
    public void ConnectionTest() throws SQLException {

        //方式一:

        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "chezijie");
        java.sql.Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }
    //方式二: 用反射
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "chezijie");

        java.sql.Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }

    //方式三:
    @Test
    public void test3() throws Exception {

        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        DriverManager.registerDriver(driver);

        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "chezijie";
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    //方式四：  优化
    @Test
    public void test4() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "chezijie";
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    //方式五：最终版  利用配置文件
    @Test
    public void test5() throws Exception {
        //1 读取配置文件
        InputStream is = Connection.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");


        Class.forName(driverClass);

        java.sql.Connection connection = DriverManager.getConnection(url, user, password);


        System.out.println(connection);
    }
}
