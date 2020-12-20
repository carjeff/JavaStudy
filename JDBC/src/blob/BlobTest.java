package blob;

import Utils.JDBCUtils;
import bean.Customer;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @author JeffCar
 * @date 12/20/2020 - 5:54 PM
 */
public class BlobTest {
    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setObject(1, "车子杰");
        ps.setObject(2, "chezijie@qq.com");
        ps.setObject(3, "1999-03-20");
        FileInputStream fis = new FileInputStream("image.png");
        ps.setBlob(4, fis);
        ps.execute();

        JDBCUtils.closeResource(connection, ps);
    }

    @Test
    public void test2() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "select id, name, email, birth, photo from customers where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 20);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Date date = resultSet.getDate("birth");

            Customer customer = new Customer(id, name, email, date);
            System.out.println(customer);

            //将blob以文件形式保存下来
            Blob photo = resultSet.getBlob("photo");
            InputStream is = photo.getBinaryStream();
            FileOutputStream fos = new FileOutputStream("image2.png");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }
            is.close();
            fos.close();
        }

        JDBCUtils.closeResource(connection, preparedStatement);
    }
}
