package com.productService.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author  mGabellini
 */

    @Entity
    @Table(name="Products")
    public class Product extends BaseEntity implements Serializable {
        private static final long serialVersionUID = 1L;

        private Category category;

        private Set<ProductRestaurant> productRestaurants = new HashSet<>();

        private Set<Ingredient> ingredients;

        public Product(){}


        @JsonIgnore
        @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
        public Set<ProductRestaurant> getProductRestaurants() {
            return productRestaurants;
        }

        public void setProductRestaurants(Set<ProductRestaurant> productRestaurants) {
            this.productRestaurants = productRestaurants;
        }

        public void addProductRestaurant(ProductRestaurant productRestaurant) {
            this.productRestaurants.add(productRestaurant);
        }

        @ManyToOne
        @JoinColumn(name = "category_id")
        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }



        @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
        @JoinTable(name="product_ingredient", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="ingredient_id"))
        public Set<Ingredient> getIngredients() {
            return ingredients;
        }
        public void setIngredients(Set<Ingredient> ingredients)
        {
            this.ingredients = ingredients;
        }
}

