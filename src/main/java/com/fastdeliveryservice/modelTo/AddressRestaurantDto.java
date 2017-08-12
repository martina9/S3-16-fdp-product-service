package com.fastdeliveryservice.modelTo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina on 08/08/2017.
 */

public class AddressRestaurantDto  {


    private int Id;

    private String street;

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

