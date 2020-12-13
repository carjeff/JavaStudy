import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author JeffCar
 * @date 12/13/2020 - 10:50 PM
 *
 * java 内置的4大核心函数式接口
 *
 * 消费型接口 Comsumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("comsumer" + aDouble.doubleValue());
            }
        });

        System.out.println("*************");
        happyTime(500, money -> System.out.println("comsumer 变化" + money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","西京","pu");
        ArrayList<String> strings = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(strings);

        System.out.println("***************");


        ArrayList<String> strings1 = filterString(list, s -> s.contains("京"));
        System.out.println(strings1);

    }

    public ArrayList<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s: list){
            if (predicate.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }
}
