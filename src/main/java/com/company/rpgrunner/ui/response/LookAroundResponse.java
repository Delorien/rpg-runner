package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.repository.item.model.Item;
import com.company.rpgrunner.repository.map.model.Location;
import com.company.rpgrunner.repository.map.model.Way;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class LookAroundResponse implements Response {

    private List<String> ways;
    private List<String> itens;
    private List<String> enemies;

    public LookAroundResponse(Location location) {
        ways = location.getWays().stream().map(Way::getNextLocationName).collect(Collectors.toList());
        itens = location.getItens().stream().map(Item::getName).collect(Collectors.toList());
        enemies = location.getEnemies().stream().map(Enemy::getName).collect(Collectors.toList());
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (!ways.isEmpty()) {
            stringBuilder.append("Ways: \n ");
            stringBuilder.append(String.join("\n ", ways));
        }

        if (!itens.isEmpty()) {
            stringBuilder.append("\n");
            stringBuilder.append("Itens: \n ");
            stringBuilder.append(String.join("\n ", itens));
        }

        if (!enemies.isEmpty()) {
            stringBuilder.append("\n");
            stringBuilder.append("Enemies: \n ");
            stringBuilder.append(String.join("\n ", enemies));
        }

        return stringBuilder.toString();
    }
}
