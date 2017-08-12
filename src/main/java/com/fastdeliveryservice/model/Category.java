package com.fastdeliveryservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina on 09/08/2017.
 */
@Entity
@Table(name="Categories")

public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany
    private Collection<Product> products=new ArrayList<>();
}
