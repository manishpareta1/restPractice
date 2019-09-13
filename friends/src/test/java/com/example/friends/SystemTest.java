package com.example.friends;

import com.example.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

    @Test
    public void createReadDelete(){
        RestTemplate restTemplate = new RestTemplate();

        Friend friend = new Friend(0,"Adam5","Gilchrist",40,null);
        String url = "http://localhost:8082/friends";

        ResponseEntity<Friend> entity = restTemplate.postForEntity(url+"/add", friend, Friend.class);

        Friend[] friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).contains("Adam5");

        restTemplate.delete(url+"/delete/"+entity.getBody().getId());
        friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).doesNotContain("Adam5");

    }

}
