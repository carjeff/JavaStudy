package set_study;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JeffCar
 * @date 12/4/2020 - 12:02 PM
 */
public class DaoTest {

    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1,20,"che"));
        dao.save("1002",new User(2,24,"csd"));
        dao.save("1003",new User(3,25,"sd"));
        List<User> list = dao.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
