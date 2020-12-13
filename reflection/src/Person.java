import java.util.Comparator;

/**
 * @author JeffCar
 * @date 12/9/2020 - 6:06 PM
 */
public class Person extends Creature<String> implements Comparator<String>, MyInterface {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国记是: "+nation);
        return nation;
    }

    @Override
    public void info() {
        System.out.println("Info ");
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}
