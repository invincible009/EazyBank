package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities extends BaseEntity{

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "name")
    private String name;

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
