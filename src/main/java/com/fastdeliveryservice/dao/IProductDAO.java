package com.fastdeliveryservice.dao;

import com.fastdeliveryservice.model.Product;
import java.util.List;

/**
 * Created by Martina on 08/08/2017.
 */

public interface IProductDAO {

    List<Product> getAllProducts();

    Product getProductById(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    boolean ProductExists(String code);
}