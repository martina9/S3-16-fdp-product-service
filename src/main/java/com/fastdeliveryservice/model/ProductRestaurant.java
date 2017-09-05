package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina Gabellini
 */

@Entity
@Table(name="ProductRestaurants")

public class ProductRestaurant extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @ManyToOne
    private Product product;

    @ManyToOne
    private Restaurant restaurant;

}

