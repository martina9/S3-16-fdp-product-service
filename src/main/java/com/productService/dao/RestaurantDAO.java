package com.productService.dao;

import com.productService.model.Restaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface RestaurantDAO {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(int restaurantId);

    void addRestaurant(Restaurant restaurant);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(int restaurantId);

    boolean RestaurantExists(String code);

    List<Restaurant> getRestaurantsByCity(String city);
}