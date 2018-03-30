package basicTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.*;
import io.restassured.response.*;
public class PostResponseDemo {


	@BeforeTest
	public void setup()
	{
		RestAssured.basePath="/maps/api";
		RestAssured.baseURI="https://maps.googleapis.com";
	}

	@Test
	public void PostResponseDemoTest()
	{
	given()
        .queryParam("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4 HTTP/1.1")
        .body("\r\n" + 
        		"{\r\n" + 
        		"  \"location\": {\r\n" + 
        		"    \"lat\": -33.8669710,\r\n" + 
        		"    \"lng\": 151.1958750\r\n" + 
        		"  },\r\n" + 
        		"  \"accuracy\": 50,\r\n" + 
        		"  \"name\": \"Google Shoes!\",\r\n" + 
        		"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
        		"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
        		"  \"types\": [\"shoe_store\"],\r\n" + 
        		"  \"website\": \"http://www.google.com.au/\",\r\n" + 
        		"  \"language\": \"en-AU\"\r\n" + 
        		"}\r\n" + 
        		"      ")
     .when()
           .post("/place/add/json")
     .then()
           .statusCode(200)
     .and()
           .contentType(ContentType.JSON);
        
	}
	
}
