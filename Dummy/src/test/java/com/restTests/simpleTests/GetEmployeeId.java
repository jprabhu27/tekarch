package com.restTests.simpleTests;



import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.restTests.helpers.ReusableMethods;
import com.restTests.helpers.UserServiceHelper;


import io.restassured.response.Response;

public class GetEmployeeId {
	
	public static void getEmpId(Logger logger) {
		
		logger.info("*************Reading getEmpId****************");
		//Return list of users

		Response res= UserServiceHelper.getEmployeeId();
		String status = ReusableMethods.getJsonPathData(res,"status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************End of getEmpId****************");
		
	}

}
