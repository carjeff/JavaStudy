package string;

import org.junit.Test;

import javax.sound.midi.SoundbankResource;

/**
 * @author JeffCar
 * @date 11/27/2020 - 11:31 PM
 */
public class StringTest {


    @Test
    public void test1(){
        String s1 = "abc";  //字面量的定义方式  放在常量池中
        String s2 = "abc";
        //s1 = "hello!";
        System.out.println(s1 == s2);  //true
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);  //重新指定
        String s4 = "abcdef";
        System.out.println(s3 == s4); //
    }

    @Test
    public void test2(){
        String s1 = "javaEE";
        String s2 = "javaEE";

        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2 ); //true
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s3); //false
    }

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;


        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5); //false
        System.out.println(s5 == s6); //false


        String s7 = s5.intern();
        System.out.println(s3 == s7);//true
    }

}
