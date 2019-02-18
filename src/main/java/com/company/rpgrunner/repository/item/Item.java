package com.company.rpgrunner.repository.item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Description")
    private String description;

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
}
