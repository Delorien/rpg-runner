package com.company.rpgrunner.util;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PropertiesHelper {

    private static final String PROPERTIES_EXTENSION = ".properties";

    private static PropertiesHelper INSTANCE;

    private PropertiesHelper() {
    }

    public static PropertiesHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PropertiesHelper();
        }

        return INSTANCE;
    }

    public Optional<Properties> load(String name) {

        Properties properties = new Properties();

        try {
            properties.load(PropertiesHelper.class.getClassLoader().getResourceAsStream(name + PROPERTIES_EXTENSION));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        return Optional.of(properties);
    }
}
