package com.fastdeliveryservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina Gabellini
 */

public class ProductDto implements Serializable
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    private int Id;
    private String name;
    private Double price;
    private String ingredients;

    private CategoryDto category;
    private String code ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
    Id = id;
    }
    public String getCode() {
    return code;
}
    public void setCode(String code) {
    this.code = code;
}

    public CategoryDto getCategory() {
        return category;
    }
    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}