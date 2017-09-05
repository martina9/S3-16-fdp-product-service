package com.fastdeliveryservice.domain;

import com.fastdeliveryservice.model.User;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

public class OrderDto implements Serializable {

    public Collection<ProductRestaurantDto> getProductRestaurants() {
        return productRestaurants;
    }

    public void setProductRestaurants(Collection<ProductRestaurantDto> productRestaurants) {
        this.productRestaurants = productRestaurants;
    }

    public OrderDto()
    {
        productRestaurants = new ArrayList<>();
        user = new UserDto();
    }

    private int Id;

    private UserDto user;

    private Collection<ProductRestaurantDto> productRestaurants;

    private double vatPrice ;

    private String deliveryType;

    private double netPrice;

    private Date ConfirmationDate ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getVatPrice() {
        return vatPrice;
    }

    public void setVatPrice(double vatPrice) {
        this.vatPrice = vatPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public Date getConfirmationDate() {
        return ConfirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        ConfirmationDate = confirmationDate;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(User userTo) {
        this.user = user;
    }

    public void setDeliveryType(String deliveryType) { this.deliveryType = deliveryType; }

    public String getDeliveryType() {return deliveryType;}
}

