package com.productService.service;

import FDP.ProductService.MessageDirectory.Response.ProductRestaurantList;
import FDP.ProductService.MessageDirectory.Response.AddProductRestaurant;
import FDP.ProductService.MessageDirectory.Response.DeleteProductRestaurant;
import FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo;
import FDP.ProductService.MessageDirectory.Response.UpdateProductRestaurant;
import com.productService.dao.ProductDAO;
import com.productService.dao.ProductRestaurantDAO;
import com.productService.dao.RestaurantDAO;
import com.productService.model.Product;
import com.productService.model.ProductRestaurant;
import com.productService.model.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.productService.utility.Mapper.convertList;

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
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantInfo")
    private FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo ProductRestaurantById(FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo productRestaurantInfo) {
        logger.debug("Sending RPC response message with id of created order...");
        logger.debug("Sending RPC response message with id of created order.Int.");

        ProductRestaurant productRestaurant =  productRestaurantDAO.getProductRestaurant(productRestaurantInfo.getId());
        ProductRestaurantInfo productInfo = ConvertFromProduct(productRestaurant);
        return productInfo;
    }

    //Get Restaurant by ID
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantList")
    private FDP.ProductService.MessageDirectory.Response.ProductRestaurantList ProductRestaurantList(FDP.ProductService.MessageDirectory.Request.ProductRestaurantList request) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        FDP.ProductService.MessageDirectory.Response.ProductRestaurantList productList = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantList();

        List<ProductRestaurant> productRestaurants =  productRestaurantDAO.getProductListByRestaurantId(request.getRestaurantId());

        List<ProductRestaurantInfo> productInfo  = convertList(productRestaurants, s -> new ProductRestaurantInfo(s.getId(),s.getPrice(),1,s.getName(),s.getProduct().getId(),s.getRestaurant().getId(),s.getRestaurant().getName(),s.getProduct().getName()));
        productList.setItems(productInfo);
        return productList;
    }

    //Add Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.AddProductRestaurant")
    private AddProductRestaurant AddProductRestaurant(FDP.ProductService.MessageDirectory.Request.AddProductRestaurant request) throws Exception {
        logger.debug("Sending RPC response message with id of created order...");
        ProductRestaurant productToSave = new ProductRestaurant();
        Product product = productDAO.getId(request.getProductId());
        Restaurant restaurant = restaurantDAO.getRestaurantById(request.getRestaurantId());
        productToSave.setProduct(product);
        productToSave.setRestaurant(restaurant);
        productToSave.setName(request.getName());
        productToSave.setPrice(request.getPrice());
        productToSave.setQuantity(request.getQuantity());

        int id = productRestaurantDAO.addProductRestaurant(productToSave);

        AddProductRestaurant response = new AddProductRestaurant();
        response.setId(id);
        return response;
    }

    //Update Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.UpdateProductRestaurant")
    private UpdateProductRestaurant UpdateProductRestaurant(FDP.ProductService.MessageDirectory.Request.UpdateProductRestaurant request) {
        logger.debug("Sending RPC response message with id of update product restaurant...");

        ProductRestaurant productToUpdate = productRestaurantDAO.getProductRestaurant(request.getId());
        Product product = productDAO.getId(request.getProductId());
        Restaurant restaurant = restaurantDAO.getRestaurantById(request.getRestaurantId());
        productToUpdate.setProduct(product);
        productToUpdate.setRestaurant(restaurant);
        productToUpdate.setName(request.getName());
        productToUpdate.setPrice(request.getPrice());
        productToUpdate.setQuantity(request.getQuantity());
        productRestaurantDAO.updateProductRestaurant(productToUpdate);
        UpdateProductRestaurant response = new UpdateProductRestaurant();
        response.setId(request.getId());
        return response;
    }

    //Delete Product Restaurant
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.DeleteProductRestaurant")
    private DeleteProductRestaurant DeleteProductRestaurant(FDP.ProductService.MessageDirectory.Request.DeleteProductRestaurant request) {
        logger.debug("Sending RPC response message with id of created order...");
        productRestaurantDAO.deleteProductRestaurant(request.getId());
        //Delete Product Restaurant from
        DeleteProductRestaurant response = new DeleteProductRestaurant();
        response.setId(request.getId());
        return response;
    }

    public ProductRestaurantInfo ConvertFromProduct(ProductRestaurant product)
    {
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