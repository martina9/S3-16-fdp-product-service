package com.fastdeliveryservice.service;

/**
 * Created by Martina
 */

import com.fastdeliveryservice.domain.ProductRestaurantDto;
import com.fastdeliveryservice.model.ProductRestaurant;

import java.util.List;

public interface IProductRestaurantService {

    List<ProductRestaurant> getAllProductsByRestaurant(int idRestaurant);
    ProductRestaurantDto getProductRestaurantById(int id);
    boolean addProductRestaurant(ProductRestaurantDto productRestaurantDto);
    boolean updateProductRestaurant(ProductRestaurantDto productRestaurantDto);
    boolean deleteProductRestaurant(ProductRestaurantDto productRestaurantDto);
}