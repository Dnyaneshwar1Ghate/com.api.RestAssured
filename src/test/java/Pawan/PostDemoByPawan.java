package Pawan;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostDemoByPawan {

	public static HashMap<Object, Object> map = new HashMap();

	@BeforeClass
	public void postData() {
		map.put("firstName", "dnay ");
		map.put("lastName", "hatesfmsf ");
		map.put("age", "37");
		map.put("position", "Eng");
		map.put("department", "Testing");
		map.put("salary", "205400");

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath="/employees";
		{
			   
			   
		}
	}
	@Test
	public void postRequest()
	{
		given()
			
			.contentType("application/json")
			.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.log().all();
		
		
		
			
		
	}

}
