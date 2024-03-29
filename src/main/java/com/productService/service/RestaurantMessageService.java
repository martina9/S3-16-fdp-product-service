package com.productService.service;

import FDP.ProductService.MessageDirectory.Request.RestaurantInfo;
import FDP.ProductService.MessageDirectory.Request.RestaurantList;

import com.productService.dao.RestaurantDAOImpl;
import com.productService.model.AddressRestaurant;

import com.productService.model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;
import java.util.*;

import static com.productService.utility.Mapper.convertList;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

/**
 * @author  mGabellini
 */

@Component
public class RestaurantMessageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    private RestaurantDAOImpl restaurantDAOImpl;

    /**
     * Constructor
     *
     * @param environment
     * @param rabbitTemplate
     * @param directExchange
     */

    @Autowired
    public RestaurantMessageService(Environment environment, RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    /**
     * Return an RestaurantList
     *
     * @param request
     * @return List<RestaurantInfo>
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.RestaurantList")
    public FDP.ProductService.MessageDirectory.Response.RestaurantList getRestaurantMessageByCity(RestaurantList request) {
        List<Restaurant> restaurants = restaurantDAOImpl.getRestaurantsByCity(request.getCity());

        FDP.ProductService.MessageDirectory.Response.RestaurantList restaurantList = new FDP.ProductService.MessageDirectory.Response.RestaurantList();

        List<RestaurantInfo> restaurantInfoList = convertList(restaurants, s -> convertFromRestaurant(s));
        restaurantList.setItems(restaurantInfoList);
        return restaurantList;
    }

    /**
     * Return an RestaurantInfo from Restaurant
     *
     * @param restaurant
     * @return RestaurantInfo
     */

    public RestaurantInfo convertFromRestaurant(Restaurant restaurant) {
        RestaurantInfo restaurantInfo = new RestaurantInfo();
        Optional<AddressRestaurant> address = restaurant.getAddressRestaurants().stream().findFirst();
        if(address.isPresent()) {
            restaurantInfo.setAddress(address.get().getStreet());
            restaurantInfo.setCity(address.get().getCity());
            restaurantInfo.setPhoneNumber(address.get().getPhoneNumber());
            restaurantInfo.setZipCode(address.get().getZipCode());
            restaurantInfo.setEmail(address.get().getEmail());
        }
        restaurantInfo.setCode(restaurant.getCode());
        restaurantInfo.setId(restaurant.getId());
        restaurantInfo.setName(restaurant.getName());
        return restaurantInfo;
    }
}