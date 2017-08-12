package com.fastdeliveryservice.modelTo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 09/08/2017.
 */
public class CategoryDto {

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

    public Collection<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductDto> products) {
        this.products = products;
    }

    public CategoryDto()
    {
        products=new ArrayList<>();
    }

    private Collection<ProductDto> products;
}
