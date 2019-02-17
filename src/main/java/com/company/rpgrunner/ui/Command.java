package com.company.rpgrunner.ui;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public enum Command {

    GO_TO("go to"),
    HELP("help"),
    EXIT("exit");

    private String value;

    Command(String value) {
        this.value = value;
    }

    public static Boolean contains(String value) {
        return Arrays.stream(values())
                .anyMatch(command -> command.value == value);
    }

    public static Optional<Command> getByStart(String input) {
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
