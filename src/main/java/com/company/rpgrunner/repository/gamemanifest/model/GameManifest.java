package com.company.rpgrunner.repository.gamemanifest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
@XmlRootElement(name = "GameManifest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameManifest {

    @XmlElement(name = "StartLocation")
    private String startLocation;

    @XmlElement(name = "PlayerInitialLife")
    private String playerInitialLife;

    @XmlElement(name = "PlayerInitialDamage")
    private String playerInitialDamage;

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getPlayerInitialLife() {
        return playerInitialLife;
    }

    public void setPlayerInitialLife(String playerInitialLife) {
        this.playerInitialLife = playerInitialLife;
    }

    public String getPlayerInitialDamage() {
        return playerInitialDamage;
    }

    public void setPlayerInitialDamage(String playerInitialDamage) {
        this.playerInitialDamage = playerInitialDamage;
    }
}
