package com.fastdeliveryservice.model;

import javax.persistence.*;

/**
 * Created by Martina on 09/08/2017.
 */
@MappedSuperclass
public class BaseEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @Column(name="name",length = 255,unique = true, nullable = false)
    private String name;

    @Column(name="code",length = 255,unique = true, nullable = false)
    private String code;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
