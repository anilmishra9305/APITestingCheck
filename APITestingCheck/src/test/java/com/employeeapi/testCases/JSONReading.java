package com.employeeapi.testCases;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONReading {
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {
    	
    	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		
		RequestSpecification htprequest=RestAssured.given();
		
		Response response=htprequest.request(Method.GET);

        String data1=response.getBody().asString().toString();
        Object obj = new JSONParser().parse(data1); 
        JSONObject person = (JSONObject) obj; 
        
        System.out.println("==> "+person.get("status"));
      
            JSONArray arrays = (JSONArray) person.get("data");
            for (Object object : arrays) {
            	//System.out.println(object);
            	Map m1=(Map) object;
            	System.out.println("*****************************************************");
                System.out.println("id ==>" + m1.get("id"));
                System.out.println("employee salary ==>" + m1.get("employee_salary"));
                System.out.println("employee Name ==>" + m1.get("employee_name"));
                System.out.println("employee age ==>" + m1.get("employee_age"));

            }
            
       

    }
}

