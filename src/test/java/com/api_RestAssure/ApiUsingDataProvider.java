package com.api_RestAssure;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUsingDataProvider {

	@DataProvider(name = "postIds")

    public Object[][] createPostIds() {

        return new Object[][] { { 1 }, { 2 }, { 3 } ,{ 4}, { 5}, { 6} };

    }
	@Test(dataProvider = "postIds")

    public void testMultipleGetRequests(int postId) {

        // Set the base URI

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request and extract the response

        Response response = given()

            .when().get("/posts/" + postId)

            .then().statusCode(200)  // Assert status code

            .extract().response();   // Extract the response

        // Use JSON path to assert the presence of 'id' and validate the specific postId

        int actualId = response.jsonPath().getInt("id");

        Assert.assertTrue(actualId > 0, "The ID in the response should be greater than 0 but found: " + actualId);

        Assert.assertEquals(actualId, postId, "Expected post ID (" + postId + ") does not match actual ID (" + actualId + ")");
        
        System.out.println("Test Pass Using DataProvider ");
	
	}
	
	

}
