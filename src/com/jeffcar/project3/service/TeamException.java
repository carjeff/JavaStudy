package com.jeffcar.project3.service;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:09 PM
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -123124121L;
    public TeamException(){
        super();
    }


    public TeamException(String msg){
        super(msg);
    }
}
