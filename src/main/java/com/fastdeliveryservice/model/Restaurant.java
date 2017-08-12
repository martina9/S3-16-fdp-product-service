package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 08/08/2017.
 */

@Entity
@Table(name="Restaurants")

public class Restaurant extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private AddressRestaurant addressRestaurant;

    @OneToMany
    private Collection<ProductRestourant> productRestourants=new ArrayList<>();

    public AddressRestaurant getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(AddressRestaurant addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }
}

