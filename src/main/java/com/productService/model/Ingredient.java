package com.productService.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Martina
 */

@Entity
@Table(name="Ingredients")
public class Ingredient extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

}

