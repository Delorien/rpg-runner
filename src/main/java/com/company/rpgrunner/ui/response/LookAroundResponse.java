package com.company.rpgrunner.ui.response;

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

    public LookAroundResponse(Location location) {
        ways = location.getWays().stream().map(Way::getNextLocationName).collect(Collectors.toList());
        itens = location.getItens().stream().map(Item::getName).collect(Collectors.toList());
    }

    @Override
    public String getMessage() {
        return new StringBuilder()
                .append("Ways: \n ")
                .append(String.join("\n ", ways))
                .append("\n")
                .append("Itens: \n ")
                .append(String.join("\n ", itens))
                .toString();
    }
}
