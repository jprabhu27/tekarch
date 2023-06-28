package com.restTests.simpleTests;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restTests.POJOs.LoginDataPOJO;



import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class TekarchApiLogin {
	String extractedToken = null;


	@Test
	public void loginToApi() {

		RestAssured.given().contentType(ContentType.JSON)
				.body("{\"username\":\"jayaprabhu@hotmail.com\",\"password\":\"Tekarch@123\"}").when()
				.post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login").then().statusCode(201)
				.contentType(ContentType.JSON).time(Matchers.lessThan(5000L));

	}

	@Test
	public void loginToApi1() {

		Response res = RestAssured.given().contentType(ContentType.JSON)
				.body("{\"username\":\"jayaprabhu@hotmail.com\",\"password\":\"Tekarch@123\"}").when()
				.post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");

		res.then().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(5000L));

		extractedToken = res.body().jsonPath().getString("[0].token");
		System.out.println("token =" + extractedToken);
		
		
	}

	@Test(dependsOnMethods = "loginToApi1")
	public void getUsers() {

		System.out.println("inside getUserstoken =" + extractedToken);
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().header(ob).queryParam("userid", "lzQHg4ywe0MI87vM7fpF").when()
				.get("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);
		// .time(Matchers.lessThan(10000L));

		res.prettyPrint();

				
	}

	// find the total number of records
	@Test(dependsOnMethods = "loginToApi1")
	public void findTotalNoRecords() {

		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);

		int totalRecords = res.body().jsonPath().get("size()");
		System.out.println("Total number of records= " + res.body().jsonPath().get("size()"));

	}

	// Validating if total records are less than 10000
	
	@Test(dependsOnMethods = "loginToApi1")
	public void validateTotalRecordsLessThan10000() {

		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);

		int totalRecords = res.body().jsonPath().get("size()");
		System.out.println("Total number of records= " + res.body().jsonPath().get("size()"));
		int lessThanSize = 10000;
		//MatcherAssert.assertThat(totalRecords,lessThan(lessThanSize));
		if (totalRecords < 10000) {

			System.out.println("The total records are less than 10000");
		} else {
			System.out.println("The total records are equal or greater than 10000");
		}

	}

	// find total number of records matching userid = lzQHg4ywe0MI87vM7fpF

	@Test(dependsOnMethods = "loginToApi1")
	public void findTotalNoRecordsForUserid() {

		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);

		int totalRecordMatchingId = res.body().jsonPath().getInt("findAll{it.userid=='lzQHg4ywe0MI87vM7fpF'}.size()");
		System.out.println("Total records matching the userid= lzQHg4ywe0MI87vM7fpF is: " + totalRecordMatchingId);
		System.out.println();

	}

	// total number of salary of all records whose userid = lzQHg4ywe0MI87vM7fpF
	
	@Test(dependsOnMethods = "loginToApi1")
	public void getTotalNoSalaryUserid() {

		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);
		
		List<Object> listID = res.body().jsonPath().getList("findAll(it.userid == 'lzQHg4ywe0MI87vM7fpF')");
		Integer totalSalary =0;
		for(Object str: listID) {
			
			totalSalary += Integer.parseInt(str.toString());
		}
		
		System.out.println("The total salary for userId lzQHg4ywe0MI87vM7fpF = "+totalSalary);
	}
	
	// get all account no for the userid =lzQHg4ywe0MI87vM7fpF
	
	@Test(dependsOnMethods = "loginToApi1")
	public void getAccountNoforUserid() {
		
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);

		
		List<String> accountNo = res.body().jsonPath()
				.getList("findAll{it.userid == 'lzQHg4ywe0MI87vM7fpF'}.accountno");
		System.out.println("Account numbers for the userid = lzQHg4ywe0MI87vM7fpF");
		for (String accountNumber : accountNo) {
			String accountNumberString = String.valueOf(accountNumber);
			System.out.println(accountNumberString);
		}
		
	}
	
	// find total records with dept no=5
	
	@Test(dependsOnMethods = "loginToApi1")
	public void findTotalNoRecordsDeptNo5() {

		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);
		
		int totalRecordsDept = res.body().jsonPath().getList("findAll{it.departmentno==5}").size();
		System.out.println("The total records with dept no=5 are: " + totalRecordsDept);

	}
	
	// find the minimum and maximum salary of all records(note:salary is in string
			// in response)
	
	@Test(dependsOnMethods = "loginToApi1")
	public void minimumAndMaximumSalaryAllRecords(){
		
		Header ob = new Header("token", extractedToken);
		Response res = RestAssured.given().contentType(ContentType.JSON).header(ob).when().get("getdata");

		res.then().statusCode(200).contentType(ContentType.JSON);
		
		int minSalary = res.body().jsonPath().getInt("salry.min()");
		int maxSalary = res.body().jsonPath().getInt("salary.max()");
		
		System.out.println("Minimum salary is " +minSalary);
		System.out.println("Minimum salary is " +minSalary);
		
		
	}

}
