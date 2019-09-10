package com.rest.consumer.demo.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import javax.xml.bind.DatatypeConverter;

public class Util
{/*

    public void findUserById()
    {
        String username = "chathuranga";
        String password = "123";
        Integer userId = 1;

        String url = "http://localhost:8080/users/" + userId;

        //setting up the HTTP Basic Authentication header value
        String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());

        HttpHeaders requestHeaders = new HttpHeaders();
        //set up HTTP Basic Authentication Header
        requestHeaders.add("Authorization", authorizationHeader);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        //request entity is created with request headers
        HttpEntity<AddUserRequest> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<FindUserResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                FindUserResponse.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("response received");
            System.out.println(responseEntity.getBody());
        } else {
            System.out.println("error occurred");
            System.out.println(responseEntity.getStatusCode());
        }
    }*/
}
