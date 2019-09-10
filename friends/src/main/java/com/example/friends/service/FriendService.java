package com.example.friends.service;

import com.example.friends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendService extends JpaRepository<Friend, Integer> {

    public Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
    public Iterable<Friend> findByFirstName(String firstName);
    public Iterable<Friend> findByLastName(String lastName);
}
