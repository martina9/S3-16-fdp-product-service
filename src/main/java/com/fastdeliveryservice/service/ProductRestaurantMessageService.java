package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.ProductDAO;
import com.fastdeliveryservice.dao.ProductRestaurantDAO;

import com.fastdeliveryservice.dao.RestaurantDAO;
import com.fastdeliveryservice.domain.ProductRestaurantDto;

import com.fastdeliveryservice.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina Gabellini
 */

public class ProductRestaurantMessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

    @Autowired
    private ProductRestaurantDAO productRestaurantDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private RestaurantDAO restaurantDAO;

    @Autowired
    public ProductRestaurantMessageService(Environment environment,
                                           RabbitTemplate rabbitTemplate,
                                           DirectExchange directExchange) {

        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.ProductRestaurantById")
    private String ProductRestaurantById(int productRestaurantId) {
        logger.debug("Sending RPC response message with id of created order...");
        ProductRestaurant restaurant =  productRestaurantDAO.getProductRestaurant(productRestaurantId);
        return serializeToJson(restaurant);
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantId")
    private String  ProductRestaurantByRestaurantId(int restaurantId) {
        logger.debug("Sending RPC response message with id of created order...");

        List<ProductRestaurant> products =  productRestaurantDAO.getProductListByRestaurantId(restaurantId);
        return serializeToJson(products);
    }

    //Add Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.AddProductRestaurant")
    private boolean AddProductRestaurant(ProductRestaurantDto productRestaurantDtO) {
        logger.debug("Sending RPC response message with id of created order...");

        ProductRestaurant productRestaurant = new ProductRestaurant();
        productRestaurant.setPrice(productRestaurantDtO.getPrice());
        productRestaurant.setName(productRestaurantDtO.getName());

        Restaurant restaurant = restaurantDAO.getRestaurantById(productRestaurantDtO.getRestaurant().getId());
        productRestaurant.setRestaurant(restaurant);

        Product product = productDAO.getId(productRestaurantDtO.getProduct().getId());
        productRestaurant.setProduct(product);

        //Add Product Restaurant
        productRestaurantDAO.addProductRestaurant(productRestaurant);

        return true;
    }

    //Update Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.UpdateProductRestaurant")
    private boolean UpdateProductRestaurant(ProductRestaurantDto productRestaurantDtO) {
        logger.debug("Sending RPC response message with id of created order...");

        //call method in line 52
        //Get product restaurant by id
        ProductRestaurant productRestaurant = productRestaurantDAO.getProductRestaurant(productRestaurantDtO.getId());
        productRestaurant.setPrice(productRestaurantDtO.getPrice());
        productRestaurant.setName(productRestaurantDtO.getName());
        //Update Product Restaurant
        productRestaurantDAO.updateProductRestaurant(productRestaurant);
        return true;
    }

    //Delete Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.DeleteProductRestaurant")
    private void DeleteProductRestaurant(ProductRestaurantDto productRestaurantDtO) {
        logger.debug("Sending RPC response message with id of created order...");

        //Delete Product Restaurant from ID
        productRestaurantDAO.deleteProductRestaurant(productRestaurantDtO.getId());
    }

    private String serializeToJson(List<ProductRestaurant> productRestaurants) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        final Map<String, List<ProductRestaurant>> dataMap = new HashMap<>();
        dataMap.put("productRestaurant", productRestaurants);

        try {
            jsonInString = mapper.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }

    private String serializeToJson(ProductRestaurant productRestaurant) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(productRestaurant);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);
        return jsonInString;
    }
}