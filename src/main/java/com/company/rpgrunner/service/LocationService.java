package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.map.model.Location;
import com.company.rpgrunner.repository.map.LocationLoader;
import com.company.rpgrunner.ui.Response;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class LocationService {

    private final LocationLoader locationLoader;

    public LocationService() {
        this.locationLoader = new LocationLoader();
    }

    public Response goTo(String target) {
        Optional<Location> optionalLocation = locationLoader.load(target);

        return new Response(optionalLocation.get().getDescription());
    }
}
