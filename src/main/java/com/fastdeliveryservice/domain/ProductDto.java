package com.fastdeliveryservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina Gabellini
 */

public class ProductDto implements Serializable
{
    private CategoryDto category;
    private String code ;
    private int Id;

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