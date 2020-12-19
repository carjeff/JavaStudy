import Utils.JDBCUtils;
import bean.Order;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author JeffCar
 * @date 12/20/2020 - 12:20 AM
 */
public class OrederForQuery {

    public Order queryForOrder(String sql, Object ... args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i=0; i<args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                Order order = new Order();
                for (int i =0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field declaredField = Order.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(order, value);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }

        return null;
    }


    @Test
    public void test2(){
        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id = ?";
        Order order = queryForOrder(sql, 1);
        System.out.println(order);
    }

    @Test
    public void test() throws IOException, ClassNotFoundException, SQLException, NoSuchFieldException, IllegalAccessException {
        //1. 读取配置文件
//        OrederForQuery.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        //2. 读取参数，并设置
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        //3. 生成connection 连接
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);

        //4. 传入sql语句
        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        //5. 设置占位符 参数
        ps.setObject(1, 1);

        //6. 执行sql语句 , 获取结果集
        ResultSet resultSet = ps.executeQuery();
        //7. 获取结果集得元数据
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();
        if (resultSet.next()){
            Order order = new Order();
            for (int i=0; i<columnCount; i++){
                //8. 获取结果集的每列数据
                Object value = resultSet.getObject(i + 1);

                String columnLabel = metaData.getColumnLabel(i + 1);
                Field declaredField = Order.class.getDeclaredField(columnLabel);
                declaredField.setAccessible(true);
                declaredField.set(order, value);
            }

            System.out.println(order);
        }

    }
}
