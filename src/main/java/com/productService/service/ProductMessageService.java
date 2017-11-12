package com.productService.service;

import FDP.ProductService.MessageDirectory.Response.*;
import FDP.ProductService.Shared.CategoryInfo;
import com.productService.dao.ProductDAO;
import com.productService.model.Category;
import com.productService.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;

import java.util.List;

import static com.productService.utility.Mapper.convertList;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author  mGabellini
 */

@Component
public class ProductMessageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ProductDAO productDAO;

    /**
     * Constructor
     *
     * @param productDAO
     */

    @Autowired
    public ProductMessageService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Return an ProductList by id
     *
     * @param requestProductList
     * @return List<ProductInfo>
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductList")
    public ProductList Products(FDP.ProductService.MessageDirectory.Request.ProductList requestProductList) throws Exception {
        ProductList productList = new ProductList();
        List<Product> products =  productDAO.getAllProducts();
        List<ProductInfo> productInfo  = convertList(products, s -> new ProductInfo(s.getId(),s.getName(),s.getCode(),s.getCategory().getId(),s.getCategory().getName()));
        productList.setItems(productInfo);
        return productList;
    }

    /**
     * Return an CategoryList by id
     *
     * @param requestCategoryList
     * @return List<CategoryInfo>
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.CategoryList")
    public CategoryList Categories(FDP.ProductService.MessageDirectory.Request.CategoryList requestCategoryList) throws Exception {
        CategoryList categoryList = new CategoryList();
        List<Category> categories =  productDAO.getAllCategories();
        List<CategoryInfo> categoryInfoList  = convertList(categories, s -> new CategoryInfo(s.getId(),s.getName()));
        categoryList.setItems(categoryInfoList);
        return categoryList;
    }

    /**
     * Return an ProductInfo by id
     *
     * @param info
     * @return ProductInfo
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.ProductInfo")
    public ProductInfo ProductInfo(FDP.ProductService.MessageDirectory.Request.ProductInfo info) throws Exception {
        Product product =  productDAO.getId(info.getId());
        ProductInfo productInfo = ConvertFromProduct(product);
        return productInfo;
    }

    /**
     * Return an id product added
     *
     * @param addProduct
     * @return AddProduct
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.AddProduct")
    public AddProduct addProduct(FDP.ProductService.MessageDirectory.Request.AddProduct addProduct) throws Exception {
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

    /**
     * Return an id product deleted
     *
     * @param deleteProduct
     * @return DeleteProduct
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.DeleteProduct")
    public DeleteProduct Product(FDP.ProductService.MessageDirectory.Request.DeleteProduct deleteProduct) throws Exception {
        productDAO.deleteProduct(deleteProduct.getId());

        DeleteProduct response = new DeleteProduct();
        response.setId(deleteProduct.getId());
        return response;
    }

    /**
     * Return an id product updated
     *
     * @param updateProduct
     * @return UpdateProduct
     */

    @RabbitListener(queues = "FDP.ProductService.MessageDirectory:Request.UpdateProduct")
    public UpdateProduct Product(FDP.ProductService.MessageDirectory.Request.UpdateProduct updateProduct) throws Exception {
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

    /**
     * Return an ProductInfo from Product
     *
     * @param product
     * @return ProductInfo
     */

    public ProductInfo ConvertFromProduct(Product product) {
        ProductInfo productInfo = new ProductInfo(product.getId(), product.getName(), product.getCode(), product.getCategory().getId(), product.getCategory().getName());
        return productInfo;
    }
}