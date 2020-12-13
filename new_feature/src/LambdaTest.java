import org.junit.Test;

import java.util.Comparator;

/**
 * @author JeffCar
 * @date 12/13/2020 - 9:11 PM
 */
public class LambdaTest {

    @Test
    public void test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        runnable.run();
        System.out.println("***********");
        Runnable r2 = () -> {
                System.out.println("我爱北京故宫");
        };
        r2.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int com = com1.compare(12,21);
        System.out.println(com);
        System.out.println("******************");


        //Lambda表达式写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int comm = com2.compare(12,21);
        System.out.println(com);
        System.out.println("*****************");


        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int comm3 = com2.compare(12,21);
        System.out.println(com);
    }
}
