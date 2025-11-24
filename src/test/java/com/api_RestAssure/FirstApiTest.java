package com.api_RestAssure;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class FirstApiTest {

	@Test
	public void demo_GEt_Request() {
		
		given().when().get("http://localhost:3000/employees").then().statusCode(200).statusLine("HTTP/1.1 200 OK")

		.assertThat()		
		.body("firstName[4]", equalTo("mahesh")).header("Content-Type", "application/json");

		System.out.println("First Test Case Pass for GEt API Automation using Rest");
	}

}
