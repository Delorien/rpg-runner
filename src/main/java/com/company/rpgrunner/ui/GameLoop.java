package com.company.rpgrunner.ui;

import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;
import com.company.rpgrunner.service.LocationService;
import com.company.rpgrunner.util.GameMessage;

import java.util.Optional;
import java.util.Scanner;

import static com.company.rpgrunner.ui.Command.EXIT;
import static com.company.rpgrunner.ui.Command.GO_TO;
import static com.company.rpgrunner.ui.Command.HELP;
import static com.company.rpgrunner.util.GameMessage.INSTRUCTIONS_MESSAGE;
import static com.company.rpgrunner.util.GameMessage.WELCOME_MESSAGE;
import static com.company.rpgrunner.util.UserCommandHelper.toUserCommand;
import static java.lang.Boolean.TRUE;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameLoop {

    private final LocationService locationService;
    private final GameManifest gameManifest;

    public GameLoop(GameManifest gameManifest) {
        this.gameManifest = gameManifest;
        locationService = new LocationService();
    }

    public void runGame() {

        displayWelcome();
        startStory();

        final Scanner scanner = new Scanner(System.in);

        while (TRUE) {
            Optional<UserCommand> optionalUserCommand = toUserCommand(scanner.nextLine());

            if (!optionalUserCommand.isPresent()) {
                System.out.println("Invalid Command");
                continue;
            }

            UserCommand userCommand = optionalUserCommand.get();
            Command command = userCommand.getCommand();
            String target = userCommand.getTarget();

            if (HELP.equals(command)) {
                displayInstructions();
                continue;
            }

            if (GO_TO.equals(command)) {
                respondToUser(locationService.goTo(target));
                continue;
            }

            if (EXIT.equals(command)) {
                System.out.println("Thank you for play!");
                break;
            }
        }

        scanner.close();
    }

    private void displayWelcome() {
        respondToUser(new Response(GameMessage.getInstance().getMessage(WELCOME_MESSAGE)));
        displayInstructions();
    }

    private void displayInstructions() {
        respondToUser(new Response(GameMessage.getInstance().getMessage(INSTRUCTIONS_MESSAGE)));
    }

    private void startStory() {
        Response response = locationService.goTo(gameManifest.getStartLocation());
        respondToUser(response);
    }

    private void respondToUser(Response response) {
        System.out.println(response.getMessage());
    }
}
