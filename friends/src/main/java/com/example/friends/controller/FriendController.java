package com.example.friends.controller;

import com.example.friends.model.Friend;
import com.example.friends.model.Message;
import com.example.friends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping("/message")
    Message getMessage(){
        return new Message("Hi! Welcome to Friends App");
    }

    @GetMapping("/friends")
    Iterable<Friend> getFriends(){
        return friendService.findAll();
    }

    @PostMapping("/friends/add")
    Friend create(@RequestBody Friend friend){
        Friend friend1 =  friendService.save(friend);
        System.out.println(friend1.toString());
        return friend1;
    }

    @PutMapping("/friends/update")
    Friend update(@RequestBody Friend friend){
        return friendService.saveAndFlush(friend);
    }

    @DeleteMapping("/friends/delete/{id}")
    void deleteFriend(@PathVariable Integer id){
        friendService.deleteById(id);
    }

    @GetMapping("/friends/search/{id}")
    ResponseEntity<Optional<Friend>> getFriendById(@PathVariable Integer id){
        //added Exception handling mechanism if user not found
        Optional<Friend> optionalFriend =  friendService.findById(id);
        if(optionalFriend.isPresent())
            return new ResponseEntity(optionalFriend, HttpStatus.OK);
        else{
            return new ResponseEntity(optionalFriend.orElse(null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/friends/searchByName")
    Iterable<Friend> searchByQuery(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName){
        if(firstName != null && lastName != null)
            return friendService.findByFirstNameAndLastName(firstName,lastName);
        else if(firstName != null)
            return friendService.findByFirstName(firstName);
        else if(lastName != null)
            return friendService.findByLastName(lastName);
        else
            return friendService.findAll();
    }
}
