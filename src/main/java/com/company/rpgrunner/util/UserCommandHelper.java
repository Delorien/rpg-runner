package com.company.rpgrunner.util;

import com.company.rpgrunner.ui.Command;
import com.company.rpgrunner.ui.UserCommand;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class UserCommandHelper {

    public static Optional<UserCommand> toUserCommand(String input) {
        Optional<Command> optionalCommand = Command.getByStart(input);

        if (optionalCommand.isPresent()) {
            Command command = optionalCommand.get();
            String target = input.replaceFirst(command.getValue(), "").trim();
            return Optional.of(new UserCommand(command, target));
        }

        return Optional.empty();
    }
}
