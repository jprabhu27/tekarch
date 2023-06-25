package com.restTests.simpleTests;

import static org.hamcrest.Matchers.*;
//import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restTests.POJOs.LoginDataPOJO;
import com.restTests.POJOs.LoginResponsePOJO;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class TekarchApiGetAllUsers {
	
	String extractedToken=null;
	
	
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
				
		.log().all()	
		.contentType(ContentType.JSON)
		.body(data)//(serialization) jackson is internally converting this POJO object into actual JSON format
		.when()
		.post("login");
		
		LoginResponsePOJO ob = new LoginResponsePOJO();
		
		LoginResponsePOJO [] list = res.as(LoginResponsePOJO[].class);//deserialization
		System.out.println("token extracted from response pojo object =" + list[0].getToken());
		
		
		res
		.then()
		//.log().headers()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(lessThan(5000L));
		
		//res.prettyPrint();
		extractedToken = res.body().jsonPath().getString("[0].token");
		System.out.println("token extracted from jsonpath =" +extractedToken);
		
		}
	
	@Test(dependsOnMethods = "loginToApi1")
	public void getUsers() {
		
		System.out.println("inside getUserstoken =" +extractedToken);
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given()
		.header(ob)
		.when()
		.get("getdata");
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		//.time(Matchers.lessThan(10000L));
		res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetAllUsersSchema.json"));
		res.prettyPrint();
		System.out.println("Total number of records= " +res.body().jsonPath().get("size()"));
	
		
	}
}
