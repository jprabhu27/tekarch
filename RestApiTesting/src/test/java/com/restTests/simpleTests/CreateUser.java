package com.restTests.simpleTests;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;

import io.restassured.response.Response;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CreateUser {
	
	public static void addUser(Logger logger)throws IOException {
		
		logger.info("*************User info is displayed****************");
		
		Response res= UserServiceHelper.addUserData();
		ReusableMethods.verifyStatusCodeis(res, 201); // New creation success is 201 - Created
		String status = ReusableMethods.getJsonPathData(res,"status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User is Created****************");
	}
}
