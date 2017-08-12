package com.fastdeliveryservice.domain;

/**
 * Created by Martina on 31/07/2017.
 */

public class LocationView {

    private String city;
    private String name;
    private double coordinateX;
    private double coordinateY;

    public LocationView(String city, String name, double coordinateX,  double coordinateY) {
        this.city = city;
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String city() {
        return city;
    }

    public String name() {
        return name;
    }

    public double coordinateY() {
        return coordinateY;
    }

    public double coordinateX() {
        return coordinateX;
    }
}