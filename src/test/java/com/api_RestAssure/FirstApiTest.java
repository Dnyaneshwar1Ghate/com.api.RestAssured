package com.api_RestAssure;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class FirstApiTest {

	@Test
	public void demo_GEt_Request() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).statusLine("HTTP/1.1 200 OK")
				// Corrected JSON path to access 'email' within 'data' array
				.body("data[0].email", equalTo("michael.lawson@reqres.in")).header("Server", "cloudflare");

	}

}
