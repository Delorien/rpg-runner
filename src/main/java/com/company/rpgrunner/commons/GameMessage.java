package com.company.rpgrunner.commons;

import com.company.rpgrunner.commons.exception.GameInitializationException;
import com.company.rpgrunner.commons.exception.MissingPropertyException;
import com.company.rpgrunner.util.CriticalExceptionHandler;
import com.company.rpgrunner.util.PropertiesHelper;

import java.util.Optional;
import java.util.Properties;

import static com.company.rpgrunner.commons.ExceptionMessage.COULD_NOT_LOAD_MESSAGE_PROPERTIES_FILE;
import static com.company.rpgrunner.commons.ExceptionMessage.MISSING_MESSAGE_PROPERTY;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameMessage {

    public final static String WELCOME_MESSAGE = "welcome";
    public final static String INSTRUCTIONS_MESSAGE = "instructions";
    public final static String INVALID_COMMAND = "invalid.command";
    public final static String EXIT_MESSAGE = "exit.message";

    private final static String MESSAGE_PROPERTIES = "messages";
    private static GameMessage INSTANCE;

    private final Properties properties;

    private GameMessage() throws GameInitializationException {
        Optional<Properties> optionalProperties = PropertiesHelper.getInstance().load(MESSAGE_PROPERTIES);
        properties = optionalProperties.orElseThrow(() -> new GameInitializationException(COULD_NOT_LOAD_MESSAGE_PROPERTIES_FILE));
    }

    public static void initialize() throws GameInitializationException {
        if (INSTANCE == null) {
            INSTANCE = new GameMessage();
        }
    }

    public static String getMessage(String message) {
        String property = INSTANCE.getProperties().getProperty(message);
        if (property == null) {
            CriticalExceptionHandler.handler(new MissingPropertyException(MISSING_MESSAGE_PROPERTY));
        }
        return property;
    }

    private Properties getProperties() {
        return properties;
    }
}
