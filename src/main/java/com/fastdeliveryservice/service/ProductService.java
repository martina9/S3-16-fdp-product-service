package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.ProductDAO;
import com.fastdeliveryservice.domain.ProductDto;
import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.domain.ProductDto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martina
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 */

@Service
public class ProductService implements IProductService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    public ProductService(Environment environment,
                           RabbitTemplate rabbitTemplate,
                           DirectExchange directExchange)
    {
        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    @Override
    public Product getProductById(int productId) {
        Product obj = productDAO.getId(productId);
        return obj;
    /**
     * Produces message request containing product id
     *
     * @param id
     * @return Product by Id
     */

    @SuppressWarnings("unchecked")
    public ProductDto getProductById(int id) {
        logger.debug("Sending RPC request message for getting order...");

        String order = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.Product", id);

        TypeReference<Map<String, ProductDto>> mapType = new TypeReference<Map<String, ProductDto>>() {
        };

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, ProductDto> restaurantsMap = new HashMap<>();

        try {
            restaurantsMap = objectMapper.readValue(order, mapType);
        } catch (IOException e) {
            logger.info(String.valueOf(e));
        }

        ProductDto productDto = restaurantsMap.get("product");

        if (logger.isDebugEnabled()) {
            logger.debug("Product received...", productDto.getId());
        }

        return productDto;
    }

    @Override
    public List<Product> getAllProductsByRestaurant (int idRestaurant) {
        return productDAO.getAllProducts();
    }

    @Override
    public synchronized boolean addProduct(Product Product){
        if (productDAO.ProductExists(Product.getCode())) {
            return false;
        } else {
            productDAO.addProduct(Product);
            return true;
        }
    }

    @Override
    public void updateProduct(Product Product) {
        productDAO.updateProduct(Product);
    }

    @Override
    public void deleteProduct(int ProductId) {
        productDAO.deleteProduct(ProductId);
    public synchronized boolean add(ProductDto productDto){
        logger.debug("Sending RPC request message for getting order...");
        boolean resultProductId = (boolean) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.AddProduct", productDto);

        if (logger.isDebugEnabled()) {
            logger.debug("Product received...", resultProductId);
        }

        return resultProductId;
    }

    @SuppressWarnings("unchecked")
    public boolean update(ProductDto product) {
        logger.debug("Sending RPC request message for getting product...");

        boolean resultProductId = (boolean) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.UpdateProduct", product);

        if (logger.isDebugEnabled()) {
            logger.debug("Product received...", resultProductId);
        }

        return resultProductId;
    }

    @SuppressWarnings("unchecked")
    public boolean delete(ProductDto productDto){
        String pr = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "FDP.DeliveryMessageService:Request.DeleteProduct", productDto);

        if (logger.isDebugEnabled()) {
            logger.debug("Request Delete Product received...", pr);
        }

        return true;
    }

    /**
     * Produces query message containing election
     * Consumes location list based on election query
     *
     * @param id
     * @return List of locations
     */

    @SuppressWarnings("unchecked")
    public List<ProductDto> getProductMessageRpc(int id) {
        logger.debug("Sending RPC request message for list of locations...");

        return new ArrayList<ProductDto>();
    }
}
