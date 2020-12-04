package set_study;

import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author JeffCar
 * @date 12/1/2020 - 10:26 PM
 */
public class ForTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("afsds");
        collection.add(new Person("小明",20));
        collection.add(new Person("小hong",25));
        collection.add(new Person("小wang",22));
        collection.add("AA");
        collection.add("afsdsds");


        //增强for循环
        for (Object obj : collection){
            System.out.println(obj);
        }
    }


    @Test
    public void test2(){
        String[] arr = new String[] {"sajf","alsjdf","asd"};

        for (String s : arr){  //将arr赋值给s   所以原先arr是不变的

            s = "gg";
        }
        System.out.println(arr[0]);
    }

}
