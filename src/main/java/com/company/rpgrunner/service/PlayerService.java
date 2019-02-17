package com.company.rpgrunner.service;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class PlayerService {

    private static PlayerService INSTANCE;

    private PlayerService() {
    }

    public static PlayerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerService();
        }
        return INSTANCE;
    }

    public void createNewPlayer(String name) {

    }
}
