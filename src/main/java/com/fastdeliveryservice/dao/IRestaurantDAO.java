package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Restaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface IRestaurantDAO {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(int restaurantId);

    void addRestaurant(Restaurant restaurant);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(int restaurantId);

    boolean RestaurantExists(String code);

    List<Restaurant> getRestaurantsByCity(String city);
}