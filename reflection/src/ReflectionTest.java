import org.junit.Test;

import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author JeffCar
 * @date 12/9/2020 - 6:01 PM
 */
public class ReflectionTest {
    @Test
    public void test(){
        //1.
        Person p1 = new Person("Tome",12);

        p1.age = 20;
        System.out.println(p1.age);

        p1.show();

    }
    //使用反射
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Person.class;
        Constructor constructor = c.getConstructor(String.class, int.class);

        Object o = constructor.newInstance("Tome", 12);
        System.out.println(o.toString());

        Field age = c.getDeclaredField("age");
        age.set(o,121);
        System.out.println(o.toString());



    }


    @Test
    public void test3() throws ClassNotFoundException {

        //方式一： 调用运行时类的属性， .class
        Class c = Person.class;
        System.out.println(c);

        //方式二： 通过运行时类的对象，调用 getClass
        Person p = new Person();
        Class c1 = p.getClass();

        //方式三： 调用Class的静态方法，forName(String classPath)
        Class<?> reflection = Class.forName("reflection");

    }

   //体会反射的动态性
    @Test
    public void test4() throws Exception {
        int num =new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "";
                break;
            case 2:
                classPath = "";
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);

    }

    public Object getInstance(String classPath) throws Exception {
        Class c = Class.forName(classPath);
        return c.newInstance();
    }

    @Test
    public void testField() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class c = Person.class;
        Person o = (Person) c.newInstance();
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"JJJJ");
        Object name1 = name.get(o);

    }
}
