package com.api_RestAssure;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleApi {

	@Test
	public void ApiTest()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response response= given()
				.when().get("/posts/2")
				.then().statusCode(200)
				.extract().response();
				System.out.println("resopnse body "+response.getBody().asString());
				
				System.out.println("simple API test pass ");
		
	}



}
