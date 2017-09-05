package com.fastdeliveryservice.controller;

import com.fastdeliveryservice.domain.RestaurantDto;
import com.fastdeliveryservice.service.RestaurantSeedDataService;
import com.fastdeliveryservice.service.RestaurantService;
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
 * Created by Martina
 */


@RestController
public class RestaurantController {

    private RestaurantSeedDataService restaurantSeedDataService;

    private RestaurantService restaurantService;

    //Injection parameters
    @Autowired
    public RestaurantController(RestaurantSeedDataService restaurantSeedDataService, RestaurantService restaurantService) {
            this.restaurantSeedDataService = restaurantSeedDataService;
            this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/restaurants/{city}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<RestaurantDto>>> getRestaurantByCityRpc(@PathVariable("city") String city) {
        List<RestaurantDto> results = restaurantService.getRestaurantMessageRpc(city);
        return new ResponseEntity<>(Collections.singletonMap("restaurants", results), HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurants/drop", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteAllRestaurants() {

     // TODO:   RestaurantRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}