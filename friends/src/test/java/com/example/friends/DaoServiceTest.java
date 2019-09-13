package com.example.friends;


import com.example.friends.model.Address;
import com.example.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * this is a test class for testing Data layer service (DAO)
 * @DataJdbcTest allows us to test only data layer
 * @AutoConfigureTestDatabase it will allow us to configure existing database, it is not needed if you are using inbuilt database
 */

@DataJdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DaoServiceTest {

    @Test
    public void createReadDeleteDBService(){
        RestTemplate restTemplate = new RestTemplate();

        List<Address> addressList = Arrays.asList(new Address(0,"Adam5 Street", "Adam5 City"));
        Friend friend = new Friend(0,"Adam5","Gilchrist",40,addressList);

        String url = "http://localhost:8082/friends";

        ResponseEntity<Friend> entity = restTemplate.postForEntity(url+"/add", friend, Friend.class);

        Friend[] friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).contains("Adam5");

        restTemplate.delete(url+"/delete/"+entity.getBody().getId());
        friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).doesNotContain("Adam5");

    }
}
