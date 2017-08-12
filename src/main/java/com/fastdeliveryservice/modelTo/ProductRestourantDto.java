package com.fastdeliveryservice.modelTo;


/**
 * Created by Martina on 08/08/2017.
 */

public class ProductRestourantDto {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public RestaurantDto getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDto restaurant) {
        this.restaurant = restaurant;
    }

    private ProductDto product;

    private RestaurantDto restaurant;

}

