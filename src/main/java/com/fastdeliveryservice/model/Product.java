package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martina
 */

    @Entity
    @Table(name="Products")
    public class Product extends BaseEntity implements Serializable {
        private static final long serialVersionUID = 1L;

        public Product(){}

        private Set<ProductRestaurant> productRestaurants = new HashSet<>();

        @OneToMany(mappedBy = "restaurant")
        public Set<ProductRestaurant> getProductRestaurants() {
            return productRestaurants;
        }

        public void setProductRestaurants(Set<ProductRestaurant> productRestaurants) {
            this.productRestaurants = productRestaurants;
        }

        public void addProductRestaurant(ProductRestaurant productRestaurant) {
            this.productRestaurants.add(productRestaurant);
        }

        private Category category;

        @ManyToOne
        @JoinColumn(name = "category_id")
        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        private Set<Ingredient> ingredients;

        @ManyToMany(cascade=CascadeType.ALL)
        @JoinTable(name="product_ingredient", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="ingredient_id"))
        public Set<Ingredient> getIngredients()
        {
            return ingredients;
        }
        public void setIngredients(Set<Ingredient> ingredients)
        {
            this.ingredients = ingredients;
        }
}

