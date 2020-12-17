import Utils.JDBCUtils;
import bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.sql.Connection;

/**
 * @author JeffCar
 * @date 12/17/2020 - 9:02 PM
 */
public class CustomerForQuery {

    public Customer queryForCustomers(String sql, Object ... args){
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

            ResultSetMetaData metaData = resultSet.getMetaData(); //获取结果集的元数据
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                Customer customer = new Customer();
                for (int i = 0; i<columnCount; i++){
                    Object value = resultSet.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);


                    //给customer指定属性赋值为value,, 通过反射
                    Field declaredField = Customer.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(customer, value);

                }
                return customer;
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
        String sql = "select id,name,email,birth from customers where id = ?";
        String sql1 = "select id, name from customers where name = ?";
//        Customer customer = queryForCustomers(sql, 13);
        Customer customer = queryForCustomers(sql1, "张学友");
        System.out.println(customer);
    }
    @Test
    public void test(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select id,name,email,birth from customers where id = ?";

            ps = connection.prepareStatement(sql);

            ps.setObject(1, 1);

            resultSet = ps.executeQuery();

            //处理结果集
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);

    //            Object[] data = new Object[] {id,name,email,date};

                Customer customer = new Customer(id, name, email, date);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }

    }
}
