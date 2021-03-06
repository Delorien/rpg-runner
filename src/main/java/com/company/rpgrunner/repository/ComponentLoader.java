package com.company.rpgrunner.repository;

import com.company.rpgrunner.util.XMLHelper;

import javax.xml.bind.JAXBException;
import java.util.Optional;

import static com.company.rpgrunner.commons.GameResourcesPath.XML_EXTENSION;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public abstract class ComponentLoader<T> {

    private Class<T> type;

    public ComponentLoader(Class<T> type) {
        this.type = type;
    }

    public Optional<T> load(String name) {
        try {
            return Optional.of(loadComponent(name));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private T loadComponent(String name) throws JAXBException {
        return new XMLHelper().unmarshal(getPath() + name + XML_EXTENSION, type);
    }

    protected abstract String getPath();
}
