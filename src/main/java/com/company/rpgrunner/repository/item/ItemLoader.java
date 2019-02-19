package com.company.rpgrunner.repository.item;

import com.company.rpgrunner.repository.ComponentLoader;
import com.company.rpgrunner.repository.item.model.Item;

import static com.company.rpgrunner.commons.GameResourcesPath.ITEM_PATH;

/**
 * Created by Leonardo Tonin on 18/02/19.
 */
public class ItemLoader extends ComponentLoader<Item> {

    public ItemLoader() {
        super(Item.class);
    }

    @Override
    protected String getPath() {
        return ITEM_PATH;
    }
}
