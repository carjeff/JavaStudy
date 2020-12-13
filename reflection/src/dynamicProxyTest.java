import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Blob;

/**
 * @author JeffCar
 * @date 12/13/2020 - 7:40 PM
 */

//接口
interface  Human{
    String getBelief();
    void eat(String food);
}

//被代理类

class Superman implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

//动态代理
//1. 如何根据加载到内存的被代理类，去动态创建一个代理类及其对象
//2. 如何动态调用被代理类方法

class ProxyFactory{

    //调用此方法返回一个代理类对象
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler );
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;//赋值时使用被代理类
    public void bind(Object obj){
        this.obj = obj;
    }
    //将被代理类要执行的方法功能声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类对象调用的方法，此方法作为被代理要调用的方法
        //obj 被代理类对象
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}

public class dynamicProxyTest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*************");
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();
    }
}
