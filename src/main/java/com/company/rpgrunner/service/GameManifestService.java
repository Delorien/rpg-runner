package com.company.rpgrunner.service;

import com.company.rpgrunner.commons.exception.CouldNotLoadManifestException;
import com.company.rpgrunner.repository.gamemanifest.GameManifestLoader;
import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;

import java.util.Optional;

import static com.company.rpgrunner.commons.ExceptionMessage.COULD_NOT_LOAD_MANIFEST_FILE;
import static com.company.rpgrunner.util.CriticalExceptionHandler.handler;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class GameManifestService {

    private final static String GAME_MANIFEST_FILE = "game-manifest";

    public GameManifest load() {
        final Optional<GameManifest> optionalGameManifest = new GameManifestLoader().load(GAME_MANIFEST_FILE);
        if (!optionalGameManifest.isPresent()) {
            handler(new CouldNotLoadManifestException(COULD_NOT_LOAD_MANIFEST_FILE));
        }
        return optionalGameManifest.get();
    }
}
