package dao;

import bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/21/2020 - 6:28 PM
 */
public class CustomerDAOImp extends BaseDAO<Customer> implements CustomersDAO{
    @Override
    public void insert(Connection connection, Customer customer) throws Exception {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) throws Exception {
        String sql = "delete from customers where id = ?";
        update(connection, sql, id);

    }

    @Override
    public void updateById(Connection connection, int id, Customer customer) throws Exception {
        String sql = "update customers set name = ?, email = ?, birth = ? where id = ?";
        update(connection, sql, customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql ="select id,name,email,birth from customers where id =?";
        return getInstance(connection,  sql, id);
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql ="select id,name,email,birth from customers";
        List<Customer> list = getListInstance(connection, sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) throws SQLException {

        String sql = "select count(*) from customers";
        return getValue(connection, sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) throws SQLException {
        String sql = "select max(birth) from customers";

        return getValue(connection, sql);
    }
}
