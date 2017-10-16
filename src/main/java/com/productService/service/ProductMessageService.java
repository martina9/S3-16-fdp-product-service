package com.productService.service;

import FDP.ProductService.MessageDirectory.Response.*;
import FDP.ProductService.Shared.CategoryInfo;
import com.productService.dao.IProductDAO;
import com.productService.model.Category;
import com.productService.model.Product;
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
public class ProductMessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private DirectExchange directExchange;

    @Autowired
    private IProductDAO productDAO;

    @Autowired
    public ProductMessageService(Environment environment,DirectExchange directExchange) {

        this.environment = environment;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }
    //Get CategoryList by code
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductList")
    private ProductList Products(FDP.ProductService.MessageDirectory.Request.ProductList requestProductList) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");
        ProductList productList = new ProductList();

        List<Product> products =  productDAO.getAllProducts();
        List<ProductInfo> productInfo  = convertList(products, s -> new ProductInfo(s.getId(),s.getName(),s.getCode(),s.getCategory().getId(),s.getCategory().getName()));

        productList.setItems(productInfo);
        return productList;
    }

    //Get Restaurant by code
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.CategoryList")
    private CategoryList Categories(FDP.ProductService.MessageDirectory.Request.CategoryList requestCategoryList) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");
        CategoryList categoryList = new CategoryList();

        List<Category> categories =  productDAO.getAllCategories();
        List<CategoryInfo> categoryInfoList  = convertList(categories, s -> new CategoryInfo(s.getId(),s.getName()));

        categoryList.setItems(categoryInfoList);
        return categoryList;
    }

    //Get Product By Id
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.Product")
    private ProductInfo Product(FDP.ProductService.MessageDirectory.Request.ProductInfo info) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        Product product =  productDAO.getId(info.getId());
        ProductInfo productInfo = ConvertFromProduct(product);
        return productInfo;
    }

    //Get Restaurant by code
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.AddProduct")
    private AddProduct addProduct(FDP.ProductService.MessageDirectory.Request.AddProduct addProduct) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        Product productToSave = new Product();
        Category category = productDAO.getCategoryById(addProduct.getCategoryId());
        productToSave.setCategory(category);
        productToSave.setName(addProduct.getName());
        productToSave.setCode(addProduct.getCode());
        int id = productDAO.addProduct(productToSave);

        AddProduct response = new AddProduct();
        response.setId(id);
        return response;
    }

    //Get Restaurant by code
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.DeleteProduct")
    private DeleteProduct Product(FDP.ProductService.MessageDirectory.Request.DeleteProduct deleteProduct) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        productDAO.deleteProduct(deleteProduct.getId());

        DeleteProduct response = new DeleteProduct();
        response.setId(deleteProduct.getId());
        return response;
    }

    //Get Restaurant by code
    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.UpdateProduct")
    private UpdateProduct Product(FDP.ProductService.MessageDirectory.Request.UpdateProduct updateProduct) throws Exception {
        logger.debug("Sending RPC response message with id of created order.Int.");

        Product productToUpdate = productDAO.getId(updateProduct.getId());
        Category category = productDAO.getCategoryById(updateProduct.getCategoryId());

        productToUpdate.setCategory(category);
        productToUpdate.setName(updateProduct.getName());
        productToUpdate.setCode(updateProduct.getCode());
        productDAO.updateProduct(productToUpdate);

        UpdateProduct response = new UpdateProduct();
        response.setId(productToUpdate.getId());
        return response;
    }
    public ProductInfo ConvertFromProduct(Product product)
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryId(product.getCategory().getId());
        productInfo.setCode(product.getCode());
        productInfo.setId(product.getId());
        productInfo.setName(product.getName());
        return productInfo;

    }

}