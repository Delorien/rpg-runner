package com.company.rpgrunner.service;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class Player {

    private final String name;

    private String actualLocation;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getActualLocation() {
        return actualLocation;
    }

    public void setActualLocation(String actualLocation) {
        this.actualLocation = actualLocation;
    }
}
