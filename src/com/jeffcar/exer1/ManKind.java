package com.jeffcar.exer1;

/**
 * @author JeffCar
 * @date 11/21/2020 - 4:54 PM
 */
public class ManKind {

    private int sex;
    private int salary;

    public void manOrWoman(){
        if(sex==1){
            System.out.println("男");
        }else if(sex == 0){
            System.out.println("女");
        }
    }

    public void employee(){
        System.out.println("上班");
    }


}
