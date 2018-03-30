package basicTests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.PlacesAddModal;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestWithPOJO {
	
	
	/*{
		  "location": {
		    "lat": -33.8669710,
		    "lng": 151.1958750
		  },
		  "accuracy": 50,
		  "name": "Google Shoes!",
		  "phone_number": "(02) 9374 4000",
		  "address": "48 Pirrama Road, Pyrmont, NSW 2009, Australia",
		  "types": ["shoe_store"],
		  "website": "http://www.google.com.au/",
		  "language": "en-AU"
		}*/

	@BeforeTest
	public void setup()
	{
		RestAssured.basePath="/maps/api";
		RestAssured.baseURI="https://maps.googleapis.com";
	}

	@Test
	public void PostResponseDemoTest()
	{
		Map<String, Double> location=new HashMap<>();
		location.put("lat",-33.8669710);
		location.put("lng",151.1958750);
		
		
		List<String> types=new ArrayList<>();
		types.add("shoe_store");
		
		PlacesAddModal places=new PlacesAddModal();
		places.setLocation(location);
		places.setTypes(types);
		places.setName("Google Shoes!");
		places.setAccuray(50);
		places.setPhone_number("(02) 9374 4000");
		places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		places.setLanguage("en-AU");
		places.setWebsite("http://www.google.com.au/");
					
				
	given()
	   // .contentType(ContentType.JSON)
        .queryParam("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")
        .body(places)
     .when()
           .post("/place/add/json")
     .then()
           .statusCode(200)
     .and()
           .contentType(ContentType.JSON)
     .and()
           .body("scope", equalTo("APP"))
	 .and()
	       .body("status", equalTo("OK"));
}
}
