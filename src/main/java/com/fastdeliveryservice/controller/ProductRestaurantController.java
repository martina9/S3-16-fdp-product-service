package com.fastdeliveryservice.controller;

import com.fastdeliveryservice.domain.ProductRestaurantDto;
import com.fastdeliveryservice.service.ProductRestaurantService;
import com.fastdeliveryservice.service.RestaurantSeedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina Gabellini
 */


@RestController
public class ProductRestaurantController {

    private RestaurantSeedDataService restaurantSeedDataService;

    private ProductRestaurantService productRestaurantService;

    //Injection parameters
    @Autowired
    public ProductRestaurantController(RestaurantSeedDataService restaurantSeedDataService, ProductRestaurantService productRestaurantService) {
            this.restaurantSeedDataService = restaurantSeedDataService;
            this.productRestaurantService = productRestaurantService;
    }

    @RequestMapping(value = "/products/restaurant/{idRestaurant}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<ProductRestaurantDto>>> getProductsByRestaurantId(@PathVariable("idRestaurant") int idRestaurant) {
        List<ProductRestaurantDto> productRestaurantDto = productRestaurantService.getProductByRestaurantId(idRestaurant);
        return new ResponseEntity<>(Collections.singletonMap("restaurants", productRestaurantDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ProductRestaurantDto>> getProductRestaurantById(@PathVariable("Id") int id){

        ProductRestaurantDto productRestaurantDto = productRestaurantService.getProductRestaurantById(id);

        Map<String, ProductRestaurantDto> result = new HashMap<>();
        result.put("productRestaurant", productRestaurantDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(value = "/products/drop/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAllRestaurants() {

     // TODO:   RestaurantRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}