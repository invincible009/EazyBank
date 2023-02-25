package com.sdl.eazybank.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinTable(name = "customer")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
