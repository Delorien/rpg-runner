package com.company.rpgrunner.repository.gamemanifest;

import com.company.rpgrunner.repository.ComponentLoader;
import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;

import static com.company.rpgrunner.util.GameResourcesPath.GAME_ASSETS_ROOT;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameManifestLoader extends ComponentLoader<GameManifest> {

    public GameManifestLoader() {
        super(GameManifest.class);
    }

    @Override
    protected String getPath() {
        return GAME_ASSETS_ROOT;
    }
}
