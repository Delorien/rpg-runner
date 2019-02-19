package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import static com.company.rpgrunner.commons.GameMessage.YOU_LOOSE;
import static com.company.rpgrunner.commons.GameMessage.YOU_WIN;
import static com.company.rpgrunner.commons.GameMessage.getMessage;
import static java.lang.Integer.valueOf;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class FightService {

    private final PlayerService playerService;
    private final EnemyService enemyService;

    public FightService() {
        playerService = PlayerService.getInstance();
        enemyService = EnemyService.getInstance();
    }

    public Response runTurn(Enemy enemy) {

        if (valueOf(playerService.getPlayer().getLife()) <= 0) {
            return new SimpleMessageResponse(getMessage(YOU_LOOSE));
        }

        if (valueOf(enemy.getLife()) <= 0) {
            return new SimpleMessageResponse(getMessage(YOU_WIN));
        }
    }
}
