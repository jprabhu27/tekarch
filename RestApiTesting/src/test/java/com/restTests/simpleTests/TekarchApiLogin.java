package com.restTests.simpleTests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TekarchApiLogin {
	String extractedToken=null;
	
	@Test
	public void loginToApi() {
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\"username\":\"jayaprabhu@hotmail.com\",\"password\":\"Tekarch@123\"}")
		.when()
		.post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login")
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000L));
		
		
		
	}

	@Test
	public void loginToApi1() {
		
		Response res = RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\"username\":\"jayaprabhu@hotmail.com\",\"password\":\"Tekarch@123\"}")
		.when()
		.post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
		
		res
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000L));
		
		extractedToken = res.body().jsonPath().getString("[0].token");
		System.out.println("token =" +extractedToken);
		
	}
	
	@Test(dependsOnMethods = "loginToApi1")
	public void getUsers() {
		
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given()
		.header(ob)
		.when()
		.get("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(10000L));
		
		res.prettyPrint();
		
	}
}
