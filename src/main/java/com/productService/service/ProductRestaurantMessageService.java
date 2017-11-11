package com.productService.service;

import FDP.ProductService.MessageDirectory.Response.AddProductRestaurant;
import FDP.ProductService.MessageDirectory.Response.DeleteProductRestaurant;
import FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo;
import FDP.ProductService.MessageDirectory.Response.UpdateProductRestaurant;

import com.productService.dao.ProductDAOImpl;
import com.productService.dao.ProductRestaurantDAOImpl;
import com.productService.dao.RestaurantDAOImpl;

import com.productService.model.Product;
import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.core.DirectExchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.core.env.Environment;

import java.util.List;

import static com.productService.utility.Mapper.convertList;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private ProductRestaurantDAOImpl productRestaurantDAOImpl;

    @Autowired
    private ProductDAOImpl productDAOImpl;

    @Autowired
    private RestaurantDAOImpl restaurantDAOImpl;

    @Autowired
    public ProductRestaurantMessageService(Environment environment,
                                           RabbitTemplate rabbitTemplate,
                                           DirectExchange directExchange) {

        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantInfo")
    private FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo ProductRestaurantById(FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo productRestaurantInfo) {
        logger.debug("Sending RPC response message with id of created order...");
        logger.debug("Sending RPC response message with id of created order.Int.");

        ProductRestaurant productRestaurant =  productRestaurantDAOImpl.getProductRestaurant(productRestaurantInfo.getId());
        ProductRestaurantInfo productInfo = ConvertFromProduct(productRestaurant);
        return productInfo;
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantList")
    private FDP.ProductService.MessageDirectory.Response.ProductRestaurantList ProductRestaurantList(FDP.ProductService.MessageDirectory.Request.ProductRestaurantList request) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        FDP.ProductService.MessageDirectory.Response.ProductRestaurantList productList = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantList();

        List<ProductRestaurant> productRestaurants =  productRestaurantDAOImpl.getProductListByRestaurantId(request.getRestaurantId());

        List<ProductRestaurantInfo> productInfo  = convertList(productRestaurants, s -> new ProductRestaurantInfo(s.getId(),s.getPrice(),1,s.getName(),s.getProduct().getId(),s.getRestaurant().getId(),s.getRestaurant().getName(),s.getProduct().getName()));
        productList.setItems(productInfo);
        return productList;
    }

    //Add Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.AddProductRestaurant")
    private AddProductRestaurant AddProductRestaurant(FDP.ProductService.MessageDirectory.Request.AddProductRestaurant request) throws Exception {
        logger.debug("Sending RPC response message with id of created order...");
        ProductRestaurant productToSave = new ProductRestaurant();
        Product product = productDAOImpl.getId(request.getProductId());
        Restaurant restaurant = restaurantDAOImpl.getRestaurantById(request.getRestaurantId());
        productToSave.setProduct(product);
        productToSave.setRestaurant(restaurant);
        productToSave.setName(request.getName());
        productToSave.setPrice(request.getPrice());
        productToSave.setQuantity(request.getQuantity());

        int id = productRestaurantDAOImpl.addProductRestaurant(productToSave);

        AddProductRestaurant response = new AddProductRestaurant();
        response.setId(id);
        return response;
    }

    //Update Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.UpdateProductRestaurant")
    private UpdateProductRestaurant UpdateProductRestaurant(FDP.ProductService.MessageDirectory.Request.UpdateProductRestaurant request) {
        logger.debug("Sending RPC response message with id of update product restaurant...");

        ProductRestaurant productToUpdate = productRestaurantDAOImpl.getProductRestaurant(request.getId());
        Product product = productDAOImpl.getId(request.getProductId());
        Restaurant restaurant = restaurantDAOImpl.getRestaurantById(request.getRestaurantId());
        productToUpdate.setProduct(product);
        productToUpdate.setRestaurant(restaurant);
        productToUpdate.setName(request.getName());
        productToUpdate.setPrice(request.getPrice());
        productToUpdate.setQuantity(request.getQuantity());
        productRestaurantDAOImpl.updateProductRestaurant(productToUpdate);
        UpdateProductRestaurant response = new UpdateProductRestaurant();
        response.setId(request.getId());
        return response;
    }

    //Delete Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.DeleteProductRestaurant")
    private DeleteProductRestaurant DeleteProductRestaurant(FDP.ProductService.MessageDirectory.Request.DeleteProductRestaurant request) {
        logger.debug("Sending RPC response message with id of created order...");
        productRestaurantDAOImpl.deleteProductRestaurant(request.getId());
        //Delete Product Restaurant from
        DeleteProductRestaurant response = new DeleteProductRestaurant();
        response.setId(request.getId());
        return response;
    }

    public ProductRestaurantInfo ConvertFromProduct(ProductRestaurant product) {
        ProductRestaurantInfo productRestaurantInfo = new ProductRestaurantInfo();
        productRestaurantInfo.setProductId(product.getProduct().getId());
        productRestaurantInfo.setRestaurantId(product.getRestaurant().getId());
        productRestaurantInfo.setPrice(product.getPrice());
        productRestaurantInfo.setId(product.getId());
        productRestaurantInfo.setName(product.getName());
        productRestaurantInfo.setQuantity(product.getQuantity());
        productRestaurantInfo.setProductName(product.getProduct().getName());
        productRestaurantInfo.setRestaurantName(product.getRestaurant().getName());
        return productRestaurantInfo;

    }
}