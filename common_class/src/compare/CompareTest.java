package compare;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JeffCar
 * @date 12/1/2020 - 4:05 PM
 *
 * 对对象进行比较，排序
 *
 */
public class CompareTest {
    @Test
    public void test(){
        String[] arr = new String[] { "ksd","asdj","sjdl","jwe","jwoex"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Good[] goods = new Good[5];
        goods[0] = new Good("联想",12);
        goods[1] = new Good("联想",34);
        goods[2] = new Good("京东",12);
        goods[3] = new Good("小米",12123);
        goods[4] = new Good("华为",4123);


        //自然排序，实现了Comparable接口。
        //Arrays.sort(goods);

        //定制排序，暂时性实现Comparator接口
        Arrays.sort(goods, new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                if(o1.getPrice() > o2.getPrice()){
                    return 1;
                }else if(o1.getPrice() < o2.getPrice()){
                    return -1;
                }else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(goods));
    }

}
