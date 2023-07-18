package com.restTests.simpleTests;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class DeleteEmployees {
	
	public static void deleteEmployee(Integer employeeId, Logger logger)throws IOException{
		
		logger.info("*************Delete User Data****************");
		
		Response response = UserServiceHelper.deleteEmployeeData(employeeId);
		ReusableMethods.verifyStatusCodeis(response, 200);
		System.out.println("Deleted Successfully ");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User Deleted****************");
		
	}
	
	public static void deleteId(Logger logger)throws IOException{
		
		logger.info("*************Delete User Data****************");
		
		Response response = UserServiceHelper.deleteEmployeeId();
		
		System.out.println("Deleted Successfully " +response);
		
		logger.info("*************User Deleted****************");
	}

}
