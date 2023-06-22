package com.restTests.simpleTests;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//https://fakerestapi.azurewebsites.net//api/v1/Activities

public class SimpleRestRequests {
	
	@Test
	public void TestFakeRestApi() {
		
		RequestSpecification req = RestAssured.given();
		//This will return the response
		Response res = req.when()
							.get("https://fakerestapi.azurewebsites.net//api/v1/Activities");
		
		//Validating the content type as JSON
		res.then().contentType(ContentType.JSON);
		res.then().statusCode(200);
		//Response time 
		res.then().time(Matchers.lessThan(4000L));
		
		res.prettyPrint();
		
		//Extracting the data
		int statuscode = res.statusCode();
		System.out.println("status code = "+statuscode);
		String contentType = res.getContentType();
		System.out.println("Content Type = "+contentType);
		
		//rest assured internally supports jsonpath from gson
		//The format is present in the jayway jsonpath
		String title = res.body().jsonPath().getString("[1].title");
		System.out.println("title = "+title);
		
		//Extract id
		int id = res.body().jsonPath().getInt("[1].id");
		System.out.println("ID = "+id);
		//Assert.assertEquals(title, "Activity2");
		
		//Validate if the title is activity2
		res.then().body("[1].title", Matchers.is("Activity 2"));
		
		int size = res.body().jsonPath().get("size()");
		System.out.println("Number of records = "+size);
		
		ArrayList<Integer> listID = res.body().jsonPath().get("id");
		for(int i:listID) {
			System.out.println(i);
		}
		
		System.out.println(res.body().jsonPath().get("id.min()"));
		System.out.println(res.body().jsonPath().get("id.max()"));
	}
	
	@Test
	public void TestItAgain() {
		
		RestAssured.given()
		.when()
		.get("https://fakerestapi.azurewebsites.net//api/v1/Activities")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(4000L))
		.body("[1].title", Matchers.is("Activity 2"));
	}

}
