package com.rest.consumer.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Friend {

    private int id;
    @JsonProperty("first-name")
    private String firstName;
    @JsonProperty("last-name")
    private String lastName;
    private boolean married;
    private Integer age;
    private List<Address> addresses;

    public Friend( int id,String firstName, String lastName, boolean married, Integer age, List<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
        this.addresses = addresses;
    }

    public Friend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddress(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }

    public static Friend getDummyFriend(){
        return new Friend(0,"xxx","yyy",false,0,null );
    }
}
