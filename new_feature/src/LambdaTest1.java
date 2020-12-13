import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author JeffCar
 * @date 12/13/2020 - 10:12 PM
 *
 * (o1,o2) -> Integer.compare(o1,o2);
 *
 * 格式：
 *     -> : Lambda操作符
 *     ->左边: Lambda 形参列表  (其实就是接口中的抽象方法中的形参列表)
 *     ->右边: Lambda体 (其实就是重写抽象方法体)
 *
 * Lambda表达式使用: (分为6种情况)
 *
 *
 * Lambda表达式本质: 作为函数式接口的实例
 *
 * 接口中只有一个抽象方法 叫做 函数式接口
 */
public class LambdaTest1 {
    //1. 无参，无返回值
    @Test
    public void test(){
        Runnable r = () -> System.out.println("我爱北京故宫");
        r.run();
    }

    //2. Lambda需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("输出");

        System.out.println("*******************");

        Consumer<String>  con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("Lambda输出");
    }

    //3.数据类型可以省略，因为可由编译器推断得出，称为类型推断
    @Test
    public void test3(){

        Consumer<String>  con1 = (s) -> {
            System.out.println(s);
        };

        con1.accept("Lambda输出");
    }

    //4. Lambda 若只需要一个参数，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String>  con1 = s -> {
            System.out.println(s);
        };

        con1.accept("Lambda输出");
    }

    //5. 若需要两个或以上的参数，多条执行语句，并且有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("********************");


        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println("***");
            System.out.println("***");
            System.out.println("***");
            return o1.compareTo(o2);
        };
    }

    //6. 当只有一条语句，return 与大括号若有  可以省略
    @Test
    public void test6(){
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println("***");
            System.out.println("***");
            System.out.println("***");
            return o1.compareTo(o2);
        };
        System.out.println("*****************");


        Comparator<Integer> com1 = (o1,o2) -> o1.compareTo(o2);
    }
}
