package com.restTests.helpers;

import java.util.List;

import org.testng.Assert;

import com.restTests.constants.Endpoints;
import com.restTests.pojos.EmployeeDataPojo;
//import com.restTests.helpers.ReusableMethods;
import io.restassured.RestAssured;
//import io.restassured.http.Header;
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
	
	public static Response addEmployeeData() {
		
		EmployeeDataPojo employee = ReusableMethods.getEmployee() ;
		
		response = RestAssured.given()
				.contentType("application/json")
				.body(employee)
				.when()
				.post(Endpoints.ADD_EMPLOYEE);
		
		response.prettyPrint();
		
		String actualStatus = response.jsonPath().get("status");
		String expectedStatus = "success";
		Assert.assertEquals(actualStatus, expectedStatus);
		
		String actualEmployeeName = response.jsonPath().get("data.employee_name");
		Assert.assertEquals(actualEmployeeName, employee.getEmployee_name());
		
		Integer actualEmployeeSalary = response.jsonPath().getInt("data.employee_salary");
		Assert.assertEquals(actualEmployeeSalary, employee.getEmployee_salary());
		
		Integer actualEmployeeAge = response.jsonPath().get("data.employee_age");
		Assert.assertEquals(actualEmployeeAge, employee.getEmployee_age());

		// Save id into employee object
		employee.setId(response.jsonPath().getInt("data.id"));
		
		System.out.println("Response body status = " + actualStatus);
		System.out.println("Response actualEmployeeName = " + actualEmployeeName);
		System.out.println("Response actualEmployeeSalary = " + actualEmployeeSalary);
		System.out.println("Response actualEmployeeAge = " + actualEmployeeAge);
		System.out.println("Employee ID = " + employee.getId());

		System.out.println("addEmployeeData()" +response);
		return response;
		
	}

	
	public static Response deleteEmployeeData(Integer employeeId) {
		System.out.println("Trying to delete employee with id " + employeeId);
		response = RestAssured.given()
				.contentType("application/json")
				.when()
				.delete(Endpoints.DELETE_DATA + "/" + employeeId);
				
						
		response.then().statusCode(200);
		
				
		response.prettyPrint();
		
		String actualStatus = response.jsonPath().get("status");
		String expectedStatus = "success";
		Assert.assertEquals(actualStatus, expectedStatus);
		
		String actualdataid = response.jsonPath().get("data");
		String expectdataid = ((Integer)employeeId).toString();
		Assert.assertEquals(actualdataid, expectdataid);
		
		String actualmessage = response.jsonPath().get("message");
		String expectedmessage = "Successfully! Record has been deleted";
		Assert.assertEquals(actualmessage, expectedmessage);
		
		
		return response;
	}
	
	public static Response deleteEmployeeId() {
		int id =0;
		
		response = RestAssured.given()
				.contentType("application/json")
				.when()
				.delete(Endpoints.DELETE_DATA + "/" + id);
		
		response.then().statusCode(400);
		response.prettyPrint();
		
		String actualStatus = response.jsonPath().get("status");
		String expectedStatus = "error";
		Assert.assertEquals(actualStatus, expectedStatus);
		
				
		String actualmessage = response.jsonPath().get("message");
		String expectedmessage = "Not found record";
		Assert.assertEquals(actualmessage, expectedmessage);
		System.out.println("Message = "+actualmessage);
		
		
		return response;
		
	}
	
	public static Response getEmployeeId() {
		
			int id = 2;	
		response = RestAssured.given()
				.when()
				.get(Endpoints.GET_EMPLOYEE_ID + "/" +id);
		
		response.then().statusCode(200).contentType("application/json");
		
		String actualStatus = response.jsonPath().get("status");
		String expectedStatus = "success";
		
		Assert.assertEquals(actualStatus, expectedStatus);
			
		System.out.println("Response body status = " + actualStatus);
		
		String actualEmployeeName = response.jsonPath().get("data.employee_name");
		Assert.assertEquals(actualEmployeeName, "Garrett Winters");
		
		Integer actualEmployeeSalary = response.jsonPath().getInt("data.employee_salary");
		Assert.assertEquals(actualEmployeeSalary, 170750);
		
		Integer actualEmployeeAge = response.jsonPath().get("data.employee_age");
		Assert.assertEquals(actualEmployeeAge, 63);

		
		return response;
	}

}
