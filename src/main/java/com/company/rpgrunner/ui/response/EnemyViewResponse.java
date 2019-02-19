package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.repository.enemy.model.Enemy;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class EnemyViewResponse implements Response {

    private final Enemy enemy;

    public EnemyViewResponse(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(enemy.getDescription());
        stringBuilder.append(" \n Life: " + enemy.getLife());
        stringBuilder.append("\n Damage: " + enemy.getDamage());

        return stringBuilder.toString();
    }
}
