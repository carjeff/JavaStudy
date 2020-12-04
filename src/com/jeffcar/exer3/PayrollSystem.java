package com.jeffcar.exer3;

/**
 * @author JeffCar
 * @date 11/23/2020 - 5:41 PM
 */
public class PayrollSystem {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new SalariedEmployee("che",1000,new MyDate(1999,3,20),10000);
        employees[1] = new HourlyEmployee("zi",1001,new MyDate(2000,7,9),500,5);
        employees[2] = new SalariedEmployee("jie",1002,new MyDate(1999,5,20),20000);
        for (int i=0; i< employees.length;i++){
            System.out.println(employees[i]);
            int salary = employees[i].earnings();
            System.out.println("月工资为:"+salary);
        }
    }


}
