package com.fastdeliveryservice.domain;

import com.fastdeliveryservice.model.Order;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

public class UserDto {

    public UserDto() {
        orders=new ArrayList<>();
    }

    private int Id;

    private String firstName;
    private String lastName;
    private String taxCode;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    private Collection<Order> orders;
}

