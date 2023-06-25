package com.restTests.simpleTests;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.hamcrest.Matchers;
//import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restTests.POJOs.LoginDataPOJO;
import com.restTests.POJOs.AddUserPOJO;
import com.restTests.POJOs.LoginResponsePOJO;
import com.restTests.constants.Endpoints;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class TekarchApiCreateUser {
	
	String extractedToken=null;
	String id;
	
	
	@BeforeClass
	public void init() {
		
		RestAssured.baseURI=Endpoints.base_url;	
	}
	
	@Test
	public void loginToApi1() {
		
		LoginDataPOJO data = new LoginDataPOJO();
		data.setUsername("jayaprabhu@hotmail.com");
		data.setPassword("Tekarch@123");
		
		
		Response res = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(data)//(serialization) jackson is internally converting this POJO object into actual JSON format
		.when()
		.post(Endpoints.LOGIN);
				
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(lessThan(5000L));
		
		res.prettyPrint();
		extractedToken = res.body().jsonPath().getString("[0].token");
		System.out.println("token extracted from jsonpath =" +extractedToken);
		
		}
	
	@Test(dependsOnMethods = "loginToApi1")
	public void addUser() {
		
		System.out.println("inside getUserstoken =" +extractedToken);
		Header ob = new Header("token", extractedToken);
		System.out.println("inside getUserstoken =" +extractedToken);
		
		AddUserPOJO userdata = new AddUserPOJO();
				
		userdata.setAccountno("JP-1234568");
		userdata.setDepartmentno("2");
		userdata.setSalary("4000");
		userdata.setPincode("95688");
		
		
		//Header ob1 = new Header("token", extractedToken);
		
				
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(userdata)//(serialization) jackson is internally converting this POJO object into actual JSON format
				.header(ob)
				
				.when()
				.post(Endpoints.ADD_DATA);
		
				//res.body().jsonPath().getString("id");
						
				res
				.then()
				.statusCode(201)
				.body("status", Matchers.equalTo("success"))
				.contentType(ContentType.JSON)
				.time(lessThan(5000L))
				.log().all();
				
				res.prettyPrint();
				
				
		

	}
}
