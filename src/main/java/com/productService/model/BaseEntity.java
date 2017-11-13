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

    /**
     * Return an int from getId.
     *
     */

    @Column(name = "Id")
    public int getId() {
        return Id;
    }

    /**
     * Return an void from setId.
     *
     * @param id
     */

    public void setId(int id) {
        Id = id;
    }

    /**
     * Return an String from getName.
     *
     */

    @Column(name="name",length = 255,unique = false, nullable = false)
    public String getName() {
        return name;
    }

    /**
     * Return an void from setName.
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return an String from getCode.
     *
     */

    @Column(name="code",length = 255,unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    /**
     * Return an void from setCode.
     *
     * @param code
     */

    public void setCode(String code) {
        this.code = code;
    }
}