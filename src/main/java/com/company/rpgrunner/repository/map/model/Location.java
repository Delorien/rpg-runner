package com.company.rpgrunner.repository.map.model;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.repository.item.model.Item;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Leonardo Tonin on 15/02/19.
 */
@XmlRootElement(name = "Location")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {

    @XmlElement(name = "FileName")
    private String fileName;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Description")
    private String description;

    @XmlElementWrapper(name = "Ways")
    @XmlElement(name = "Way")
    private List<Way> ways;

    @XmlElementWrapper(name = "Itens")
    @XmlElement(name = "Item")
    private List<Item> itens;

    @XmlElementWrapper(name = "Enemies")
    @XmlElement(name = "Enemy")
    private List<Enemy> enemies;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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

    public List<Way> getWays() {
        if (ways == null) {
            return Collections.EMPTY_LIST;
        }
        return ways;
    }

    public void setWays(List<Way> ways) {
        this.ways = ways;
    }

    public List<Item> getItens() {
        if (itens == null) {
            return Collections.EMPTY_LIST;
        }
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Enemy> getEnemies() {
        if (enemies == null) {
            return Collections.EMPTY_LIST;
        }
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
