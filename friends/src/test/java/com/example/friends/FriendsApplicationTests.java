package com.example.friends;

import com.example.friends.controller.FriendController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @RunWith tells that is uses Spring Junti test api for test case
 * @SpringBootTest tells the spring boot application will start inside a test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendsApplicationTests {

	//Spring Context will instantiate a FriendControlle and inject it.
	@Autowired
	FriendController friendController;

	/**
	 * contextLoads will validate if the spring context
	 * is initialized and bean is instantiated and injected
	 * @Test tells its this method will run when the unit test is run
	 */
	@Test
	public void contextLoads() {
		Assert.assertNotNull(friendController);
	}

}
