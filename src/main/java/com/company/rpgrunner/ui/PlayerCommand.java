package com.company.rpgrunner.ui;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerCommand {

    private final Command command;
    private final String target;

    public PlayerCommand(Command command, String target) {
        this.command = command;
        this.target = target;
    }

    public Command getCommand() {
        return command;
    }

    public String getTarget() {
        return target;
    }
}
