package com.employeeapi.testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTwitterExample {
	
	@Test
	public void getExample()
	{
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/lookup.json?id=1220307577361186818";
				
		RequestSpecification htprequest=RestAssured.given();
		
		Response response=htprequest.request(Method.GET);
		
		System.out.println("***********************************************");
		System.out.println(response.getBody().jsonPath().prettify());
		System.out.println("***********************************************");
        System.out.println("Response Body is :==> "+response.getBody().asString());
		
		
	}

}
