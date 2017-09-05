package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.RestaurantDAO;
import com.fastdeliveryservice.model.Restaurant;
import com.fastdeliveryservice.utility.SerializerUtils;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina Gabellini
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

    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.RestaurantList")
    private String getRestaurantMessageByCity(String city) {
        logger.debug("Request message: {}", city);
        logger.debug("Sending RPC response message with list of Restaurants...");

        List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCity(city);
        return serializeToJson(restaurants);
    }

    private String serializeToJson(List<Restaurant> restaurants) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        final Map<String, List<Restaurant>> dataMap = new HashMap<>();
        dataMap.put("restaurants", restaurants);

        try {
            jsonInString = mapper.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }
    private String serializeToJson(Restaurant restaurant) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(restaurant);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);
        return jsonInString;
    }
}
