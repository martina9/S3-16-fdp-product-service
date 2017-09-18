package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina Gabellini
 */

@Entity
@Table(name="Product_Restaurant")
public class ProductRestaurant extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_RESTAURANT_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Restaurant restaurant;
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANT_ID")
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

