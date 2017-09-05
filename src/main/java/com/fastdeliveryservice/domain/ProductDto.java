package com.fastdeliveryservice.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina Gabellini
 */

public class ProductDto
{
    public ProductDto() {
        productRestourants = new ArrayList<>();
    }

    private CategoryDto category;
    private Collection<ProductRestaurantDto> productRestourants;
    private String code ;
    private int Id;


    public Collection<ProductRestaurantDto> getProductRestourants() {
        return productRestourants;
    }

    public void setProductRestourants(Collection<ProductRestaurantDto> productRestourants) {
        this.productRestourants = productRestourants;
    }

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