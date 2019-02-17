package com.company.rpgrunner;

import com.company.rpgrunner.commons.GameMessage;
import com.company.rpgrunner.commons.exception.GameInitializationException;
import com.company.rpgrunner.ui.GameLoop;
import com.company.rpgrunner.util.CriticalExceptionHandler;

/**
 * Created by Leonardo Tonin on 15/02/19.
 */
public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGameConfigs();
        new GameLoop().runGame();
    }

    private void initializeGameConfigs() {
        try {
            GameMessage.initialize();
        } catch (GameInitializationException e) {
            CriticalExceptionHandler.handler(e);
        }
    }
}
