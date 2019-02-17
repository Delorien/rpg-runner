package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.map.LocationLoader;
import com.company.rpgrunner.repository.map.model.Location;
import com.company.rpgrunner.ui.response.LookAroundResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class LocationService {

    private static LocationService INSTANCE;
    private final LocationLoader locationLoader;
    private Location actualLocation;

    private LocationService() {
        locationLoader = new LocationLoader();
    }

    public static LocationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocationService();
        }
        return INSTANCE;
    }

    public Response goTo(String target) {
        Optional<Location> optionalLocation = locationLoader.load(target.toLowerCase());
        actualLocation = optionalLocation.get();
        return new SimpleMessageResponse(actualLocation.getDescription());
    }

    public Response lookAround() {
        return new LookAroundResponse(actualLocation);
    }
}
