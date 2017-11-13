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

    /**
     * Return an ProductRestaurantInfo by id
     *
     * @param productRestaurantInfo
     * @return ProductRestaurantInfo
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantInfo")
    public FDP.ProductService.MessageDirectory.Response.ProductRestaurantInfo productRestaurantById(FDP.ProductService.MessageDirectory.Request.ProductRestaurantInfo productRestaurantInfo) {
        ProductRestaurant productRestaurant =  productRestaurantDAOImpl.getProductRestaurant(productRestaurantInfo.getId());
        ProductRestaurantInfo productInfo = convertFromProduct(productRestaurant);
        return productInfo;
    }

    /**
     * Return an ProductRestaurantList
     *
     * @param request
     * @return List<ProductRestaurantInfo>
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductRestaurantList")
    public FDP.ProductService.MessageDirectory.Response.ProductRestaurantList productRestaurantList(FDP.ProductService.MessageDirectory.Request.ProductRestaurantList request) throws Exception {
        FDP.ProductService.MessageDirectory.Response.ProductRestaurantList productList = new FDP.ProductService.MessageDirectory.Response.ProductRestaurantList();

        List<ProductRestaurant> productRestaurants =  productRestaurantDAOImpl.getProductListByRestaurantId(request.getRestaurantId());

        List<ProductRestaurantInfo> productInfo  = convertList(productRestaurants, s -> new ProductRestaurantInfo(s.getId(),s.getPrice(),1,s.getName(),s.getProduct().getId(),s.getRestaurant().getId(),s.getRestaurant().getName(),s.getProduct().getName()));
        productList.setItems(productInfo);
        return productList;
    }

    /**
     * Return an id productRestaurant added
     *
     * @param request
     * @return AddProductRestaurant
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.AddProductRestaurant")
    public AddProductRestaurant addProductRestaurant(FDP.ProductService.MessageDirectory.Request.AddProductRestaurant request) throws Exception {
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

    /**
     * Return an id productRestaurant updated
     *
     * @param request
     * @return UpdateProductRestaurant
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.UpdateProductRestaurant")
    public UpdateProductRestaurant updateProductRestaurant(FDP.ProductService.MessageDirectory.Request.UpdateProductRestaurant request) {
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

    /**
     * Return an id productRestaurant deleted
     *
     * @param request
     * @return DeleteProductRestaurant
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.DeleteProductRestaurant")
    public DeleteProductRestaurant deleteProductRestaurant(FDP.ProductService.MessageDirectory.Request.DeleteProductRestaurant request) {
        productRestaurantDAOImpl.deleteProductRestaurant(request.getId());

        DeleteProductRestaurant response = new DeleteProductRestaurant();
        response.setId(request.getId());
        return response;
    }

    /**
     * Return an ProductRestaurantInfo from ProductRestaurant
     *
     * @param product
     * @return ProductRestaurantInfo
     */

    public ProductRestaurantInfo convertFromProduct(ProductRestaurant product) {
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