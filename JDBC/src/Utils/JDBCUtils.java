package Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author JeffCar
 * @date 12/17/2020 - 8:37 PM
 */
public class JDBCUtils {

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //1 读取配置文件
//        InputStream is = Connection.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");


        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement){
        if (statement!=null){

            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet){
        if (statement!=null){

            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
