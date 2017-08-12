package com.fastdeliveryservice.service;


import com.fastdeliveryservice.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Martina on 31/07/2017.
 */




@Service
public class LocationSeedDataService {

    private LocationService locationList;

    private List<Location> locations = new ArrayList<>();

    @Autowired
    public LocationSeedDataService(LocationService locationList) {
        this.locationList = locationList;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void populateLocation()
    {
        locations.add(new Location(43.843944,12.745768,"Vallefoglia","Pizza Express"));
        locations.add(new Location(43.899871,12.905846,"Pesaro","Pizza Mare"));
        locations.add(new Location(43.900614,12.919407,"Pesaro","Pizza Peppe"));
    }

    // returns random number as string
    private String getRandomIntAsString(int min, int max) {
        int randomVoteCount = ThreadLocalRandom.current().nextInt(min, max + 1);
        return Integer.toString(randomVoteCount);
    }

}