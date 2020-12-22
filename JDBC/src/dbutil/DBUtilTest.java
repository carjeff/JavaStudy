package dbutil;

import Utils.JDBCUtils;
import bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author JeffCar
 * @date 12/23/2020 - 4:19 AM
 */
public class DBUtilTest {
    @Test
    public void testInsert(){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int update = runner.update(connection, sql, "chezijie", "chezijie@123.com", "2000-01-01");
            System.out.println(update);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }

    @Test
    public void testQuery() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,email from customers where id = ?";
        QueryRunner runner = new QueryRunner();

        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
        Customer query = runner.query(connection, sql, handler, 1);
        System.out.println(query);

    }
    @Test
    public void testQuery1() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,email from customers where id > ?";
        QueryRunner runner = new QueryRunner();

        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> query = runner.query(connection, sql, handler, 2);
        query.forEach(System.out::println);

    }

    //使用maphandler
    @Test
    public void testQuery2() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,email from customers where id > ?";
        QueryRunner runner = new QueryRunner();

        MapHandler handler = new MapHandler();
        Map<String, Object> query = runner.query(connection, sql, handler, 2);
        System.out.println(query);

    }

    //使用 scalarhandler
    @Test
    public void testQuery3() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select count(*) from customers";
        QueryRunner runner = new QueryRunner();

        ScalarHandler handler = new ScalarHandler();
        Long count = (Long) runner.query(connection, sql, handler);
        System.out.println(count);

    }

}
