package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.ProductDAO;
import com.fastdeliveryservice.dao.ProductRestaurantDAO;
import com.fastdeliveryservice.dao.RestaurantDAO;
import com.fastdeliveryservice.domain.ProductDto;
import com.fastdeliveryservice.domain.ProductRestaurantDto;
import com.fastdeliveryservice.domain.RestaurantDto;
import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;
import com.fastdeliveryservice.model.Restaurant;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  mGabellini
 */

@Component
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
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.ProductRestaurant")
    private String ProductRestaurantById(int productRestaurantId) {
        logger.debug("Sending RPC response message with id of created order...");
        ProductRestaurant restaurant =  productRestaurantDAO.getProductRestaurant(productRestaurantId);
        return serializeToJson(restaurant);
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantId")
    private String  ProductRestaurantByRestaurantById(int restaurantId) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        List<ProductRestaurant> products = new ArrayList<>();

            List<ProductRestaurant> tempProducts =  productRestaurantDAO.getProductListByRestaurantId(restaurantId);
            if(!tempProducts.isEmpty()) {
                products.addAll(tempProducts);
            }

       return serializeToJson(products);
    }

    //Get Restaurant by code
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.ProductRestaurantByRestaurantCode")
    private String  ProductRestaurantByRestaurantByCode(String restaurantCode) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        List<ProductRestaurant> products;

       if( restaurantCode != null){
            products =  productRestaurantDAO.getProductListByRestaurantCode(restaurantCode);
        }
        else{
            throw new Exception("Params not found , missing RestaurantID or RestaurantCode");
        }
        return serializeToJson(products);
    }

    //Add Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.AddProductRestaurant")
    private Integer AddProductRestaurant(ProductRestaurantDto productRestaurantDtO) throws Exception {
        logger.debug("Sending RPC response message with id of created order...");

        if(productRestaurantDtO.getRestaurant() == null)
        {
            throw new Exception("Restaurant is null");
        }

        if(productRestaurantDtO.getProduct() == null)
        {
            throw new Exception("Product is null");
        }

        ProductRestaurant productRestaurant = new ProductRestaurant();
        productRestaurant.setPrice(productRestaurantDtO.getPrice());
        productRestaurant.setName(productRestaurantDtO.getName());

        Restaurant restaurant = restaurantDAO.getRestaurantById(productRestaurantDtO.getRestaurant().getId());
        productRestaurant.setRestaurant(restaurant);

        Product product = productDAO.getId(productRestaurantDtO.getProduct().getId());
        productRestaurant.setProduct(product);

        //Add Product Restaurant
        int productId = productRestaurantDAO.addProductRestaurant(productRestaurant);
        return productId;
    }

    //Update Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.UpdateProductRestaurant")
    private boolean UpdateProductRestaurant(ProductRestaurantDto productRestaurantDtO) {
        logger.debug("Sending RPC response message with id of update product restaurant...");

        //Get product restaurant by id
        ProductRestaurant productRestaurant = productRestaurantDAO.getProductRestaurant(productRestaurantDtO.getId());
        productRestaurant.setPrice(productRestaurantDtO.getPrice());
        productRestaurant.setName(productRestaurantDtO.getName());

        Product product = productDAO.getId(productRestaurantDtO.getProduct().getId());
        productRestaurant.setProduct(product);

        Restaurant restaurant = restaurantDAO.getRestaurantById(productRestaurantDtO.getRestaurant().getId());
        productRestaurant.setRestaurant(restaurant);

        //Update Product Restaurant
        productRestaurantDAO.updateProductRestaurant(productRestaurant);
        return true;
    }

    //Delete Product Restaurant
    @RabbitListener(queues = "FDP.DeliveryMessageService:Request.DeleteProductRestaurant")
    private void DeleteProductRestaurant(int id) {
        logger.debug("Sending RPC response message with id of created order...");

        //Delete Product Restaurant from ID
        productRestaurantDAO.deleteProductRestaurant(id);
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
        ProductRestaurantDto productRestaurantDto = new ProductRestaurantDto();
        productRestaurantDto.setPrice(productRestaurant.getPrice());
        productRestaurantDto.setName(productRestaurant.getName());
        productRestaurantDto.setId(productRestaurant.getId());

        ProductDto productDto = new ProductDto();
        productDto.setId(productRestaurant.getProduct().getId());
        productRestaurantDto.setProduct(productDto);

        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(productRestaurant.getRestaurant().getId());
        productRestaurantDto.setRestaurant(restaurantDto);

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