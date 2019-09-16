package com.example.friends;


import com.example.friends.controller.FriendController;
import com.example.friends.model.Address;
import com.example.friends.model.Friend;
import com.example.friends.service.FriendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.web.servlet.MockMvc;


import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
//Allows us to call urls in the test context will not make actual call
@WebMvcTest(FriendController.class)
public class FriendControllerMockTest {

    //we are mocking friendservice here, this means a dummy service to perform operations.
    @MockBean
    FriendService friendService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateReadDelete(){


        List<Address> addressList = Arrays.asList(new Address(0,"Adam5 Street", "Adam5 City"));
        List<Friend> friendList = Arrays.asList(new Friend(0,"Adam5","Gilchrist",40,addressList));

        //method to get the response of the service call, and this response will be used to compare with the actual method call
        Mockito.when(friendService.findAll()).thenReturn(friendList);
        //mockMvc with make a get call by mocking friends service from below code
        try {
            mockMvc.perform(get("/friends"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].first-name", is("Adam5")));
            verify(friendService, Mockito.times(1)).findAll();
            verifyNoMoreInteractions(friendService);
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }







}
