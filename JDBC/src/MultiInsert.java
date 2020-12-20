import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * 批量insert
 * @author JeffCar
 * @date 12/20/2020 - 7:12 PM
 */
public class MultiInsert {

    @Test
    public void test(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {

            long l = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values(?)";
            ps = connection.prepareStatement(sql);
            for (int i=0; i<20000; i++){
                ps.setObject(1, "name_"+i);

                //1. 攒 sql
                ps.addBatch();

                //2. 执行batch
                if (i % 500 ==0){
                    ps.executeBatch();
                //3. 清空batch
                    ps.clearBatch();
                }
//                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }

    }


    //批量操作最终版
    @Test
    public void fina(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {

            long l = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            //不允许自动提交数据
            connection.setAutoCommit(false);
            String sql = "insert into goods(name) values(?)";
            ps = connection.prepareStatement(sql);
            for (int i=0; i<20000; i++){
                ps.setObject(1, "name_"+i);

                //1. 攒 sql
                ps.addBatch();

                //2. 执行batch
                if (i % 500 ==0){
                    ps.executeBatch();
                    //3. 清空batch
                    ps.clearBatch();
                }
//                ps.execute();
            }
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println(end - l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }
    }
}
