package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.ProductRestaurantDAO;
import com.fastdeliveryservice.domain.ProductRestaurantDto;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martina Gabellini
 */

@Service
public class ProductRestaurantService implements IProductRestaurantService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

    @Autowired
    private ProductRestaurantDAO productRestaurantDAO;

    @Autowired
    public ProductRestaurantService(Environment environment,
                          RabbitTemplate rabbitTemplate,
                          DirectExchange directExchange) {
        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

     /* Consumes location list based on election query
     *
             * @param coordinateX
     * @param coordinateY
     * @return List of locations
     */

    @SuppressWarnings("unchecked")
    public List<ProductRestaurantDto> getProductByRestaurantId(int idRestaurant) {

        String restaurants = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.ProductRestaurantList", idRestaurant);

        TypeReference<Map<String, List<ProductRestaurantDto>>> mapType = new TypeReference<Map<String, List<ProductRestaurantDto>>>() { };

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, List<ProductRestaurantDto>> restaurantsMap = new HashMap<>();

        try {
            restaurantsMap = objectMapper.readValue(restaurants, mapType);
        }
        catch (IOException e) {
            logger.info(String.valueOf(e));
        }

        List<ProductRestaurantDto> restaurantsList = restaurantsMap.get("productRestaurants");

        if (logger.isDebugEnabled()) {
            logger.debug("List of {} locations received...", restaurantsList.size());
        }

        return restaurantsList;
    }

    @Override
    public List<ProductRestaurant> getAllProductsByRestaurant(int idRestaurant) {
        return null;
    }

    @Override
    public ProductRestaurantDto getProductRestaurantById(int id) {
        String productRestaurant = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.ProductRestaurant", id);

        TypeReference<Map<String, ProductRestaurantDto>> mapType = new TypeReference<Map<String, ProductRestaurantDto>>() { };

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, ProductRestaurantDto> restaurantsMap = new HashMap<>();

        try {
            restaurantsMap = objectMapper.readValue(productRestaurant, mapType);
        }
        catch (IOException e) {
            logger.info(String.valueOf(e));
        }

        ProductRestaurantDto dto = restaurantsMap.get("productRestaurant");
        return dto;
    }

//    @Override
//    public List<ProductRestaurant> getAllProductsByRestaurant (int id) {
//        String productRestaurant = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantId", id);
//
//
//
//        List<ProductRestaurant> productRestaurant = productRestaurantDAO.getProductListByRestaurantId(id);
//        return productRestaurant;
//    }

    @Override
    public synchronized boolean addProductRestaurant(ProductRestaurantDto productRestaurantDto){
        String pr = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.AddProductRestaurant", productRestaurantDto);

        if (logger.isDebugEnabled()) {
            logger.debug("Request Add Product Restaurant received...", pr);
        }

        return true;
    }

    @Override
    public synchronized boolean updateProductRestaurant(ProductRestaurantDto productRestaurantDto) {
        String pr = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.UpdateProductRestaurant", productRestaurantDto);

        if (logger.isDebugEnabled()) {
            logger.debug("Request Update Product Restaurant received...", pr);
        }

        return true;
    }

    @Override
    public boolean deleteProductRestaurant(ProductRestaurantDto productRestaurantDto) {
        String pr = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.DeleteProductRestaurant", productRestaurantDto);

        if (logger.isDebugEnabled()) {
            logger.debug("Request Delete Product Restaurant received...", pr);
        }

        return true;
    }
}