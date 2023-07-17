package com.restTests.tests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import com.restTests.pojos.DataPojo;


import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.restTests.pojos.DataPojo;
import com.restTests.pojos.CreatePojo;
import com.restTests.pojos.EmployeeDataPojo;

import com.restTests.helpers.ReusableMethods;

import io.restassured.response.Response;
import com.restTests.helpers.UserServiceHelper;
import com.restTests.simpleTests.CreateEmployees;
import com.restTests.simpleTests.DeleteEmployees;

import com.restTests.simpleTests.GetEmployees;



public class DummyRestAPIEndToEndTest extends UserServiceHelper {

			
		public static Logger logger;  //for logs
		
		@BeforeMethod
		public static void baseUri() {
			
			RestAssured.baseURI = getBaseUri();
			
			//Logs
			logger = LogManager.getLogger(DummyRestAPIEndToEndTest.class.getName());
			
		}
		
		@Test(priority =2, enabled = true)
		public static void TC_001_getEmployeeData() {
			System.out.println("\n===============================================");
			System.out.println("TC_001_getEmployeeData");
			GetEmployees.getEmployees(logger);
			System.out.println("===============================================\n");
		}
		
}	
		
		
//		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1")
//				.setContentType(ContentType.JSON).build();
//		
//		//Test Case 2 Create 
//		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
//		
//		RequestSpecification addDataBaseReq = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1")
//								.build();
//				
//		RequestSpecification reqAddData = given().log().all().spec(addDataBaseReq)
//				
//		
//		//Test Case 1 Get the response in POJO
//		//fetch the number of data records and print it to the console
//		
//				public void testCase1() {
//			
//			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
//			
//			UserDataPojo getrecordsReq = given().log().all()
//					.when().get("/employees?").as(UserDataPojo.class);
//					
//			JsonPath js = new JsonPath();
//			
//		}
//		
//		
//		
////		List <com.restTests.pojos.DataPojo> data = getData(); 
////		int dataRecords = js.getInt(getrecordsResponse);
////			for(int i=0; i<)
////				
////				.then().assertThat().log().all().statusCode(200)
////				.extract().response().as(UserDataPojo.class);
//					
//		
//
//	}
//
//
