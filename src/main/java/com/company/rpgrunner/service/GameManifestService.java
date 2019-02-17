package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.gamemanifest.GameManifestLoader;
import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameManifestService {

    private final static String GAME_MANIFEST_FILE = "game-manifest";

    public GameManifest load() {

        final Optional<GameManifest> optionalGameManifest = new GameManifestLoader().load(GAME_MANIFEST_FILE);
        return optionalGameManifest.get();
    }
}
