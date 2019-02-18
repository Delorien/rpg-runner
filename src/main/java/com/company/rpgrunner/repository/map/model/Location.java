package com.company.rpgrunner.repository.map.model;

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
    private List<Way> Ways;

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
        return Ways;
    }

    public void setWays(List<Way> ways) {
        Ways = ways;
    }
}
