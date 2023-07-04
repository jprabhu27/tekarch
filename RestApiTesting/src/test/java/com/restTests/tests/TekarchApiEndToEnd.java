package com.restTests.tests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.restTests.POJOs.AddUserPOJO;
import com.restTests.POJOs.UserPOJO;
import com.restTests.helpers.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.restTests.helpers.UserServiceHelper;
import com.restTests.simpleTests.CreateUser;
import com.restTests.simpleTests.GetAllUsers;
import com.restTests.simpleTests.Login;

public class TekarchApiEndToEnd extends UserServiceHelper {
	
	
	public static Logger logger;  //for logs
	
	@BeforeMethod
	public static void baseUri() {
		
		RestAssured.baseURI = getBaseUri();
		
		//Logs
		logger = LogManager.getLogger(TekarchApiEndToEnd.class.getName());
		
	}
	
	
	@Test(priority =1, enabled = true)
	public static void TC_001_validLogin()
	{
		System.out.println("\n===============================================");
		System.out.println("TC_001_validLogin");
		Login.validateToken(logger);
		System.out.println("===============================================\n");
	}
	
	
	@Test(priority =2, enabled = true)
	public static void TC_002_getUserData() {
		System.out.println("\n===============================================");
		System.out.println("TC_002_getUserData");
		GetAllUsers.getUserData(logger);
		System.out.println("===============================================\n");
	}
	
	
	@Test(priority =3, enabled = true)
	public static void TC_003_addUserData()throws IOException {
		System.out.println("\n===============================================");
		System.out.println("TC_003_addUserData");
		CreateUser.addUser(logger);
		System.out.println("===============================================\n");
	}
	
	
	@Test(priority =4, enabled = true)
	public static void TC_004_updateUserData()throws IOException{
		
		logger.info("*************Updating User data****************");
	
		Response response = updateUserData();
		ReusableMethods.verifyStatusCodeis(response,200);
		System.out.println("data has been updated----------");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User updated****************");
	}
	
	
	@Test(priority =5, enabled = true)
	public static void TC_005_deleteUserData()throws IOException{
		
		logger.info("*************Delete User Data****************");
		
		Response response = deleteUserData();
		ReusableMethods.verifyStatusCodeis(response, 200);
		System.out.println("Deleted Successfully ");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
		logger.info("*************User Deleted****************");
		
	}

}
