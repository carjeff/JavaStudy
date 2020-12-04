package set_study;

import org.junit.Test;

import javax.swing.text.Keymap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author JeffCar
 * @date 12/3/2020 - 7:57 PM
 */
public class MapTest {

    @Test
    public void test(){
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("BB", 112);
        map.put("CC", 23);
        map.put("AA", 123);

        System.out.println(map);


        //遍历 Map
        //遍历所有key集
        Set set = map.keySet();
        Iterator iterator = set.iterator();

        //遍历所有的value集合
        Collection values = map.values();


        //遍历所有key-value
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test2(){
        TreeMap treeMap = new TreeMap();

    }

    @Test
    public void test3() throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name +":     " +password);
    }
}
