package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.repository.item.model.Item;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class ReadInteractionResponse implements Response {

    private final Item item;

    public ReadInteractionResponse(Item item) {
        this.item = item;
    }

    @Override
    public String getMessage() {
        return item.getDescription();
    }
}
