package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina on 08/08/2017.
 */

@Entity
@Table(name="AddressRestaurants")
public class AddressRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "street", length = 255)
    private String street;

    @Column(name = "zipcode", length = 255)
    private String zipCode;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

