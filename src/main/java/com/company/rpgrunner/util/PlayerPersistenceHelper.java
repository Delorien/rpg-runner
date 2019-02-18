package com.company.rpgrunner.util;

import com.company.rpgrunner.service.Player;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lneto on 18/02/19.
 */
public class PlayerPersistenceHelper {

    public static final String NAME = "name";
    public static final String ACTUAL_LOCATION = "actualLocation";
    public static final String JUMP_LINE = "\n";

    public void saveNewPlayer(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write(NAME + ":" + name);
        writer.close();
    }

    public Player loadPlayer(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        Map<String, String> lines = bufferedReader.lines().map(s -> s.split(":")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
        return toPlayer(lines);
    }

    private Player toPlayer(Map<String, String> lines) {
        String name = lines.get(NAME);
        String actualLocation = lines.get(ACTUAL_LOCATION);
        Player player = new Player(name);
        player.setActualLocation(actualLocation);
        return player;
    }

    public void save(Player player) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(player.getName()));
        writer.write(NAME + ":" + player.getName());
        writer.write(JUMP_LINE);
        writer.write(ACTUAL_LOCATION + ":" + player.getActualLocation());
        writer.close();
    }
}