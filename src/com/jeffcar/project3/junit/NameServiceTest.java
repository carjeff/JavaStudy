package com.jeffcar.project3.junit;

import com.jeffcar.project3.bean.Employee;
import com.jeffcar.project3.service.NameService;
import com.jeffcar.project3.service.TeamException;
import org.junit.Test;

/**
 * @author JeffCar
 * @date 11/24/2020 - 11:10 PM
 */
public class NameServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameService service = new NameService();
        Employee[] employees = service.getAllEmployees();
        for (int i=0; i<employees.length; i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameService service = new NameService();
        try {
            Employee employee = service.getEmployee(22);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

    }

}
