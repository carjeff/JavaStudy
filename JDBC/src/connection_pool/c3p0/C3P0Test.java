package connection_pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author JeffCar
 * @date 12/23/2020 - 3:17 AM
 */
public class C3P0Test {
    //连接池 只创建一次
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    public Connection getConnection() throws SQLException {
        Connection connection = cpds.getConnection();
        return connection;
    }
    @Test
    public void test() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&rewriteBatchedStatements=true" );
        cpds.setUser("root");
        cpds.setPassword("chezijie");
        //设置初始值连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }


    //使用配置文件

    @Test
    public void test2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
