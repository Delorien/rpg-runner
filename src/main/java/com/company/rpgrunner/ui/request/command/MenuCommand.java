package com.company.rpgrunner.ui.request.command;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public enum MenuCommand {

    NEW_GAME("new"),
    LOAD_SAVED_GAME("load");

    private String value;

    MenuCommand(String value) {
        this.value = value;
    }

    public static Optional<MenuCommand> getByStart(String input) {
        return Arrays.stream(values())
                .filter(command -> input.startsWith(command.value)
                ).findFirst();
    }

    public String getValue() {
        return value;
    }

    public Boolean equalToValue(String value) {
        return this.value.equals(value);
    }
}
