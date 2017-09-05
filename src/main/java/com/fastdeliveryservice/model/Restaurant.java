package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina Gabellini
 */

@Entity
@Table(name="Restaurants")

public class Restaurant extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private AddressRestaurant addressRestaurant;

    @OneToMany
    private Collection<ProductRestaurant> productRestaurants =new ArrayList<>();

    public AddressRestaurant getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(AddressRestaurant addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }
}

