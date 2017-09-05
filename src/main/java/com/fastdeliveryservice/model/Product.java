package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

import javax.persistence.Entity;
import javax.persistence.Table;
    @Entity
    @Table(name="Products")
    public class Product extends BaseEntity implements Serializable {
        private static final long serialVersionUID = 1L;

        @ManyToOne
        private Category category;

        public Category getCategory() {
            return category;
        }
        public void setCategory(Category category) {
            this.category = category;
        }

        @OneToMany
        private Collection<ProductRestaurant> productRestaurants =new ArrayList<>();
    }

