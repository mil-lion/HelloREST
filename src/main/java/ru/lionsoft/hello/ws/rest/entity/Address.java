/*
 * File:    Address.java
 * Project: HelloREST
 * Date:    28 июн. 2020 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2020 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.hello.ws.rest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author Igor Morenko morenko@lionsoft.ru
 */
@Embeddable
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Size(max = 30)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    
    @Size(max = 30)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    
    @Size(max = 25)
    @Column(name = "CITY")
    private String city;
    
    @Size(max = 2)
    @Column(name = "STATE")
    private String state;
    
    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" 
                + "addressline1=" + addressline1 
                + ", addressline2=" + addressline2 
                + ", city=" + city 
                + ", state=" + state 
                + '}';
    }

}
