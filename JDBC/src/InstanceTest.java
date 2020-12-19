import Utils.JDBCUtils;
import bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/20/2020 - 1:23 AM
 */

public class InstanceTest {


    /**
     * 获取一个对象时
     * @param c
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> c ,String sql, Object ... args){
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
                T t = c.newInstance();
                for (int i=0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = c.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }

        return null;
    }

    /**
     * 获取多个对象时
     * @param c
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> getListInstance(Class<T> c, String sql, Object ... args){
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

            ArrayList<T> arrayList = new ArrayList<>();
            while (resultSet.next()){
                T t = c.newInstance();
                for (int i=0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = c.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                arrayList.add(t);
            }

            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }

        return null;
    }

    @Test
    public void test(){
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer instance = getInstance(Customer.class, sql, 1);
        System.out.println(instance);
    }

    @Test
    public void test2(){
        String sql = "select id,name,email from customers where id < ?";
        List<Customer> listInstance = getListInstance(Customer.class, sql, 12);
        listInstance.forEach(System.out::println);
    }
}
