package com.fastdeliveryservice.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina Gabellini
 */

public class RestaurantDto {

    public RestaurantDto() {
        productRestourants = new ArrayList<>();
    }

    private AddressRestaurantDto addressRestaurant;

    private Collection<ProductRestaurantDto> productRestourants;

    public String getCode() {
        return code;
    }

    public int getId() {
        return Id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    private String code ;

    private int Id;

    private String name;

    public AddressRestaurantDto getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(AddressRestaurantDto addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }
}

