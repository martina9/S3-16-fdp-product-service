package com.productService.dao;

import com.productService.model.ProductRestaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface ProductRestaurantDAO {
    /**
     * Return an ProductRestaurant implementation this interface.
     *
     * @param productRestaurantId
     * @return ProductRestaurant
     * @see    ProductRestaurant
     */

    ProductRestaurant getProductRestaurantById(int productRestaurantId);

    /**
     * Return an addedProductRestaurant implementation this interface.
     *
     * @param productRestaurant
     */

    int addProductRestaurant(ProductRestaurant productRestaurant);

    /**
     * Return an updatedProductRestaurant implementation this interface.
     *
     * @param productRestaurant
     */

    void updateProductRestaurant(ProductRestaurant productRestaurant);

    /**
     * Return an deletedProductRestaurant implementation this interface.
     *
     * @param productRestaurantId
     */

    void deleteProductRestaurant(int productRestaurantId);

    /**
     * Return an boolean to check if product restaurant exists implementation this interface.
     *
     * @param productId
     * @param restaurantId
     * @return boolean check if productRestaurant existed
     */

    boolean ProductRestaurantExists(int productId, int restaurantId );

    /**
     * Return an List<ProductRestaurant> from id implementation this interface.
     *
     * @param ids
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductRestaurantListByIds(List<Integer> ids);

    /**
     * Return an List<ProductRestaurant> from id implementation this interface.
     *
     * @param idProductRestaurant
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductListByRestaurantId(int idProductRestaurant);

    /**
     * Return an List<ProductRestaurant> from id implementation this interface.
     *
     * @param restaurantCode
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductListByRestaurantCode(String restaurantCode);

    /**
     * Return an ProductRestaurant from id implementation this interface.
     *
     * @param ids
     * @return ProductRestaurant
     */

    ProductRestaurant  getProductRestaurant(int ids);
}