package com.company.rpgrunner;

import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;
import com.company.rpgrunner.service.GameManifestService;
import com.company.rpgrunner.ui.GameLoop;

/**
 * Created by Leonardo Tonin on 15/02/19.
 */
public class Game {

    public static void main(String[] args) {
        final GameManifest gameManifest = new GameManifestService().load();
        new GameLoop(gameManifest).runGame();
    }
}
