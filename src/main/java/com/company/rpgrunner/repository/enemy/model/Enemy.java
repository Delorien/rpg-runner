package com.company.rpgrunner.repository.enemy.model;

import com.company.rpgrunner.commons.Fighter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
@XmlRootElement(name = "Enemy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Enemy implements Fighter {

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

    public Integer getDamage() {
        return Integer.valueOf(damage);
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public void takeDamage(Fighter fighter) {
        Integer damage = Integer.valueOf(this.damage);
        Integer life = Integer.valueOf(this.life) - damage;
        this.life = life.toString();
    }
}
