package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;

import java.util.List;

/**
 * Created by Martina
 */

public interface IProductDAO {

    List<Product> getAllProducts();

    Product getId(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    boolean ProductExists(String code);

    List<ProductRestaurant> getProductRestaurantList(List<Integer> ids);

    ProductRestaurant  getProductRestaurant(int ids);

}