package com.practicse;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPIExample {
	
	
	
	@Test
	public void getRequest() throws JsonMappingException, JsonProcessingException
	{
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/employees");
		String responseBody=response.getBody().asString();
		
		System.out.println("String===> "+responseBody);
		
		System.out.println("JsonPath===> "+response.getBody().jsonPath());
		
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(responseBody);
		System.out.println("Size of Node ==> "+node.size());
		
		JsonNode node2=node.path("data");
		for(int i=0;i<node2.size();i++) {
		System.out.println("Index id ===> "+node2.get(i).path("id").asInt());
		}
		for(JsonNode n:node2.path("id"))
		{
			System.out.println("====>"+n.asInt());
		}
		
		
		
		

		
	}
	
	
	
	
	

}
