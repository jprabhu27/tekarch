package com.restTests.helpers;


import com.restTests.pojos.CreatePojo;
import com.restTests.pojos.EmployeeDataPojo;

import io.restassured.response.Response;

public class ReusableMethods {
	
public static EmployeeDataPojo employee;
	
	public static EmployeeDataPojo getEmployee() {
		if (employee == null) {
			employee = new EmployeeDataPojo();
			
			//employee.setId(25);
			employee.setEmployee_name("Sheila");
			employee.setEmployee_salary(2000);
			employee.setEmployee_age(23);
			employee.setProfile_image("");
		}
		return employee;
	}
	
	public int getStatusCode(Response response) {
		
		return response.getStatusCode();
		
	}
	
	public String getContentType(Response response) {
		
		return response.getContentType();
	}
	
	public static void verifyStatusCodeis (Response response, int statuscode) {
		
		response.then().statusCode(statuscode);
	}
	
	public static String getJsonPathData(Response response, String path) {
		
		return response.jsonPath().getString(path);
	}

	
}


