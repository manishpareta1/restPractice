package com.example.friends.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="frndsAddrsTbl")
public class Address {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    @JsonProperty("add-id")
    private int id;
    private String street;
    private String city;

    public Address(int id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" +id + '\'' +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address() {
    }
}
