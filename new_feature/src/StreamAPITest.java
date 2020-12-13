import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author JeffCar
 * @date 12/14/2020 - 12:11 AM
 *
 * 1. Stream关注的是对数据的运算'
 * 2. Steam操作是延迟的
 *
 * 3. Stream执行流程，
 *    - Stream的实例化
 *    - 中间操作(过滤，映射·····)
 *    - 终止操作
 */

public class StreamAPITest {
    //创建Stream 方式一： 通过集合
    @Test
    public void test(){
        List<Employee> list = EmployeeData.getEmployees();
        //返回顺序流
        Stream<Employee> stream = list.stream();
        //返回并行流
        Stream<Employee> employeeStream = list.parallelStream();

    }

    //创建Stream 方式二： 通过数组
    @Test
    public void test2(){
        int[] arr = new int[] {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

    }

    //创建Stream 方式三: 通过Stream的of
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
    }

    //创建Stream 方式四： 创建无限流
    @Test
    public void test4(){
        Stream.iterate(0, s -> s+2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
