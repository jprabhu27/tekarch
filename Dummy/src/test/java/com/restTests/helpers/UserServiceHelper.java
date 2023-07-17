package com.restTests.helpers;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.restTests.constants.Endpoints;
import com.restTests.pojos.EmployeeDataPojo;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserServiceHelper {
	
	private static Response response;
	
	public static String getBaseUri() {

		String baseURI = Endpoints.base_url;
		return baseURI;
	}
	
	public static List<EmployeeDataPojo> getEmployees() {
			
		
		response = RestAssured.given()
				.when()
				.get(Endpoints.GET_EMPLOYEES);
		//EmployeeDataPojo[] userArray = response.as(EmployeeDataPojo[].class);
		//List<EmployeeDataPojo> list = Arrays.asList(userArray);

		response.then().statusCode(200);
		
		String actualStatus = response.jsonPath().get("status");
		String expectedStatus = "success";
		
		Assert.assertEquals(actualStatus, expectedStatus);
		List<EmployeeDataPojo> list = response.jsonPath().getList("data", EmployeeDataPojo.class);
		
		System.out.println("Response body status = " + actualStatus);
		System.out.println("Number of data records = " + list.size());
		return list;
		
	}

}
