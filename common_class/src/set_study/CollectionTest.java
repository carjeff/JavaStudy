package set_study;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverAnonymous;
import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.*;

/**
 * @author JeffCar
 * @date 12/1/2020 - 8:15 PM
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();

        //add
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Date());

        System.out.println(collection.size());
        Collection collection1 = new ArrayList();
        collection1.add("AA");
        collection1.add("AA");

        collection.addAll(collection1);
        System.out.println(collection.size());

        //isEmpty
        System.out.println(collection.isEmpty());

        //clear
        collection.clear();

    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("afsds");
        collection.add(new Person("小明",20));
        collection.add(new Person("小hong",25));
        collection.add(new Person("小wang",22));
        Collection collection1 = new ArrayList();
        collection1.add("AA");
        collection1.add("afsds");
        //contains
        System.out.println(collection.contains(new Person("小明",20)));  //contains  调用的时equals方法

        //remove
        collection.remove(123);

        //retainAll  求交集
        collection.retainAll(collection1);
        System.out.println(collection);
    }


    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("afsds");
        collection.add(new Person("小明",20));
        collection.add(new Person("小hong",25));
        collection.add(new Person("小wang",22));
        Collection collection1 = new ArrayList();
        collection1.add("AA");
        collection1.add("afsds");

        //hashcode()  返回当前对象的哈希值
        System.out.println(collection.hashCode());


        //集合  --->   数组 ： toArray()
        Object[] arr = collection.toArray();


        //数组 --->  集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "cc"});

    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("afsds");
        collection.add(new Person("小明",20));
        collection.add(new Person("小hong",25));
        collection.add(new Person("小wang",22));
        collection.add("AA");
        collection.add("afsdsds");

        //iterator  迭代器接口
        Iterator iterator = collection.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //遍历操作 推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test5(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("afsds");
        collection.add(new Person("小明",20));
        collection.add(new Person("小hong",25));
        collection.add(new Person("小wang",22));
        collection.add("AA");
        collection.add("afsdsds");

        //iterator 有remove删除方法
    }
}
