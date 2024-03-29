package com.productService.dao;

import com.productService.model.Category;
import com.productService.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author  mGabellini
 */

public interface ProductDAO {

    EntityManager getEntityManager();
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
     * Returns an List<Product> implementation this interface.
     *
     * @return List<Product>
     */

    List<Product> getAllProducts();

    /**
     * Returns an Product implementation this interface.
     *
     * @param productId
     * @return Product
     */

    Product getId(int productId);

    /**
     * Returns an added Product implementation this interface.
     *
     * @param product
     */

    int addProduct(Product product);

    /**
     * Returns an updated Product implementation this interface.
     *
     * @param product
     */

    int updateProduct(Product product);

    /**
     * Returns an deleted Product implementation this interface.
     *
     * @param productId
     */

    int deleteProduct(int productId);

    /**
     * Returns an boolean to check if product exists implementation this interface.
     *
     * @param code product
     * @return boolean check if product existed
     */

    boolean ProductExists(String code);
}