package Pawan;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetDemoByPawan {
	
	@Test()
	public void getRequest()
	{
		given()
		.when()
		.get("http://localhost:3000")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("firstName[1]", equalTo("John"))
		.assertThat().body("position", equalTo("Software Engineer"))
		.assertThat().body("salary", equalTo(75000))
		.header("Content-Type", "application/json")
		.log().all();
		
		
		
	}

}
