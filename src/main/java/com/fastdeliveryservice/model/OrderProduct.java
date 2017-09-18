package com.fastdeliveryservice.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Martina
 */

@Entity
@Table(name="OrderProducts")

public class OrderProduct extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProductRestaurant getProductRestaurant() {
        return productRestaurant;
    }

    public void setProductRestaurant(ProductRestaurant productRestaurant) {
        this.productRestaurant = productRestaurant;
    }

    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    private ProductRestaurant productRestaurant;
}

