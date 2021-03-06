package com.example.friends.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private int id;

    @JsonProperty("first-name")
    @Column(name="firstName")
    @NotBlank
    private String firstName;

    @JsonProperty("last-name")
    @Column(name="lastName")
    @NotBlank
    private String lastName;

    private int age;

    @JsonIgnore
    private boolean married;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="friendAddress", joinColumns = @JoinColumn(name="friendId"),
            inverseJoinColumns = @JoinColumn(name="addressId"))
    List<Address> addresses;

    public Friend(int id, String firstName, String lastName, int age, List<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", addresses=" + addresses.toString() +
                '}';
    }
}
