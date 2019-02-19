package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.enemy.EnemyLoader;
import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.ui.response.EnemyViewResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Optional;

import static com.company.rpgrunner.commons.GameMessage.INVALID_CHOICE;
import static com.company.rpgrunner.commons.GameMessage.getMessage;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class EnemyService {

    private static EnemyService INSTANCE;
    private final EnemyLoader enemyLoader;

    private EnemyService() {
        enemyLoader = new EnemyLoader();
    }

    public static EnemyService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EnemyService();
        }
        return INSTANCE;
    }

    public Response check(String target) {
        Optional<Enemy> optionalEnemy = enemyLoader.load(target.toLowerCase());
        if (!optionalEnemy.isPresent()) {
            return new SimpleMessageResponse(getMessage(INVALID_CHOICE));
        }

        return new EnemyViewResponse(optionalEnemy.get());
    }
}
