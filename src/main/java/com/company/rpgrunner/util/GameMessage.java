package com.company.rpgrunner.util;

import java.util.Optional;
import java.util.Properties;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameMessage {

    public final static String WELCOME_MESSAGE = "welcome";
    public final static String INSTRUCTIONS_MESSAGE = "instructions";

    private final static String MESSAGE_PROPERTIES = "messages";
    private static GameMessage INSTANCE;

    private final Properties properties;

    private GameMessage() {
        Optional<Properties> optionalProperties = PropertiesHelper.getInstance().load(MESSAGE_PROPERTIES);
        properties = optionalProperties.get();
    }

    public static GameMessage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameMessage();
        }

        return INSTANCE;
    }

    public String getMessage(String messages) {
        return this.properties.getProperty(messages);
    }
}
