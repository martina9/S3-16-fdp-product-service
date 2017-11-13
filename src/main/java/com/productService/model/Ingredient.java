package com.productService.model;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author  mGabellini
 */

@Entity
@Table(name="Ingredients")
public class Ingredient extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}