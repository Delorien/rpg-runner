package com.company.rpgrunner.util;

import com.company.rpgrunner.ui.Command;
import com.company.rpgrunner.ui.PlayerCommand;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerCommandHelper {

    public static Optional<PlayerCommand> toPlayerCommand(String input) {
        Optional<Command> optionalCommand = Command.getByStart(input);

        if (optionalCommand.isPresent()) {
            Command command = optionalCommand.get();
            String target = input.replaceFirst(command.getValue(), "").trim();
            return Optional.of(new PlayerCommand(command, target));
        }

        return Optional.empty();
    }
}
