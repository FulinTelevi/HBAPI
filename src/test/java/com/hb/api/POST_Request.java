package com.hb.api;

import org.junit.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST_Request {

	@Test
	public void PostRequest() {

		RestAssured.baseURI = "http://generator.swagger.io";
		String getStatusEndPoint = "/api/gen/clients";
		Response response = RestAssured.when().post(getStatusEndPoint);
		String body =RestAssured.given().when().get(getStatusEndPoint).getBody().asString();
		String[] bodyArray = new Gson().fromJson(body, String[].class);
		String postStatusEndPoint = "/api/gen/clients/" + bodyArray[0];
		System.out.println(postStatusEndPoint);
		String payload = "{\r\n" + "  \"spec\": \"\"}";
		

		RestAssured.given()
		.header("Content-Type", "application/json")
		.body(payload)
		.when()
		.post(postStatusEndPoint)
		.then()
		.assertThat()
		.statusCode(200);

	}


}
