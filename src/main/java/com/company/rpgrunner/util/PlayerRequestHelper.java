package com.company.rpgrunner.util;

import com.company.rpgrunner.ui.request.command.MenuCommand;
import com.company.rpgrunner.ui.request.command.PlayCommand;
import com.company.rpgrunner.ui.request.PlayerRequest;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerRequestHelper {

    public static Optional<PlayerRequest> fromPlayCommand (String input) {
        Optional<PlayCommand> optionalCommand = PlayCommand.getByStart(input);

        if (optionalCommand.isPresent()) {
            String command = optionalCommand.get().getValue();
            String target = input.replaceFirst(command, "").trim();
            return Optional.of(new PlayerRequest(command, target));
        }

        return Optional.empty();
    }

    public static Optional<PlayerRequest> fromMenuCommand (String input) {
        Optional<MenuCommand> optionalCommand = MenuCommand.getByStart(input);

        if (optionalCommand.isPresent()) {
            String command = optionalCommand.get().getValue();
            String target = input.replaceFirst(command, "").trim();
            return Optional.of(new PlayerRequest(command, target));
        }

        return Optional.empty();
    }
}
