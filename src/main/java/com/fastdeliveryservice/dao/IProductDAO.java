package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface IProductDAO {

    /**
     * Returns an List<Product> implementation this interface.
     *
     * @return List<Order>
     * @see    Product
     */

    List<Product> getAllProducts();

    /**
     * Returns an Product implementation this interface.
     *
     * @param productId
     * @return Product
     * @see    Product
     */

    Product getId(int productId);

    /**
     * Returns an added Product implementation this interface.
     *
     * @param product
     */

    void addProduct(Product product);

    /**
     * Returns an updated Product implementation this interface.
     *
     * @param product
     */

    void updateProduct(Product product);

    /**
     * Returns an deleted Product implementation this interface.
     *
     * @param productId
     */

    void deleteProduct(int productId);

    /**
     * Returns an boolean to check if product exists implementation this interface.
     *
     * @param code product
     * @return boolean check if product existed
     */

    boolean ProductExists(String code);

    /**
     * Returns an List<ProductRestaurant> by id implementation this interface.
     *
     * @param ids List id productRestaurants
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductRestaurantList(List<Integer> ids);

    /**
     * Returns an ProductRestaurant by id implementation this interface.
     *
     * @param ids id productRestaurants
     * @return List<ProductRestaurant>
     */

    ProductRestaurant  getProductRestaurant(int ids);
}