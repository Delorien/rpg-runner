package com.company.rpgrunner.repository.enemy;

import com.company.rpgrunner.repository.ComponentLoader;
import com.company.rpgrunner.repository.enemy.model.Enemy;

import static com.company.rpgrunner.commons.GameResourcesPath.ENIMY_PATH;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class EnemyLoader extends ComponentLoader<Enemy> {

    public EnemyLoader() {
        super(Enemy.class);
    }

    @Override
    protected String getPath() {
        return ENIMY_PATH;
    }
}
