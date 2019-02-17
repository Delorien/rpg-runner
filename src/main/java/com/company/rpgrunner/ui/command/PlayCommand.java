package com.company.rpgrunner.ui.command;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public enum PlayCommand {

    GO_TO("go to"),
    LOOK_AROUND("la"),
    WHERE_AM_I("where am i"),
    HELP("help"),
    EXIT("exit");

    private String value;

    PlayCommand(String value) {
        this.value = value;
    }

    public static Optional<PlayCommand> getByStart(String input) {
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
