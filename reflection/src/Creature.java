import java.io.Serializable;

/**
 * @author JeffCar
 * @date 12/11/2020 - 9:42 PM
 */
public class Creature<T> implements Serializable {
    private char gendar;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃");
    }
}
