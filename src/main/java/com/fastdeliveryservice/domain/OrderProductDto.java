package com.fastdeliveryservice.domain;

import com.fastdeliveryservice.model.BaseEntity;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Martina
 */

public class OrderProductDto extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public ProductRestaurantDto getProductRestourant() {
        return productRestourant;
    }

    public void setProductRestourant(ProductRestaurantDto productRestourant) {
        this.productRestourant = productRestourant;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private ProductRestaurantDto productRestourant;
}

