package com.company.rpgrunner.repository.enemy.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
@XmlRootElement(name = "Enemy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Enemy {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Life")
    private String life;

    @XmlElement(name = "Damage")
    private String damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
}
