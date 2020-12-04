package set_study;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author JeffCar
 * @date 12/2/2020 - 7:38 PM
 */
public class TreeSetTest {
    @Test
    public void test(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if(e1.getBirthday().getYear() > e2.getBirthday().getYear()){
                        return 1;
                    }else if (e1.getBirthday().getYear() < e2.getBirthday().getYear()){
                        return -1;
                    }else {
                        if(e1.getBirthday().getMonth() > e2.getBirthday().getMonth()){
                            return 1;
                        }else if (e1.getBirthday().getMonth() < e2.getBirthday().getMonth()){
                            return -1;
                        }else {
                            if (e1.getBirthday().getDay() > e2.getBirthday().getDay()){
                                return 1;
                            }else if (e1.getBirthday().getDay() < e2.getBirthday().getDay()){
                                return -1;
                            }else {
                                return 0;
                            }
                        }
                    }
                }else {
                    throw new RuntimeException("类型不一致");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new Employee("j",22,new MyDate(1999,3,20)));
        set.add(new Employee("b",22,new MyDate(1999,7,20)));
        set.add(new Employee("u",22,new MyDate(1998,6,20)));
        set.add(new Employee("d",22,new MyDate(1990,5,20)));
        set.add(new Employee("w",22,new MyDate(1991,4,20)));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
