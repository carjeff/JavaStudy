import Utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author JeffCar
 * @date 12/17/2020 - 8:14 PM
 *
 * 增删改  void
 *
 * 查   有返回值
 *
 */
public class PreparedStatementTest {
    //向customers表添加一条记录
    @Test
    public void test(){
        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 读取配置文件
            InputStream is = Connection.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");


            Class.forName(driverClass);

            connection = DriverManager.getConnection(url, user, password);

            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Tom");
            preparedStatement.setString(2, "Tom@gmail.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("1000-01-01");
            preparedStatement.setDate(3,new java.sql.Date(parse.getTime()));

            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {

            //资源的关闭

            if (preparedStatement!=null){

                try {
                    preparedStatement.close();
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

    }

    @Test
    public void test2(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, "莫扎特");
            ps.setObject(2, 18);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }



    }


    //通用的增删改操作
    public void update(String sql, Object ... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);  //
            }

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }


    }

    @Test
    public void test3(){
        String sql = "delete from customers where id = ?";
        update(sql, 3);
    }

}
