package com.employeeapi.testCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuthForTwitterAI {
	
	
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void postTwitterAPI()
	{
		
		Response response=RestAssured.given().auth()
		.oauth("BOYTO7hDrk0XMVRjFb8085BFM",
				"dfL9wbSr4hn8kYUtxZdIwKj9pHqEkjFjFe7cXMtAlUetsUWPlK",
				"977396696920535040-XjgW8ORUfWfXJCFTFJUVR26oiHuuO2u",
				"MqjoWqiDVpJTMusqYVjsyuD7H03q0BIShEqyRdgBgnSTJ")
		.post("https://api.twitter.com/1.1/statuses/update.json?status=Anil Mishra Tweet2 ");
		
		System.out.println("Response code ==> "+response.getStatusCode());
		
		System.out.println("Response Body ==> "+response.getBody().jsonPath().prettify());
		
		System.out.println("********************************************");
		System.out.println("Response Body ==> "+response.getBody().asString());
		System.out.println("********************************************");
		
		 JsonPath jsonPathEvaluator = response.jsonPath();
		HashMap<List, List> li=jsonPathEvaluator.get();
		for(Map.Entry<List, List> map:li.entrySet())
		{
			System.out.println(map.getKey()+" ==> "+map.getValue());
		}
	}

}
