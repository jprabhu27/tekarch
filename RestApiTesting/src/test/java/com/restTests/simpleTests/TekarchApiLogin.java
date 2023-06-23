package com.restTests.simpleTests;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restTests.POJOs.LoginDataPOJO;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.RestAssured;

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
		
		System.out.println("inside getUserstoken =" +extractedToken);
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given()
		.header(ob)
		.queryParam("userid", "lzQHg4ywe0MI87vM7fpF")
		.when()
		.get("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata");
		
		res
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		//.time(Matchers.lessThan(10000L));
		
		res.prettyPrint();
		
		//find the total number of records
		
		int totalRecords = res.body().jsonPath().get("size()");
		System.out.println("Total number of records= " +res.body().jsonPath().get("size()"));
		
		//Validating if total records are less than 10000
		
		if (totalRecords <10000) {
			
			System.out.println("The total records are less than 10000");
		}
		else {
			System.out.println("The total records are equal or greater than 10000");
		}
		
		//find the minimum and maximum salary of all records(note:salary is in string in response)
		
		//get all account no for the userid =lzQHg4ywe0MI87vM7fpF
		
		List<String> accountNo = res.body().jsonPath().getList("findAll{it.userid == 'lzQHg4ywe0MI87vM7fpF'}.accountno");
		System.out.println("Account numbers for the userid = lzQHg4ywe0MI87vM7fpF");
		for (String accountNumber : accountNo) {
			String accountNumberString = String.valueOf(accountNumber);
			System.out.println(accountNumberString);
		}
	
		
		//find total number of records matching userid = lzQHg4ywe0MI87vM7fpF
		
		int totalRecordMatchingId = res.body().jsonPath().getInt("findAll{it.userid=='lzQHg4ywe0MI87vM7fpF'}.size()");
		System.out.println("Total records matching the userid= lzQHg4ywe0MI87vM7fpF is: " +totalRecordMatchingId);
		
		//find total records with dept no=5
		
		int totalRecordsDept = res.body().jsonPath().getList("findAll{it.departmentno==5}").size();
		System.out.println("The total records with dept no=5 are: " +totalRecordsDept);
		
	}
	
	
}
