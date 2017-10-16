package com.productService.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Martina
 */

@Entity
@Table(name="Users",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"taxCode","email"})
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @Column(name="email",length = 255,nullable = false)
    private String email;

    @Column(name="firstName",length = 255,nullable = false)
    private String firstName;

    @Column(name="lastName",length = 255, nullable = false)
    private String lastName;

    @Column(name="taxCode",length = 50,unique = true, nullable = false)
    private String taxCode;

    @OneToMany
    private Collection<Order> orders=new ArrayList<>();
}

