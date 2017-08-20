package com.fastdeliveryservice.modelDto;

import com.fastdeliveryservice.model.BaseEntity;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Martina on 08/08/2017.
 */

public class OrderProductDto extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private double quantity;

    public double getQuantity() {
        return quantity;
    }

    public ProductRestourantDto getProductRestourant() {
        return productRestourant;
    }

    public void setProductRestourant(ProductRestourantDto productRestourant) {
        this.productRestourant = productRestourant;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private ProductRestourantDto productRestourant;
}

