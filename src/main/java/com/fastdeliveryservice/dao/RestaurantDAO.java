package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Martina Gabellini
 */

@Transactional
@Repository
public class RestaurantDAO implements IRestaurantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return entityManager.find(Restaurant.class, restaurantId);
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        String hql = "Select r FROM Restaurant as r join r.addressRestaurants as adr WHERE adr.city = :city";
        List<Restaurant> restaurant = ( List<Restaurant> ) entityManager.createQuery(hql).setParameter("city", city).getResultList();
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        String hql = "Select r FROM Restaurant as r ORDER BY r.id";
        return (List<Restaurant>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Restaurant dbRestaurant = getRestaurantById(restaurant.getId());
        //dbRestaurant.setCode(restaurant.getCode());
                entityManager.flush();
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        entityManager.remove(getRestaurantById(restaurantId));
    }

    @Override
    public boolean RestaurantExists(String code) {
        String hql = "FROM Product as p WHERE p.code = :code";
        int count = entityManager.createQuery(hql).setParameter("code", code).getResultList().size();
        return count > 0 ? true : false;
    }
} 
