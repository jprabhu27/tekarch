package com.restTests.helpers;

import java.util.Arrays;
import java.util.List;

import com.restTests.POJOs.*;
import com.restTests.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.http.Header;

public class UserServiceHelper {

	private static Response response;
	private static String token = null;

	public static String getBaseUri() {

		String baseURI = Endpoints.base_url;
		return baseURI;
	}

	public static Response LoginToApplication() {
		String username = "jayaprabhu@hotmail.com";
		String password = "Tekarch@123";

		LoginDataPOJO ob = new LoginDataPOJO();
		ob.setUsername(username);
		ob.setPassword(password);
		
		response = RestAssured.given().contentType("application/json").body(ob).when().post(Endpoints.LOGIN);

		return response;

	}

	public static String getToken() {

		response = LoginToApplication();
		token = response.jsonPath().get("[0].token");
		return token;

	}

	public static List<UserPOJO> getUserData() {
		if (token == null) {
			getToken();
		}
		Header header = new Header("token", token);
		System.out.println("User data token =======" + token);
		response = RestAssured.given().header(header).when().get(Endpoints.GET_DATA);
		UserPOJO[] userArray = response.as(UserPOJO[].class);
		List<UserPOJO> list = Arrays.asList(userArray);

		response.then().statusCode(200);

		System.out.println("Number of records =" + response.jsonPath().get("$.size()"));
		return list;
	}

	public static Response addUserData() {
		if (token == null) {
			getToken();
		}
		Header header = new Header("token", token);
		AddUserPOJO user = ReusableMethods.getUserDataToAdd();
		response = RestAssured.given().contentType("application/json").header(header).body(user).when()
				.post(Endpoints.ADD_DATA);

		return response;
	}

	public static int getStatuscode(Response res) {

		return res.getStatusCode();
	}

	public static Response updateUserData() {

		UserPOJO updateUser = new UserPOJO();
		List<UserPOJO> listOfUsers = getUserData();
		for (UserPOJO userToBeUpdated : listOfUsers) {
			if (userToBeUpdated.getAccountno().equals(ReusableMethods.getUserData().getAccountno())) {
				updateUser = userToBeUpdated;
				updateUser.setDepartmentno("5");
				updateUser.setSalary("5000");
			}

		}

		Header headers = new Header("token", token);
		response = RestAssured.given().contentType("application/json").header(headers).body(updateUser).when()
				.put(Endpoints.UPDATE_DATA);

		return response;

	}

	public static Response deleteUserData() {
		// search for particular record using account number then extract id and userid
		// and send it as body

		UserPOJO deleteUser = new UserPOJO();
		List<UserPOJO> listOfUsers = getUserData();
		for (UserPOJO userToBeDeleted : listOfUsers) {
			if (userToBeDeleted.getAccountno().equals(ReusableMethods.getUserData().getAccountno())) {
				deleteUser = userToBeDeleted;
			}
		}
		
		DeleteUserPOJO deleteUserPOJO = new DeleteUserPOJO();
		deleteUserPOJO.setId(deleteUser.getId());
		deleteUserPOJO.setUserid(deleteUser.getUserid());
		
		Header headers = new Header("token", token);
		response = RestAssured.given().contentType("application/json").header(headers).body(deleteUserPOJO).when()
				.delete(Endpoints.DELETE_DATA);

		return response;
	}

}
