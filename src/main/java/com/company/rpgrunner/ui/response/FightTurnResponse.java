package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.service.Player;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class FightTurnResponse implements Response {

    private final Enemy enemy;
    private final Player player;
    private final Boolean playerAttackSuccess;
    private final Boolean enemyAttackSuccess;

    public FightTurnResponse(Enemy enemy, Player player, Boolean playerAttackSuccess, Boolean enemyAttackSuccess) {
        this.enemy = enemy;
        this.player = player;
        this.playerAttackSuccess = playerAttackSuccess;
        this.enemyAttackSuccess = enemyAttackSuccess;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (playerAttackSuccess) {
            stringBuilder.append(" Attack Success!");
        } else {
            stringBuilder.append(" Attack Fail!");
        }

        if (enemyAttackSuccess) {
            stringBuilder.append("\n Enemy attack Success!");
        } else {
            stringBuilder.append("\n Enemy attack Fail!");
        }

        stringBuilder.append("\n  Your life: ");
        stringBuilder.append("\n  Enemy life: " + enemy.getLife());
        return stringBuilder.toString();
    }
}
