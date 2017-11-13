package com.productService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author  mGabellini
 */

@Entity
@Table(name = "AddressRestaurants")
public class AddressRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;

    private int Id;

    private String street;
    private String zipCode;
    private String city;
    private String phoneNumber;
    private String email;

    private Restaurant restaurant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Return an int from getId.
     *
     */

    public int getId() {
        return Id;
    }

    /**

     * Return an void from setId.
     *
     * @param id
     */

    public void setId(int id) {
        Id = id;
    }

    /**
     * Return an String from getStreet.
     *
     */

    @Column(length = 255)
    public String getStreet() {
        return street;
    }

    /**
     * Return an void from setStreet.
     *
     * @param street
     */

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(length = 255)
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Return an void from setZipCode.
     *
     * @param zipCode
     */

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Return an String from getCity.
     *
     */

    @Column(length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return an String from getPhoneNumber.
     *
     */

    @Column(name = "phone_number", length = 255)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Return an void from setPhoneNumber.
     *
     * @param phoneNumber
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Return an String from getEmail.
     *
     */

    public String getEmail() {
        return email;
    }

    /**
     * Return an void from setEmail.
     *
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return an Restaurant from getRestaurant.
     *
     */

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Return an void from setRestaurant.
     *
     * @param restaurant
     */

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}