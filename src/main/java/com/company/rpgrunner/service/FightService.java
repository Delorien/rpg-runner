package com.company.rpgrunner.service;

import com.company.rpgrunner.commons.Fighter;
import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.service.player.PlayerService;
import com.company.rpgrunner.ui.response.FightTurnResponse;
import com.company.rpgrunner.ui.response.GameOverMessageResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Random;

import static com.company.rpgrunner.commons.GameMessage.YOU_LOOSE;
import static com.company.rpgrunner.commons.GameMessage.YOU_WIN;
import static com.company.rpgrunner.commons.GameMessage.getMessage;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.valueOf;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class FightService {

    private final PlayerService playerService;
    private final Random attackSuccessDice;
    private Boolean isFightFinished = FALSE;

    public FightService() {
        playerService = PlayerService.getInstance();
        attackSuccessDice = new Random();
    }

    public Response runTurn(Enemy enemy) {

        final Boolean playerAttackSuccess = runAttack(playerService.getPlayer(), enemy);
        final Boolean enemyAttackSuccess = runAttack(enemy, playerService.getPlayer());

        if (valueOf(playerService.getPlayer().getLife()) <= 0) {
            isFightFinished = TRUE;
            return new GameOverMessageResponse();
        }

        if (valueOf(enemy.getLife()) <= 0) {
            isFightFinished = TRUE;
            return new SimpleMessageResponse(getMessage(YOU_WIN));
        }

        return new FightTurnResponse(playerService.getPlayer(), enemy, playerAttackSuccess, enemyAttackSuccess);
    }

    public Boolean isFightFinished() {
        return this.isFightFinished;
    }

    private Boolean runAttack(Fighter attacker, Fighter target) {
        if (attackSuccessDice.nextBoolean()) {
            target.takeDamage(attacker);
            return TRUE;
        }
        return FALSE;
    }
}
