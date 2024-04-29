package com.hb.api;

import org.junit.Test;

import io.restassured.RestAssured;
import org.junit.Assert;
public class GET_Request {

	@Test
	public void GetRequest() {

		RestAssured.baseURI = "http://generator.swagger.io";

		String getStatusEndPoint = "/api/gen/clients";

		RestAssured.given()
		.get(getStatusEndPoint)
		.then()
		.assertThat()
		.statusCode(200);

	}
}
