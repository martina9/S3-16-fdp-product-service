package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Product;
import com.fastdeliveryservice.model.ProductRestaurant;

import java.util.List;

/**
 * Created by Martina Gabellini
 */

public interface IProductRestaurantDAO {

    ProductRestaurant getProductRestaurantById(int productRestaurantId);

    void addProductRestaurant(ProductRestaurant productRestaurant);

    void updateProductRestaurant(ProductRestaurant productRestaurant);

    void deleteProductRestaurant(int productRestaurantId);

    boolean ProductRestaurantExists(int productId, int restaurantId );

    List<ProductRestaurant> getProductRestaurantListByIds(List<Integer> ids);

    List<ProductRestaurant> getProductListByRestaurantId(int idProductRestaurant);

    ProductRestaurant  getProductRestaurant(int ids);

}