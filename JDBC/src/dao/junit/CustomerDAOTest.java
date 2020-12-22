package dao.junit;

import Utils.JDBCUtils;
import bean.Customer;
import dao.CustomerDAOImp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

/**
 * @author JeffCar
 * @date 12/21/2020 - 6:43 PM
 */
public class CustomerDAOTest {
    private CustomerDAOImp dao = new CustomerDAOImp();
    @Test
    public void testInsert(){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Customer che = new Customer(1, "chezi", "chezi@126.com", new Date(1241231233L));
            dao.insert(connection,che);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }
}
