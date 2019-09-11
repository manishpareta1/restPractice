package com.example.friends.service;

import com.example.friends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FriendService extends JpaRepository<Friend, Integer> {

    public Collection<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    public Collection<Friend> findByFirstName(String firstName);
    public Collection<Friend> findByLastName(String lastName);
}
