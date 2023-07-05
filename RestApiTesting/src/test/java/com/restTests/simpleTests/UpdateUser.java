package com.restTests.simpleTests;

import java.io.IOException;

import org.testng.Assert;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class UpdateUser {
	
public static void updateUser(Logger logger)throws IOException{
		
		logger.info("*************Updating User data****************");
	
		Response response = UserServiceHelper.updateUserData();
		ReusableMethods.verifyStatusCodeis(response,200);
		System.out.println("data has been updated----------");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User updated****************");
	}

}
