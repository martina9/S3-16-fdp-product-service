package com.fastdeliveryservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Martina
 */
@Entity
@Table(name="Categories")

public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

}
