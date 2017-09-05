package com.fastdeliveryservice.domain;

import java.util.List;

/**
 * Created by Utente on 29/08/2017.
 */
public class OrderView {

    private List<Integer> products;
    private String deliveryType;

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
