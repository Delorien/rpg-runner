package com.company.rpgrunner.repository.map;

import com.company.rpgrunner.repository.ComponentLoader;
import com.company.rpgrunner.repository.map.model.Location;

import static com.company.rpgrunner.util.GameResourcesPath.LOCATION_PATH;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class LocationLoader extends ComponentLoader<Location> {

    public LocationLoader() {
        super(Location.class);
    }

    @Override
    protected String getPath() {
        return LOCATION_PATH;
    }
}
