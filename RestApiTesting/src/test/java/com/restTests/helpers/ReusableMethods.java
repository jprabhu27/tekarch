package com.restTests.helpers;

import java.util.concurrent.TimeUnit;

import com.restTests.POJOs.AddUserPOJO;

import io.restassured.response.Response;

public class ReusableMethods {
	
	public static AddUserPOJO user;
	
	public static AddUserPOJO getTestUser() {
		if (user == null) {
			user = new AddUserPOJO();
			
			user.setAccountno("JP-1234578");
			user.setDepartmentno("2");
			user.setSalary("4000");
			user.setPincode("95688");
		}
		return user;
	}
	
	public int getStatusCode(Response response) {
		
		return response.getStatusCode();
		
	}
	
	public String getContentType(Response response) {
		
		return response.getContentType();
	}
	
	public long getResponseTimeIn(Response response, TimeUnit unit) {
		
		return response.getTimeIn(unit);
	}
	
	public static void verifyStatusCodeis (Response response, int statuscode) {
		
		response.then().statusCode(statuscode);
	}

	public static String getJsonPathData(Response response, String path) {
		
		return response.jsonPath().getString(path);
	}

	
}
