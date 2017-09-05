package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

@Entity
@Table(name="Ingredients")
public class Ingredient extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Category category;

    @OneToMany
    private Collection<ProductRestaurant> productRestaurants =new ArrayList<>();

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

}

