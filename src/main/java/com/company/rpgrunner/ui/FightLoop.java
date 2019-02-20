package com.company.rpgrunner.ui;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.service.FightService;
import com.company.rpgrunner.ui.response.GameOverMessageResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.ResponseHandler;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Scanner;

import static com.company.rpgrunner.commons.GameMessage.FIGHT_INSTRUCTIONS;
import static com.company.rpgrunner.commons.GameMessage.getMessage;
import static com.company.rpgrunner.ui.request.command.PlayCommand.ATTACK;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class FightLoop {

    private final FightService fightService;
    private final ResponseHandler responseHandler;

    public FightLoop() {
        this.fightService = new FightService();
        this.responseHandler = ResponseHandler.getInstance();
    }

    public void runFight(Enemy enemy) {

        handleTurnResponse(fightService.runTurn(enemy));

        final Scanner scanner = new Scanner(System.in);

        while (!fightService.isFightFinished()) {
            String command = scanner.nextLine();

            if (!ATTACK.equalToValue(command)) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(FIGHT_INSTRUCTIONS)));
                continue;
            }

            if (ATTACK.equalToValue(command)) {
                handleTurnResponse(fightService.runTurn(enemy));
                continue;
            }
        }
    }

    private void handleTurnResponse(Response response) {
        responseHandler.respondToPlayer(response);
        if (response instanceof GameOverMessageResponse) {
            System.exit(0);
        }
    }
}
