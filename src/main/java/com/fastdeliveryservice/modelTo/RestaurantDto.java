package com.fastdeliveryservice.modelTo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 08/08/2017.
 */

public class RestaurantDto {
    private static final long serialVersionUID = 1L;

    public RestaurantDto() {
        productRestourants = new ArrayList<>();
    }

    private AddressRestaurantDto addressRestaurant;

    private Collection<ProductRestourantDto> productRestourants;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        Id = id;
    }

    private String code ;

    private String Id;
    public AddressRestaurantDto getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(AddressRestaurantDto addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }
}

