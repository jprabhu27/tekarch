package com.restTests.simpleTests;

import com.restTests.POJOs.UserPOJO;
import com.restTests.helpers.UserServiceHelper;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class GetAllUsers {
	
	public static void getUserData(Logger logger) {
		
		logger.info("*************Reading User info****************");
		//Return list of users
		List<UserPOJO> listOfUsers = UserServiceHelper.getUserData();
		Assert.assertNotEquals(listOfUsers.size(), 0);
		System.out.println("First account number = "+listOfUsers.get(0).getAccountno());
	}
}
