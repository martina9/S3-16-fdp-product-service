package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina Gabellini
 */

@Entity
@Table(name="Product_Restaurant",indexes = { @Index(name = "IDX_Product_Restaurant", columnList = "RESTAURANT_ID,PRODUCT_ID",unique = true)} )
public class ProductRestaurant  implements Serializable {
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

    private String name;

    @Column(length = 255,unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Restaurant restaurant;
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "RESTAURANT_ID",nullable = false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID",nullable = false)

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

