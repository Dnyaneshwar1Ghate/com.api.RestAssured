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
		.get("https://api.restful-api.dev/objects")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("name[0]", equalTo("Google Pixel 6 Pro"))
		.header("Content-Type", "application/json");
		
		
	}

}
