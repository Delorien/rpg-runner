package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.item.ItemLoader;
import com.company.rpgrunner.repository.item.model.Interactable;
import com.company.rpgrunner.repository.item.model.Item;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Optional;

import static com.company.rpgrunner.commons.GameMessage.INVALID_CHOICE;
import static com.company.rpgrunner.commons.GameMessage.getMessage;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class ItemService {

    private static ItemService INSTANCE;
    private ItemLoader itemLoader;

    private ItemService() {
        itemLoader = new ItemLoader();
    }

    public static ItemService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemService();
        }
        return INSTANCE;
    }

    public Response interactWith(String target) {
        Optional<Item> optionalItem = itemLoader.load(target.toLowerCase());
        if (!optionalItem.isPresent()) {
            return new SimpleMessageResponse(getMessage(INVALID_CHOICE));
        }

        return interactWith(optionalItem.get());
    }

    private Response interactWith(Interactable interactable) {
        return interactable.interact();
    }
}
