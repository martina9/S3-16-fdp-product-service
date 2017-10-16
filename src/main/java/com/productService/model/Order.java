package com.productService.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martina
 */

@Entity
@Table(name="Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    public Order()
    {

    }


    private int Id;


    private User user;
    private Set<OrderProduct> orderProducts = new HashSet<>();
    private double netPrice;
    private Date ConfirmationDate ;
    private String deliveryType;

    @OneToMany
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}

