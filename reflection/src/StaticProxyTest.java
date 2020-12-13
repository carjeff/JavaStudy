/**
 * @author JeffCar
 * @date 12/13/2020 - 7:32 PM
 */

interface ClothFactory{
    void produceCloth();
}


//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory; // 用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产运动服");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        proxy.produceCloth();
    }
}
