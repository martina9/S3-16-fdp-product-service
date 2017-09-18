package com.fastdeliveryservice.service;

import com.fastdeliveryservice.dao.ProductDAO;
import com.fastdeliveryservice.domain.ProductDto;
import com.fastdeliveryservice.model.Product;
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
