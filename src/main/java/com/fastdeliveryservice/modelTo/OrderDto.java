package com.fastdeliveryservice.modelTo;

import com.fastdeliveryservice.model.User;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 08/08/2017.
 */

public class OrderDto implements Serializable {

    public OrderDto()
    {
        productRestourants = new ArrayList<>();
    }

    private int Id;

    private UserDto user;

    private Collection<ProductRestourantDto> productRestourants;

    private double vatPrice ;

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


}

