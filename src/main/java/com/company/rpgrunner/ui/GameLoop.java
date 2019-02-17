package com.company.rpgrunner.ui;

import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;
import com.company.rpgrunner.service.GameManifestService;
import com.company.rpgrunner.service.LocationService;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.ResponseHandler;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;
import com.company.rpgrunner.util.InstructionsHelper;

import java.util.Optional;
import java.util.Scanner;

import static com.company.rpgrunner.commons.GameMessage.*;
import static com.company.rpgrunner.ui.command.PlayCommand.*;
import static com.company.rpgrunner.util.PlayerRequestHelper.fromPlayCommand;
import static java.lang.Boolean.TRUE;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameLoop {

    private final LocationService locationService;
    private final ResponseHandler responseHandler;
    private final GameManifest gameManifest;
    private final InstructionsHelper instructionsHelper;

    public GameLoop() {
        gameManifest = new GameManifestService().load();
        locationService = LocationService.getInstance();
        responseHandler = ResponseHandler.getInstance();
        instructionsHelper = new InstructionsHelper();
    }

    public void runGame() {
        startNewStory();

        final Scanner scanner = new Scanner(System.in);

        while (TRUE) {
            Optional<PlayerRequest> optionalPlayerRequest = fromPlayCommand(scanner.nextLine());

            if (!optionalPlayerRequest.isPresent()) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(INVALID_COMMAND)));
                continue;
            }

            PlayerRequest playerRequest = optionalPlayerRequest.get();
            String command = playerRequest.getCommand();
            String target = playerRequest.getTarget();

            if (LOOK_AROUND.equalToValue(command)) {
                responseHandler.respondToPlayer(locationService.lookAround());
            }

            if (WHERE_AM_I.equalToValue(command)) {
                responseHandler.respondToPlayer(locationService.whereAmI());
            }


            if (GO_TO.equalToValue(command)) {
                responseHandler.respondToPlayer(locationService.goTo(target));
                continue;
            }

            if (HELP.equalToValue(command)) {
                responseHandler.respondToPlayer(instructionsHelper.getInstructions());
                continue;
            }

            if (EXIT.equalToValue(command)) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(EXIT_MESSAGE)));
                break;
            }
        }

        scanner.close();
    }

    private void startNewStory() {
        Response response = locationService.goTo(gameManifest.getStartLocation());
        responseHandler.respondToPlayer(response);
    }
}
