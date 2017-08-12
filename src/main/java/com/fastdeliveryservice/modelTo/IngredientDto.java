package com.fastdeliveryservice.modelTo;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 08/08/2017.
 */

public class IngredientDto {

    public IngredientDto()
    {
        productRestourants=new ArrayList<>();
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(String id) {
        Id = id;
    }

    private String code ;

    private String Id;


    private CategoryDto category;

    @OneToMany
    private Collection<ProductRestourantDto> productRestourants;


    public CategoryDto getCategory() {
        return category;
    }
    public void setCategory(CategoryDto category) {
        this.category = category;
    }

}

