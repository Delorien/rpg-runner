package com.company.rpgrunner.repository.map.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
@XmlRootElement(name = "Way")
@XmlAccessorType(XmlAccessType.FIELD)
public class Way {

    @XmlElement(name = "Choice")
    private String choice;

    @XmlElement(name = "NextLocationName")
    private String nextLocationName;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getNextLocationName() {
        return nextLocationName;
    }

    public void setNextLocationName(String nextLocationName) {
        this.nextLocationName = nextLocationName;
    }
}
