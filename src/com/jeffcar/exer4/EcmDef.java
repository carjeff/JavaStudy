package com.jeffcar.exer4;

/**
 * @author JeffCar
 * @date 11/24/2020 - 3:50 PM
 *
 * 自定义异常
 */
public class EcmDef {

    public static void main(String[] args){

    }

    public static int ecm(int i, int j) throws Exception{
        if(i< 0 || j<0){
            throw new EcDef("分子或分母为负数了");
        }
        return i/j;
    }
}
