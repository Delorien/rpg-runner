package com.company.rpgrunner.ui;

import com.company.rpgrunner.service.PlayerService;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.ResponseHandler;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;
import com.company.rpgrunner.util.InstructionsHelper;

import java.util.Optional;
import java.util.Scanner;

import static com.company.rpgrunner.commons.GameMessage.*;
import static com.company.rpgrunner.ui.command.MenuCommand.LOAD_SAVED_GAME;
import static com.company.rpgrunner.ui.command.MenuCommand.NEW_GAME;
import static com.company.rpgrunner.util.PlayerRequestHelper.fromMenuCommand;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class GameMenu {

    private final ResponseHandler responseHandler;
    private final InstructionsHelper instructionsHelper;
    private final PlayerService playerService;

    public GameMenu() {
        responseHandler = ResponseHandler.getInstance();
        instructionsHelper = new InstructionsHelper();
        playerService = PlayerService.getInstance();
    }

    public void runMenu() {
        displayInitiGame();
        final Scanner scanner = new Scanner(System.in);

        Boolean isMenuRunning = TRUE;

        while (isMenuRunning) {
            Optional<PlayerRequest> optionalPlayerRequest = fromMenuCommand(scanner.nextLine());

            if (!optionalPlayerRequest.isPresent()) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(INVALID_COMMAND)));
                continue;
            }

            String command = optionalPlayerRequest.get().getCommand();

            if (NEW_GAME.equalToValue(command)) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(ENTER_NEW_PLAYER_NAME)));
                String name = scanner.nextLine();
                responseHandler.respondToPlayer(playerService.createNewPlayer(name));
                isMenuRunning = FALSE;
            }
            if (LOAD_SAVED_GAME.equalToValue(command)) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(ENTER_LOAD_PLAYER_NAME)));
                String name = scanner.nextLine();

                Optional<Response> optionalResponse = playerService.loadPlayer(name);
                if (optionalResponse.isPresent()) {
                    responseHandler.respondToPlayer(optionalResponse.get());
                    isMenuRunning = FALSE;
                } else {
                    responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(PLAYER_NOT_FOUND)));
                    responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(MENU_MESSAGE)));
                }
            }
        }
        startGameLoop();
    }

    private void startGameLoop() {
        new GameLoop().runGame();
    }

    private void displayInitiGame() {
        displayWelcome();
        responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(MENU_MESSAGE)));
    }

    private void displayWelcome() {
        responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(WELCOME_MESSAGE)));
        responseHandler.respondToPlayer(instructionsHelper.getInstructions());
    }
}
