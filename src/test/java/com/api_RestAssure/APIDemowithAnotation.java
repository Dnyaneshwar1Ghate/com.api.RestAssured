package com.api_RestAssure;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;
public class APIDemowithAnotation {
	
	@BeforeTest

    public void setup() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }

    @Test

    public void validateGetRequest() {

        given()

            .when().get("/posts/1")

            .then().statusCode(200)

            .log().all();

    }

    @AfterTest

    public void teardown() {

        System.out.println("Test completed.");

    }


}
