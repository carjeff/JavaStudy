package dao;

import bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/21/2020 - 5:37 PM
 *
 * 规范
 */
public interface CustomersDAO {
    /**
     * 将customer对象添加到数据库中
     * @param connection
     * @param customer
     */
    void insert(Connection connection, Customer customer) throws Exception;

    void deleteById(Connection connection, int id) throws Exception;

    void updateById(Connection connection, int id, Customer customer) throws Exception;

    Customer getCustomerById(Connection connection, int id);

    List<Customer> getAll(Connection connection);

    Long getCount(Connection connection) throws SQLException;

    Date getMaxBirth(Connection connection) throws SQLException;
}
