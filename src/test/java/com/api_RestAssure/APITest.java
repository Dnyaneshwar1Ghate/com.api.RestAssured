package com.api_RestAssure;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    // Base URL of the API	
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    // Test GET request
    @Test
    public void testGetRequest() {
        // Send a GET request to fetch a post by ID
        Response response = given()
                                .baseUri(BASE_URL)
                                .when()
                                .get("/posts/1");

        // Validate status code
        Assert.assertEquals(response.statusCode(), 200);

        // Validate Content-Type header
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        // Validate the response body (JSON path validation)
        response.then().body("id", equalTo(1));
        response.then().body("title", notNullValue());

        // Print the response for verification
        response.prettyPrint();

        System.out.println("GET request test passed");
    }

    // Test POST request
    @Test
    public void testPostRequest() {
        // Prepare the request payload (body)
	        String jsonBody = "{\n" +
	                          "  \"title\": \"foo\",\n" +
	                          "  \"body\": \"bar\",\n" +
	                          "  \"userId\": 1\n" +
	                          "}";

        // Send a POST request to create a new post
        Response response = given()
                                .baseUri(BASE_URL)
                                .header("Content-Type", "application/json")
                                .body(jsonBody)
                                .when()
                                .post("/posts");

        // Validate status code
        Assert.assertEquals(response.statusCode(), 201);

        // Validate the response body
        Assert.assertEquals(response.jsonPath().getString("title"), "foo");
        Assert.assertEquals(response.jsonPath().getString("body"), "bar");
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);

        // Print the response for verification
        response.prettyPrint();

        System.out.println("POST request test passed");
    }

    // Test PUT request
    @Test
    public void testPutRequest() {
        // Prepare the request payload (body)
        String jsonBody = "{\n" +
                          "  \"id\": 1,\n" +
                          "  \"title\": \"updated title\",\n" +
                          "  \"body\": \"updated body\",\n" +
                          "  \"userId\": 1\n" +
                          "}";

        // Send a PUT request to update an existing post
        Response response = given()
                                .baseUri(BASE_URL)
                                .header("Content-Type", "application/json")
                                .body(jsonBody)
                                .when()
                                .put("/posts/1");

        // Validate status code
        Assert.assertEquals(response.statusCode(), 200);

        // Validate the response body
        Assert.assertEquals(response.jsonPath().getString("title"), "updated title");
        Assert.assertEquals(response.jsonPath().getString("body"), "updated body");

        // Print the response for verification
        response.prettyPrint();

        System.out.println("PUT request test passed");
    }

    // Test DELETE request
    @Test
    public void testDeleteRequest() {
        // Send a DELETE request to delete a post by ID
        Response response = given()
                                .baseUri(BASE_URL)
                                .when()
                                .delete("/posts/1");

        // Validate status code (204 means no content, successful deletion)
        Assert.assertEquals(response.statusCode(), 200);

        // Print the response for verification
        response.prettyPrint();

        System.out.println("DELETE request test passed");
    }
}

