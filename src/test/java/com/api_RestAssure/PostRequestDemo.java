package com.api_RestAssure;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class PostRequestDemo {

    private static HashMap<String, String> map = new HashMap<>();

    @BeforeTest
    public void postData() {

        map.put("title", RestUtils.getTitle());
        map.put("body", RestUtils.getBody());
        map.put("userId",RestUtils.getUserId());

     
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/posts";
    }

    @Test
    public void postRequest() {
        
        given()
            .contentType("application/json")  
            .body(map) 
        .when()
            .post()  
        .then()
            .statusCode(201)  
            
            .assertThat()
            .body("title", equalTo("foo"))  
            .assertThat()
            .body("body", equalTo("bar"))
            .assertThat()
            .body("userId", equalTo("1"))
            
            .log().all();  
        
        
        System.out.println("First Test Case Pass for GEt API Automation using RestAssured");
    }
}
