package com.company.rpgrunner.service;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class Player {

    private final String name;

    private String actualLocation;

    private String life;

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

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }
}
