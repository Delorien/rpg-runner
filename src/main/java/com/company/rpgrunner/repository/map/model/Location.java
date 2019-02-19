package com.company.rpgrunner.repository.map.model;

import com.company.rpgrunner.repository.item.model.Item;

import javax.xml.bind.annotation.*;
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
        return ways;
    }

    public void setWays(List<Way> ways) {
        this.ways = ways;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
