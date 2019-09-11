package com.rest.consumer.demo.controller;

import com.rest.consumer.demo.model.Friend;
import com.rest.consumer.demo.model.Message;
import com.rest.consumer.demo.util.ConfigUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
public class RestConsumerForFriends {

    @Autowired
    ConfigUtil util;

    Friend dummyFriend = new Friend(0,"xxx","yyy",false,0,null );

    @GetMapping("/welcome/friend")
    Message getMessage(){
        Message message = util.rest().getForObject(util.getProperty("fendpoint")+util.getProperty("fmessage"), Message.class);
        return message;
        // http://localhost:8082/message
    }
    @GetMapping("/welcome/friends")
    Friend[] getFriends(){
        Friend[] friend = util.rest().getForObject(util.getProperty("fendpoint")+util.getProperty("getfriends"), Friend[].class);
        return friend;
    }

    @PostMapping("/welcome/addFriend")
    Friend addFriend(@RequestBody Friend friend){
       // Friend friend = new Friend("J K", "Rowling");
         return util.rest().postForObject(util.getProperty("fendpoint")+util.getProperty("addfriend"), friend,Friend.class);
    }

    @PutMapping("/welcome/updateFriend")
    Friend updateFriend(@RequestBody Friend friend){
        util.rest().put(util.getProperty("fendpoint")+util.getProperty("updatefriend"),friend, Friend.class);
        return friend;
    }

    @DeleteMapping("/welcome/deleteFriend/{id}")
    void deleteFriend(@PathVariable Integer id){
        util.rest().delete(util.getProperty("fendpoint")+util.getProperty("deletefriend")+util.getProperty("uriSeperator")+id);
    }

    /**
     *
     * @param id
     * @return ResponseEntity of Friend or throws exception
     * Added changes as part of exception handling.
     */
    @GetMapping("/welcome/searchFriend/{id}")
    ResponseEntity<Friend> searchFriendById(@PathVariable Integer id){
        ResponseEntity<Friend> friendEntity = util
                .rest()
                .getForEntity(util.getProperty("fendpoint") + util.getProperty("searchFriend")+util.getProperty("uriSeperator")+id,
                Friend.class);
        if(friendEntity.getStatusCode() == HttpStatus.OK)
            return friendEntity;
        else
            return new ResponseEntity(dummyFriend, HttpStatus.BAD_REQUEST);
    }


    /**
     * Method to catch exception and return the defined response
     * Added as part of Exception handling changes.
     */
    @ExceptionHandler(HttpStatusCodeException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Friend not found")
    public void notFound() { }

    @GetMapping("/welcome/searchByName")
    Friend[] searchFriendByName(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName){
        if(firstName != null && lastName != null)
            return util.rest().getForObject(util.getProperty("fendpoint") + util.getProperty("searchByName")+"?firstName="+firstName+"&lastName="+lastName,
                Friend[].class);
        else if(firstName != null)
            return util.rest().getForObject(util.getProperty("fendpoint") + util.getProperty("searchByName")+"?firstName="+firstName,
                    Friend[].class);
        else if(lastName != null)
            return util.rest().getForObject(util.getProperty("fendpoint") + util.getProperty("searchByName")+"?lastName="+lastName,
                    Friend[].class);
        else
            return util.rest().getForObject(util.getProperty("fendpoint") + util.getProperty("getfriends"),
                    Friend[].class);
    }


}
