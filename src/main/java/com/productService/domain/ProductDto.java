package com.productService.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {
    private int id;

    private String name;

//    @JsonIgnore
//    private String ingredients;

    private String code ;

    private CategoryDto category;

    /**
     * Returns an void from setId.
     *
     * @param  id

     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns an void from getId.
     *
     */

    public int getId() {
        return id;
    }


    /**
     * Returns an void from setName.
     *
     * @param  name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns an void from getName.
     *
     */

    public String getName() {
        return name;
    }


    /**
     * Returns an void from setCode.
     *
     * @param  code
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns an string from getCode.
     *
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns an void from setCategory.
     *
     * @param  category
     */

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    /**
     * Returns an CategoryDto from getCategory.
     *
     * @return CategoryDto
     * @see CategoryDto
     */

    public CategoryDto getCategory() {
        return category;
    }
}