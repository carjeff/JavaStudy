package com.jeffcar.exer4;

/**
 * @author JeffCar
 * @date 11/24/2020 - 3:52 PM
 */
public class EcDef extends Exception{
    static final long serialVersionUID = -123124141534L;

    public EcDef(){}
    public EcDef(String msg){
        super(msg);
    }
}
