package com.employeeapi.testCases;

import java.util.List;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test {

	public static void main(String[] args) throws ParseException {
		
		
		
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("");
		 
		 // First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 // Read all the books as a List of String. Each item in the list
		 // represent a book node in the REST service Response
		 List<String> allBooks = jsonPathEvaluator.getList("books.title");
		 
		 // Iterate over the list and print individual book item
		 for(String book : allBooks)
		 {
		 System.out.println("Book: " + book);
		 }
		
		
	}

}
