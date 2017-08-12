package com.fastdeliveryservice.modelTo;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 11/08/2017.
 */
public class ProductDto
{
    public ProductDto()
    {
        productRestourants=new ArrayList<>();
    }


        private CategoryDto category;
        private Collection<ProductRestourantDto> productRestourants;
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

        public CategoryDto getCategory() {
            return category;
        }
        public void setCategory(CategoryDto category) {
            this.category = category;
        }


}
