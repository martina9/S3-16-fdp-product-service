package com.productService.service;

import FDP.ProductService.MessageDirectory.Request.RestaurantInfo;
import FDP.ProductService.MessageDirectory.Request.RestaurantList;
import FDP.ProductService.MessageDirectory.Response.ProductInfo;
import FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo;
import com.productService.dao.RestaurantDAO;
import com.productService.model.AddressRestaurant;
import com.productService.model.Product;
import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.productService.utility.Mapper.convertList;

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
    private RestaurantDAO restaurantDAO;

    @Autowired
    public RestaurantMessageService(Environment environment, RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.RestaurantList")
    private FDP.ProductService.MessageDirectory.Response.RestaurantList getRestaurantMessageByCity(RestaurantList request) {
        logger.debug("Request message: {}", request.getCity());
        logger.debug("Sending RPC response message with list of Restaurants...");

        List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCity(request.getCity());
        FDP.ProductService.MessageDirectory.Response.RestaurantList restaurantList = new FDP.ProductService.MessageDirectory.Response.RestaurantList();

        List<RestaurantInfo> restaurantInfoList = convertList(restaurants, s -> ConvertFromRestaurant(s));
        restaurantList.setItems(restaurantInfoList);
        return restaurantList;
    }

    public RestaurantInfo ConvertFromRestaurant(Restaurant restaurant)
    {
        RestaurantInfo restaurantInfo = new RestaurantInfo();
        Optional<AddressRestaurant> address = restaurant.getAddressRestaurants().stream().findFirst();
        if(address.isPresent())
        {
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
