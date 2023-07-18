package com.restTests.simpleTests;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class CreateEmployees {
	
public static void addEmployee(Logger logger)throws IOException {
		
		logger.info("*************User info is displayed****************");
		
		Response res= UserServiceHelper.addEmployeeData();
		ReusableMethods.verifyStatusCodeis(res, 200); 
		String status = ReusableMethods.getJsonPathData(res,"status");
		Assert.assertEquals(status, "success");
	
		
		logger.info("*************User is Created****************");
	}

}
