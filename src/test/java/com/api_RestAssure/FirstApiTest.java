package com.api_RestAssure;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class FirstApiTest {

	@Test
	public void demo_GEt_Request() {
		
		given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).statusLine("HTTP/1.1 200 OK")

		.assertThat()		
		.body("title[1]", equalTo("qui est esse")).header("Content-Type", "application/json; charset=utf-8");

		System.out.println("First Test Case Pass for GEt API Automation using RestAssured Done");
	}

}
