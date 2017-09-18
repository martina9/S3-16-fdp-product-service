package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Martina
 */

@Entity
@Table(name="Ingredients")
public class Ingredient extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Category category;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

