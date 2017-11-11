package com.productService.dao;

import com.productService.model.ProductRestaurant;

import java.util.List;

/**
 * @author  mGabellini
 */

public interface ProductRestaurantDAO {

    /**
     * Returns an ProductRestaurant implementation this interface.
     *
     * @param productRestaurantId
     * @return ProductRestaurant
     * @see    ProductRestaurant
     */

    ProductRestaurant getProductRestaurantById(int productRestaurantId);

    /**
     * Returns an addedProductRestaurant implementation this interface.
     *
     * @param productRestaurant
     */

    int addProductRestaurant(ProductRestaurant productRestaurant);

    /**
     * Returns an updatedProductRestaurant implementation this interface.
     *
     * @param productRestaurant
     */

    void updateProductRestaurant(ProductRestaurant productRestaurant);

    /**
     * Returns an deletedProductRestaurant implementation this interface.
     *
     * @param productRestaurantId
     */

    void deleteProductRestaurant(int productRestaurantId);

    /**
     * Returns an boolean to check if product restaurant exists implementation this interface.
     *
     * @param productId
     * @param restaurantId
     * @return boolean check if productRestaurant existed
     */

    boolean ProductRestaurantExists(int productId, int restaurantId );

    /**
     * Returns an List<ProductRestaurant> from id implementation this interface.
     *
     * @param ids
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductRestaurantListByIds(List<Integer> ids);

    /**
     * Returns an List<ProductRestaurant> from id implementation this interface.
     *
     * @param idProductRestaurant
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductListByRestaurantId(int idProductRestaurant);

    /**
     * Returns an List<ProductRestaurant> from id implementation this interface.
     *
     * @param restaurantCode
     * @return List<ProductRestaurant>
     */

    List<ProductRestaurant> getProductListByRestaurantCode(String restaurantCode);

    /**
     * Returns an ProductRestaurant from id implementation this interface.
     *
     * @param ids
     * @return ProductRestaurant
     */

    ProductRestaurant  getProductRestaurant(int ids);
}