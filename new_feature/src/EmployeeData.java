import java.util.ArrayList;
import java.util.List;

/**
 * @author JeffCar
 * @date 12/14/2020 - 12:17 AM
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("a",1));
        list.add(new Employee("b",2));
        list.add(new Employee("c",3));
        list.add(new Employee("d",14));
        list.add(new Employee("e",15));
        list.add(new Employee("f",16));
        list.add(new Employee("g",17));
        return list;
    }
}
