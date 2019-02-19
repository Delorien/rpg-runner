package com.company.rpgrunner.ui;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.service.EnemyService;
import com.company.rpgrunner.service.FightService;
import com.company.rpgrunner.service.PlayerService;
import com.company.rpgrunner.ui.response.ResponseHandler;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Scanner;

import static com.company.rpgrunner.commons.GameMessage.FIGHT_INSTRUCTIONS;
import static com.company.rpgrunner.commons.GameMessage.INVALID_COMMAND;
import static com.company.rpgrunner.commons.GameMessage.getMessage;
import static com.company.rpgrunner.ui.request.command.PlayCommand.ATTACK;
import static java.lang.Boolean.TRUE;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class FightLoop {

    private final FightService fightService;
    private final ResponseHandler responseHandler;

    public FightLoop(EnemyService enemyService, PlayerService playerService) {
        this.fightService = new FightService();
        this.responseHandler = ResponseHandler.getInstance();
    }

    public void runFight(Enemy enemy) {

        Boolean isFightRunning = TRUE;

        final Scanner scanner = new Scanner(System.in);

        while (isFightRunning) {
            String command = scanner.nextLine();

            if (!ATTACK.equalToValue(command)) {
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(INVALID_COMMAND)));
                responseHandler.respondToPlayer(new SimpleMessageResponse(getMessage(FIGHT_INSTRUCTIONS)));
                continue;
            }

            if (ATTACK.equalToValue(command)) {
                responseHandler.respondToPlayer(fightService.runTurn(enemy));
                continue;
            }

        }
    }
}
