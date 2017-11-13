package com.productService.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author  mGabellini
 */

@Entity
@Table(name="Categories")

public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}
