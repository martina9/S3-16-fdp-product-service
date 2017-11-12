package com.productService.dao;

import com.productService.model.Restaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface RestaurantDAO {

    /**
     * Return an List<Restaurant> implementation this interface.
     *
     * @return List<Restaurant>
     */

    List<Restaurant> getAllRestaurants();

    /**
     * Return an Restaurant implementation this interface.
     *
     * @param restaurantId
     * @return Restaurant
     */

    Restaurant getRestaurantById(int restaurantId);

    /**
     * Return an added Restaurant implementation this interface.
     *
     * @param restaurant
     */

    int addRestaurant(Restaurant restaurant);

    /**
     * Return an updated Restaurant implementation this interface.
     *
     * @param restaurant
     */

    int updateRestaurant(Restaurant restaurant);

    /**
     * Return an deleted Restaurant implementation this interface.
     *
     * @param restaurantId
     */

    int deleteRestaurant(int restaurantId);

    /**
     * Return an boolean to check if restaurant exists implementation this interface.
     *
     * @param code
     * @return boolean check if product existed
     */

    boolean RestaurantExists(String code);

    /**
     * Return an List<Restaurant> by city implementation this interface.
     *
     * @return List<Restaurant>
     */

    List<Restaurant> getRestaurantsByCity(String city);
}