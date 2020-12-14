import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author JeffCar
 * @date 12/14/2020 - 9:00 AM
 *
 * 终止操作
 */
public class StreamAPITest2 {
    //1. 匹配与查找
    @Test
    public void test(){
        //allMatch(Predicate e)  全部都
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 0);
        System.out.println(b);

        //anyMatch  有一个就行
        boolean b1 = employees.stream().anyMatch(e -> e.getAge() > 5);
        System.out.println(b1);

        //noneMatch 没有一个匹配的
        boolean a = employees.stream().noneMatch(e -> e.getName().contains("a"));
        System.out.println(a);

        //findFirst
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

        //count
        long count = employees.stream().count();
        System.out.println(count);

        //max(Comparator c)
        Optional<Employee> max = employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(max);
        //min
        //forEach

    }

    //2-归约
    @Test
    public void test2(){
        //reduce(T identity, BinaryOperator)  identity  是初始值
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Integer> reduce1 = employees.stream().map(e -> e.getAge()).reduce((a, b) -> a + b);
        System.out.println(reduce1);

        Optional<Integer> reduce2 = employees.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println(reduce2);

    }

    //3-收集
    @Test
    public void test3(){
        //collect(Collector c)
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getAge() > 2).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect1 = employees.stream().collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
