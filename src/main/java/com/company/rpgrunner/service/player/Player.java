package com.company.rpgrunner.service.player;

import com.company.rpgrunner.commons.Fighter;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class Player implements Fighter {

    private final String name;

    private String actualLocation;

    private Integer life;

    private Integer damage;

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

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    @Override
    public void takeDamage(Fighter fighter) {
        this.life = this.life - fighter.getDamage();
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
