package com.company.rpgrunner.ui;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerRequest {

    private final String command;
    private final String target;

    public PlayerRequest(String command, String target) {
        this.command = command;
        this.target = target;
    }

    public String getCommand() {
        return command;
    }

    public String getTarget() {
        return target;
    }
}
