package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.map.LocationLoader;
import com.company.rpgrunner.repository.map.model.Location;
import com.company.rpgrunner.ui.response.LookAroundResponse;
import com.company.rpgrunner.ui.response.PicturePrintableResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import java.util.Optional;

import static com.company.rpgrunner.commons.GameMessage.INVALID_CHOICE;
import static com.company.rpgrunner.commons.GameMessage.getMessage;

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

        if (isInvalidWay(target)) {
            return new SimpleMessageResponse(getMessage(INVALID_CHOICE));
        }

        Optional<Location> optionalLocation = locationLoader.load(target.toLowerCase());
        if (!optionalLocation.isPresent()) {
            return new SimpleMessageResponse(getMessage(INVALID_CHOICE));
        }

        actualLocation = optionalLocation.get();
        return new PicturePrintableResponse(actualLocation, actualLocation.getDescription());
    }

    private Boolean isInvalidWay(String target) {
        return actualLocation != null && !actualLocation.getWays().stream().anyMatch(l -> l.getNextLocationName().equalsIgnoreCase(target));
    }

    public Response lookAround() {
        return new LookAroundResponse(actualLocation);
    }

    public Response whereAmI() {
        return new SimpleMessageResponse(actualLocation.getName());
    }

    public Location getActualLocation() {
        return actualLocation;
    }
}
