package com.jeffcar.project3.bean;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:33 PM
 */
public class PC implements Equipment{
    private String model;  //机器型号
    private String display; //显示器名称

    public PC(){
    }
    public PC(String model, String display){
        this.model = model;
        this.display = display;
    }
    @Override
    public String getDescription() {
        return model + "("+display+")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
