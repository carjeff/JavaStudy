package com.jeffcar.project3.service;

/**
 * @author JeffCar
 * @date 11/24/2020 - 8:43 PM
 */
public class Status {
    private final String NAME;

    public Status(String NAME) {
        this.NAME = NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
