package com.restTests.simpleTests;
import com.restTests.pojos.*;
import java.util.List;

import com.restTests.helpers.UserServiceHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class GetEmployees {
	
	public static void getEmployees(Logger logger) {
		
	logger.info("*************Reading User info****************");
	//Return list of users
	List<EmployeeDataPojo> listOfEmployees = UserServiceHelper.getEmployees();
	Assert.assertNotEquals(listOfEmployees.size(), 0);
}

}
