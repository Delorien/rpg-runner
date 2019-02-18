package com.company.rpgrunner.service;

import com.company.rpgrunner.commons.exception.PlayerFileException;
import com.company.rpgrunner.repository.map.model.Location;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;
import com.company.rpgrunner.util.CriticalExceptionHandler;
import com.company.rpgrunner.util.PlayerPersistenceHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import static com.company.rpgrunner.commons.ExceptionMessage.PLAYER_FILE_ERROR;
import static com.company.rpgrunner.commons.GameMessage.*;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerService {

    private static PlayerService INSTANCE;
    private Player player;
    private final PlayerPersistenceHelper playerPersistenceHelper;

    private PlayerService() {
        playerPersistenceHelper = new PlayerPersistenceHelper();
    }

    public static PlayerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerService();
        }
        return INSTANCE;
    }

    public Response createNewPlayer(String name) {
        try {
            playerPersistenceHelper.saveNewPlayer(name);
            player = playerPersistenceHelper.loadPlayer(name);
        } catch (IOException e) {
            CriticalExceptionHandler.handler(new PlayerFileException(PLAYER_FILE_ERROR));
        }
        return new SimpleMessageResponse(String.format(getMessage(WELCOME_PLAYER), name));
    }

    public Optional<Response> loadPlayer(String name) {
        try {
            player = playerPersistenceHelper.loadPlayer(name);
        } catch (FileNotFoundException e) {
            return Optional.empty();
        } catch (IOException e) {
            CriticalExceptionHandler.handler(new PlayerFileException(PLAYER_FILE_ERROR));
        }
        return Optional.of(new SimpleMessageResponse(String.format(getMessage(WELCOME_BACK_PLAYER), name)));
    }

    public Response saveGame(Location actualLocation) {
        player.setActualLocation(actualLocation.getFileName());
        try {
            playerPersistenceHelper.save(player);
        } catch (IOException e) {
            CriticalExceptionHandler.handler(new PlayerFileException(PLAYER_FILE_ERROR));
        }
        return new SimpleMessageResponse((getMessage(GAME_SAVED)));
    }

    public Player getPlayer() {
        return player;
    }
}
