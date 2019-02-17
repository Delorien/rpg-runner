package com.company.rpgrunner.ui;

import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;
import com.company.rpgrunner.service.GameManifestService;
import com.company.rpgrunner.service.LocationService;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Optional;
import java.util.Scanner;

import static com.company.rpgrunner.commons.GameMessage.*;
import static com.company.rpgrunner.ui.Command.*;
import static com.company.rpgrunner.util.PlayerCommandHelper.toPlayerCommand;
import static java.lang.Boolean.TRUE;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameLoop {

    private final LocationService locationService;
    private final ResponseHandler responseHandler;
    private final GameManifest gameManifest;

    public GameLoop() {
        gameManifest = new GameManifestService().load();
        locationService = LocationService.getInstance();
        responseHandler = new ResponseHandler();
    }

    public void runGame() {

        displayWelcome();
        startStory();

        final Scanner scanner = new Scanner(System.in);

        while (TRUE) {
            Optional<PlayerCommand> optionalUserCommand = toPlayerCommand(scanner.nextLine());

            if (!optionalUserCommand.isPresent()) {
                responseHandler.respondToUser(new SimpleMessageResponse(getMessage(INVALID_COMMAND)));
                continue;
            }

            PlayerCommand playerCommand = optionalUserCommand.get();
            Command command = playerCommand.getCommand();
            String target = playerCommand.getTarget();

            if (LOOK_AROUND.equals(command)) {
                responseHandler.respondToUser(locationService.lookAround());
            }

            if (HELP.equals(command)) {
                displayInstructions();
                continue;
            }

            if (GO_TO.equals(command)) {
                responseHandler.respondToUser(locationService.goTo(target));
                continue;
            }

            if (EXIT.equals(command)) {
                responseHandler.respondToUser(new SimpleMessageResponse(getMessage(EXIT_MESSAGE)));
                break;
            }
        }

        scanner.close();
    }

    private void displayWelcome() {
        responseHandler.respondToUser(new SimpleMessageResponse(getMessage(WELCOME_MESSAGE)));
        displayInstructions();
    }

    private void displayInstructions() {
        responseHandler.respondToUser(new SimpleMessageResponse(getMessage(INSTRUCTIONS_MESSAGE)));
    }

    private void startStory() {
        Response response = locationService.goTo(gameManifest.getStartLocation());
        responseHandler.respondToUser(response);
    }
}
