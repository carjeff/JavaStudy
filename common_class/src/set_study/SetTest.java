package set_study;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author JeffCar
 * @date 12/2/2020 - 4:07 PM
 */
public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet<>();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(132);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
