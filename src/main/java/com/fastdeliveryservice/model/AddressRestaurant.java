package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina
 */

@Entity
@Table(name="AddressRestaurants")
public class AddressRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "street", length = 255)
    private String street;

    @Column(name = "zipcode", length = 255)
    private String zipCode;



    @Column(name = "city", length = 255)
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

