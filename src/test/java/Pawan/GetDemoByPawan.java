package Pawan;

import org.testng.annotations.Test;
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
	    .body("employee.firstName", equalTo("John"))
	    .body("employee.position", equalTo("Software Engineer"))
	    .body("employee.salary", equalTo(75000))
	    .header("Content-Type", "application/json")
	    .log().all();

		
		
		
	}

}
