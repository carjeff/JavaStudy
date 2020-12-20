package transaction;

import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author JeffCar
 * @date 12/20/2020 - 9:08 PM
 */
public class TransactionTest {

    @Test
    public void test(){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            //取消数据的自动提交功能
            connection.setAutoCommit(false);

            String sql = "update user_table set balance = balance - 100 where user = ?";
            update(connection,sql ,"AA" );

            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(connection, sql2, "BB");

            System.out.println("转帐成功");

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();

            //回滚操作
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(connection, null);
        }


    }



    private int update(Connection connection,String sql , Object ... args) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }

        return 0;
    }
}
