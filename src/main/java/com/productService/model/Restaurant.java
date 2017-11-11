package com.productService.model;

import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author  mGabellini
 */

@Entity
@Table(name = "Restaurants")

public class Restaurant extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<ProductRestaurant> productRestaurants = new HashSet<>();
    private Set<AddressRestaurant> addressRestaurants = new HashSet<>();

    public Restaurant() {
    }

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    public Set<ProductRestaurant> getProductRestaurants() {

        return productRestaurants;
    }

    public void setProductRestaurants(Set<ProductRestaurant> productRestaurants) {
        this.productRestaurants = productRestaurants;
    }

    public void addProductRestaurant(ProductRestaurant productRestaurant) {
        this.productRestaurants.add(productRestaurant);
    }

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @JsonManagedReference
    public Set<AddressRestaurant> getAddressRestaurants() {
        return addressRestaurants;
    }

    public void setAddressRestaurants(Set<AddressRestaurant> addressRestaurants) {
        this.addressRestaurants = addressRestaurants;
    }

    public void addAddressRestaurant(AddressRestaurant addressRestaurant) {
        this.addressRestaurants.add(addressRestaurant);
    }


}

