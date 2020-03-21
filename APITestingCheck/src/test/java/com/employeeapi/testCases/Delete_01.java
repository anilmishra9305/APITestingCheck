package com.employeeapi.testCases;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

public class Delete_01 {
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException {

    	
    		
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                "delete_01.json"));

        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;

            String strName = (String) person.get("name");
            System.out.println("Name::::" + strName);

            String strCity = (String) person.get("city");
            System.out.println("City::::" + strCity);

            JSONArray arrays = (JSONArray) person.get("cars");
            for (Object object : arrays) {
                System.out.println("cars::::" + object);
            }
            String strJob = (String) person.get("job");
            System.out.println("Job::::" + strJob);
            System.out.println();

        }

    }
}

