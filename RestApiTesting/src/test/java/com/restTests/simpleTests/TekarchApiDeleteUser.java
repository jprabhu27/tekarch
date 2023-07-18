package com.restTests.simpleTests;

import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restTests.POJOs.AddUserPOJO;
import com.restTests.POJOs.LoginDataPOJO;
import com.restTests.constants.Endpoints;
import com.restTests.POJOs.DeleteUserPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;


public class TekarchApiDeleteUser {
	
	
	String extractedToken=null;
	String id;
	
	//copy the stuff till when from the createUser
	
	@BeforeClass
	public void init() {
		
		RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";	
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
		.post("login");
				
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(lessThan(5000L));
		
		res.prettyPrint();
		extractedToken = res.body().jsonPath().getString("[0].token");
		System.out.println("token extracted from jsonpath =" +extractedToken);
		
		}
	
	
	@Test (dependsOnMethods = "loginToApi1")
	public void deleteUser() {
		
		System.out.println("inside getUserstoken =" +extractedToken);
		Header ob = new Header("token", extractedToken);
		System.out.println("inside getUserstoken =" +extractedToken);
		
		DeleteUserPOJO  deletedata = new DeleteUserPOJO ();
				
		deletedata.setUserid("fKS5nlmMYhyAQnjI0Wo8");
		deletedata.setId("6bSNkGoEcHUEfafQo6PQ");
		
						
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(deletedata)//(serialization) jackson is internally converting this POJO object into actual JSON format
				.header(ob)
				
				.when()
				.delete(Endpoints.DELETE_DATA);
		
										
				res
				.then()
				.statusCode(200)
				.body("status", Matchers.equalTo("success"))
				.contentType(ContentType.JSON)
				.time(lessThan(5000L))
				.log().all();
				
				res.prettyPrint();
				
	
	}
}
