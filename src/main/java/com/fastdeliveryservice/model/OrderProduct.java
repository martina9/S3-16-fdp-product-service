package com.fastdeliveryservice.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Martina on 08/08/2017.
 */

@Entity
@Table(name="OrderProducts")

public class OrderProduct extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProductRestourant getProductRestourant() {
        return productRestourant;
    }

    public void setProductRestourant(ProductRestourant productRestourant) {
        this.productRestourant = productRestourant;
    }

    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private ProductRestourant productRestourant;
}

