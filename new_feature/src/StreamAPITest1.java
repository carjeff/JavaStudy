import org.junit.Test;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/14/2020 - 12:31 AM
 */
public class StreamAPITest1 {
    //1. 筛选与切片
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        //filter
        employees.stream().filter(e -> e.getAge() >2).forEach(System.out::println);

        System.out.println();

        //limit限制个数
        employees.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //skip(n)  跳过元素
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println();
        //distinct 筛选  通过hashcode 和 equals判断
        employees.add(new Employee("刘",20));
        employees.add(new Employee("刘",20));
        employees.add(new Employee("刘",20));
        employees.add(new Employee("刘",20));

        employees.stream().distinct().forEach(System.out::println);

    }

    //映射
    @Test
    public void test2(){
        //map
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println();

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(e -> e.getName()).filter(name -> name.length() <2 ).forEach(System.out::println);

        System.out.println();

        //flatMap


    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList<>();
        ArrayList list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);

        list.addAll(list2);
//        list.add(list2);
        System.out.println(list);
    }
}
