package compare;

/**
 * @author JeffCar
 * @date 12/1/2020 - 4:13 PM
 */
public class Good implements Comparable{
    private String name;
    private int price;

    public Good(String name) {
        this.name = name;
    }

    public Good() {
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * 指明按照什么进行排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Good){
            Good good = (Good) o;
            if(this.price > good.price){
                return 1;
            }else if (this.price < good.price){
                return -1;
            }else {
                return this.name.compareTo(good.name);
            }
        }
        throw new RuntimeException("类型不一致");
    }
}
