package com.restTests.simpleTests;


import java.io.IOException;

import org.testng.Assert;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class DeleteUser {
	
public static void deleteUser(Logger logger)throws IOException{
		
		logger.info("*************Delete User Data****************");
		
		Response response = UserServiceHelper.deleteUserData();
		ReusableMethods.verifyStatusCodeis(response, 200);
		System.out.println("Deleted Successfully ");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User Deleted****************");
		
	}

}
