package com.restTests.tests;

import java.io.IOException;
import java.util.List;

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

public class TekarchApiEndToEnd extends UserServiceHelper {
	
	//1st  login test-extract the token
	//2nd Create user test
	//3rd Immediately execute getAllUsers test--first record--extract the user id and id
	//4th Update test
	//5th Delete test
	

	
	@BeforeMethod
	public static void baseUri() {
		
		RestAssured.baseURI = getBaseUri();
		
	}
	
	@Test(priority =1, enabled = true)
	public static void TC_001_validLogin()
	{
		
		String token = getToken();
		System.out.println("Token *********** =" +token);
	}
	
	@Test(priority =2, enabled = true)
	public static void TC_002_getUserData() {
		//Return list of users
		List<UserPOJO> listOfUsers = getUserData();
		System.out.println("First account number = "+listOfUsers.get(0).getAccountno());
	}
		
	@Test(priority =3, enabled = true)
	public static void TC_003_addUserData()throws IOException {
	
		
		Response res= addUserData();
		ReusableMethods.verifyStatusCodeis(res, 201); // New creation success is 201 - Created
		String status = ReusableMethods.getJsonPathData(res,"status");
		Assert.assertEquals(status, "success");
	}
	
	@Test(priority =4, enabled = true)
	public static void TC_004_updateUserData()throws IOException{
	
		Response response = updateUserData();
		ReusableMethods.verifyStatusCodeis(response,200);
		System.out.println("data has been updated----------");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
	}
		
	@Test(priority =5, enabled = true)
	public static void TC_005_deleteUserData()throws IOException{
		
		Response response = deleteUserData();
		ReusableMethods.verifyStatusCodeis(response, 200);
		System.out.println("Deleted Successfully ");
		String status = ReusableMethods.getJsonPathData(response, "status");
		Assert.assertEquals(status, "success");
		
	}

}
