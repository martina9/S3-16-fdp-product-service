package com.productService.dao;

import com.productService.model.Category;
import com.productService.model.Product;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface ProductDAO {

    /**
     * Return an List<Category> implementation this interface.
     *
     * @return List<Category>
     */

    List<Category> getAllCategories();

    /**
     * Return an Category implementation this interface.
     *
     * @param id
     * @return Category
     */

    Category getCategoryById(int id);

    /**
     * Return an List<Product> implementation this interface.
     *
     * @return List<Product>
     */

    List<Product> getAllProducts();

    /**
     * Return an Product implementation this interface.
     *
     * @param productId
     * @return Product
     */

    Product getId(int productId);

    /**
     * Return an added Product implementation this interface.
     *
     * @param product
     */

    int addProduct(Product product);

    /**
     * Return an updated Product implementation this interface.
     *
     * @param product
     */

    void updateProduct(Product product);

    /**
     * Return an deleted Product implementation this interface.
     *
     * @param productId
     */

    void deleteProduct(int productId);

    /**
     * Return an boolean to check if product exists implementation this interface.
     *
     * @param code product
     * @return boolean check if product existed
     */

    boolean ProductExists(String code);
}