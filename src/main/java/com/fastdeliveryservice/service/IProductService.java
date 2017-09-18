package com.fastdeliveryservice.service;

/**
 * Created by Martina
 */

import com.fastdeliveryservice.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProductsByRestaurant(int idRestaurant);
    Product getProductById(int productId);
    boolean addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
}