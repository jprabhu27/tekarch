package com.restTests.simpleTests;

import com.restTests.helpers.UserServiceHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Login extends UserServiceHelper {

	public static void validateToken(Logger logger)
	{
		logger.info("*************Login****************");
		String token = getToken();
		System.out.println("Token *********** =" +token);
		Assert.assertNotNull(token);
	}
}
