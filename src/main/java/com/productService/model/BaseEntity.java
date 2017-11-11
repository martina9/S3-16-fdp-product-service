package com.productService.model;

import javax.persistence.*;

/**
 * @author  mGabellini
 */

@MappedSuperclass
public class BaseEntity {

    private int Id;
    private String name;
    private String code;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name="name",length = 255,unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="code",length = 255,unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
