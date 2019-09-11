package com.example.friends.controller;

import com.example.friends.model.Friend;
import com.example.friends.model.Message;
import com.example.friends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Collection;
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
    Collection<Friend> getFriends() throws ValidationException{
        Collection<Friend> friends = friendService.findAll();
        if(friends != null)
            return friends;
        else{
            throw new ValidationException("Error: No record found");
        }
    }


    @PostMapping("/friends/add")
    Friend create(@RequestBody Friend friend) throws ValidationException{
        //added validation before creating data.
        if(friend.getId() == 0 && friend.getFirstName()  != null && friend.getLastName() != null){
            return friendService.save(friend);
        }else{
            throw new ValidationException("Create Error: Friend cannot be create, Please validate the data");
        }
    }


    @PutMapping("/friends/update")
    Friend update(@RequestBody Friend friend) throws ValidationException{
        if(friendService.findById(friend.getId()).isPresent()){
            return friendService.saveAndFlush(friend);
        }else{
            throw new ValidationException("Update Error: Friend cannot be found with the id: "+friend.getId());
        }

    }

    @DeleteMapping("/friends/delete/{id}")
    void deleteFriend(@PathVariable Integer id) throws ValidationException{
        if(friendService.findById(id).isPresent()){
            friendService.deleteById(id);;
        }else{
            throw new ValidationException("Delete Error: Friend cannot be found with the id: "+id);
        }
    }

    @GetMapping("/friends/search/{id}")
    ResponseEntity<Optional<Friend>> getFriendById(@PathVariable Integer id) throws ValidationException{
        //added Exception handling mechanism if user not found
        Optional<Friend> optionalFriend =  friendService.findById(id);
        if(optionalFriend.isPresent())
            return new ResponseEntity(optionalFriend, HttpStatus.OK);
        else{
            throw new ValidationException("Search Error: Friend cannot be found with the id: "+id);
        }
    }

    @GetMapping("/friends/searchByName")
    Collection<Friend> searchByQuery(@RequestParam(value = "firstName", required = false) String firstName,
                                     @RequestParam(value = "lastName", required = false) String lastName)
                                   throws ValidationException{
        if(firstName != null && lastName != null) {
            Collection<Friend> friends = friendService.findByFirstNameAndLastName(firstName, lastName);
            if(friends != null && friends.size() >0)
                return friends;
            else
                throw new ValidationException("Search Error: Friend cannot be found with FirstName/LastName: "+firstName +"/"+lastName);
        }
        else if(firstName != null ){
            Collection<Friend> friends = friendService.findByFirstName(firstName);
            if(friends != null && friends.size() >0)
                return friends;
            else
                throw new ValidationException("Search Error: Friend cannot be found with FirstName: "+firstName);
        }
        else if(lastName != null){
            Collection<Friend> friends = friendService.findByLastName(lastName);
            if(friends != null && friends.size() >0)
                return friends;
            else
                throw new ValidationException("Search Error: Friend cannot be found with LastName: "+lastName);
        }else {
            Collection<Friend> friends = friendService.findAll();
            if(friends != null)
                return friends;
            else{
                throw new ValidationException("Error: No record found");
            }
        }
    }
}
