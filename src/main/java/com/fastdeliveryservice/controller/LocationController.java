package com.fastdeliveryservice.controller;

import com.fastdeliveryservice.domain.LocationView;
//import com.locationapi.location.repository.LocationRepository;
import com.fastdeliveryservice.service.LocationSeedDataService;
import com.fastdeliveryservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina on 31/07/2017.
 */



@RestController
public class LocationController {

    private LocationSeedDataService locationSeedDataService;

    private LocationService locationService;

    @Autowired
    public LocationController(
                           LocationSeedDataService locationSeedDataService,
                           LocationService locationService) {
        this.locationSeedDataService = locationSeedDataService;
        this.locationService = locationService;
    }

    @RequestMapping(value = "/locations/{coordinateX}/{coordinateY}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<LocationView>>> getCandidatesHttp(@PathVariable("coordinateX") double coordinateX,@PathVariable("coordinateY") double coordinateY) {
        List<LocationView> results = locationService.getLocationsSyncHttp(coordinateX,coordinateY);
        return new ResponseEntity<>(Collections.singletonMap("locations", results), HttpStatus.OK);
    }

    @RequestMapping(value = "/locations/rpc/{coordinateX}/{coordinateY}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<LocationView>>> getCandidatesRpc(@PathVariable("coordinateX") double coordinateX,@PathVariable("coordinateY") double coordinateY) {

        List<LocationView> results = locationService.getCandidatesMessageRpc(coordinateX,coordinateY);
        return new ResponseEntity<>(Collections.singletonMap("locations", results), HttpStatus.OK);
    }


    @RequestMapping(value = "/locations/drop", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteAllLocations() {

     // TODO:   locationRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}