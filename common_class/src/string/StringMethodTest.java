package string;

import org.junit.Test;

import javax.sound.midi.SoundbankResource;

/**
 * @author JeffCar
 * @date 11/28/2020 - 12:38 AM
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));

        System.out.println(s1.isEmpty());

        String s2 = s1.toUpperCase();  //大写
        System.out.println(s2);

        String s3 = "  he llow   rold   ";
        String s4 = s3.trim(); //去除  首尾空格
        System.out.println(s3);
        System.out.println(s4);


        String s5 = "abc";
        String s6 = "abe";
        System.out.println(s5.compareTo(s6)); // -2

        String s7 ="车子杰牛逼";
        System.out.println(s7.substring(3));  //左闭  右开
        System.out.println(s7.substring(0,3));
    }

    @Test
    public void test2(){
        String s1 = "helloworld";
        String s2 = "HELLOworld";
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "avc";
        String s4 = "asdf";
        System.out.println(s3.concat(s4));
    }

    @Test
    public void test3(){
        
    }
}
