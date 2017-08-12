package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 08/08/2017.
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
        private Collection<ProductRestourant> productRestourants=new ArrayList<>();
    }

