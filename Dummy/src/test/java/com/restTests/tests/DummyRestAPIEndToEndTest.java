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
import com.restTests.simpleTests.GetEmployeeId;
import com.restTests.simpleTests.GetEmployees;



public class DummyRestAPIEndToEndTest extends UserServiceHelper {

			
		public static Logger logger;  //for logs
		
		@BeforeMethod
		public static void baseUri() {
			
			RestAssured.baseURI = getBaseUri();
			
			//Logs
			logger = LogManager.getLogger(DummyRestAPIEndToEndTest.class.getName());
			
		}
		
		@Test(priority =1, enabled = true)
		public static void TC_002_addEmployeeData()throws IOException {
			System.out.println("\n===============================================");
			System.out.println("TC_003_addEmployeeData()");
			CreateEmployees.addEmployee(logger);
			System.out.println("===============================================\n");
		}
		
		@Test(priority =2, enabled = true)
		public static void TC_001_getEmployeeData() {
			System.out.println("\n===============================================");
			System.out.println("TC_001_getEmployeeData");
			GetEmployees.getEmployees(logger);
			System.out.println("===============================================\n");
		}
		
		@Test(priority =3, enabled = true)
		public static void TC_003_deleteEmployeeData()throws IOException{
			Integer employeeId = 8453; // Replace 0 with output from Test 2
			System.out.println("\n===============================================");
			System.out.println("TC_003_deleteEmployeeData");
			DeleteEmployees.deleteEmployee(employeeId, logger);
			System.out.println("===============================================\n");
			
		}
		
		@Test(priority =4, enabled = true)
		public static void TC_004_deleteEmployeeId() throws IOException{
			
			System.out.println("\n===============================================");
			System.out.println("TC_004_deleteEmployeeId");
			DeleteEmployees.deleteId(logger);
			System.out.println("===============================================\n");
			
		}
		
		@Test(priority =5, enabled = true)
		public static void TC_005_getDetailsEmployeeId() throws IOException{
			
			System.out.println("\n===============================================");
			System.out.println("TC_005_getDetailsEmployeeId");
			GetEmployeeId.getEmpId(logger);
			System.out.println("===============================================\n");
			
		}
}	
		
		
