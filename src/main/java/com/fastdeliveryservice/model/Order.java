package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

@Entity
@Table(name="Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @ManyToOne
    private User user;

    @OneToMany
    private Collection<ProductRestaurant> productRestaurants = new ArrayList<>();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

