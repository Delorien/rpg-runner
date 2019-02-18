package com.company.rpgrunner.util;

import com.company.rpgrunner.service.Player;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lneto on 18/02/19.
 */
public class PlayerPersistenceHelper {

    public void saveNewPlayer(String name) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write("name:" + name);
        writer.close();
    }

    public Player loadPlayer(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        Map<String, String> lines = bufferedReader.lines().map(s -> s.split(":")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
        return toPlayer(lines);
    }

    private Player toPlayer(Map<String, String> lines) {
        String name = lines.get("name");
        return new Player(name);
    }
}