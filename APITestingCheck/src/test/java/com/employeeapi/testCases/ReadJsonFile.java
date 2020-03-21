package com.employeeapi.testCases;

import java.io.FileInputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonFile {

	public static void main(String[] args) {

		
		try {
		    // create a reader
		   // Reader reader = Files.newBufferedReader(Paths.get("customer.json"));
            FileInputStream reader=new FileInputStream("customer.json");
		    //create ObjectMapper instance
		    ObjectMapper objectMapper = new ObjectMapper();
		    //read customer.json file into tree model
		    JsonNode parser = objectMapper.readTree(reader);

		    // read customer details
		    System.out.println(parser.path("id").asLong());
		    System.out.println(parser.path("name").asText());
		    System.out.println(parser.path("email").asText());
		    System.out.println(parser.path("age").asLong());

		    // read address
		    JsonNode address = parser.path("address");
		    System.out.println(address.path("street").asText());
		    System.out.println("===>  "+address.path("city").asText());
		    System.out.println(address.path("state").asText());
		    System.out.println(address.path("zipCode").asLong());
		    System.out.println("====> "+address.path("zipCode"));

		    // read payment method
		    for (JsonNode pm : parser.path("paymentMethods")) {
		        System.out.println(pm.asText());
		    }

		    // read projects
		    for (JsonNode project : parser.path("projects")) {
		        System.out.println(project.path("title").asText());
		        System.out.println(project.path("budget").asLong());
		    }

		    //close reader
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		
		
	}

}
