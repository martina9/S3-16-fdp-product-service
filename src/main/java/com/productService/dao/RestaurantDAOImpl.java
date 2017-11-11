package com.productService.dao;

import com.productService.model.Restaurant;

import javax.persistence.EntityManager;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;

/**
 * @author  mGabellini
 */

@Transactional
@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Return an Restaurant by id using query.
     *
     * @return Restaurant
     */

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return entityManager.find(Restaurant.class, restaurantId);
    }

    /**
     * Return an List<Restaurant> by city using query.
     *
     * @return List<Restaurant>
     */

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        String hql = "Select r FROM Restaurant as r join r.addressRestaurants as adr WHERE :city is null or adr.city = :city";
        List<Restaurant> restaurant = ( List<Restaurant> ) entityManager.createQuery(hql).setParameter("city", city).getResultList();
        return restaurant;
    }

    /**
     * Return an List<Restaurant> using query.
     *
     * @return List<Restaurant>
     */

    @Override
    public List<Restaurant> getAllRestaurants() {
        String hql = "Select r FROM Restaurant as r ORDER BY r.id";
        return (List<Restaurant>) entityManager.createQuery(hql).getResultList();
    }

    /**
     * Return an added restaurant.
     *
     * @param restaurant
     * @return entityManager to add restaurant
     */

    @Override
    public void addRestaurant(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }

    /**
     * Return an updated restaurant.
     *
     * @param restaurant
     * @return entityManager to update restaurant
     */

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Restaurant dbRestaurant = getRestaurantById(restaurant.getId());
        //dbRestaurant.setCode(restaurant.getCode());
                entityManager.flush();
    }

    /**
     * Return an deleted restaurant.
     *
     * @param restaurantId
     * @return entityManager to delete restaurant
     */

    @Override
    public void deleteRestaurant(int restaurantId) {
        entityManager.remove(getRestaurantById(restaurantId));
    }

    /**
     * Return an count to check if restaurant exists.
     *
     * @param code
     * @return boolean to query restaurant from code
     */

    @Override
    public boolean RestaurantExists(String code) {
        String hql = "FROM Product as p WHERE p.code = :code";
        int count = entityManager.createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }
} 
