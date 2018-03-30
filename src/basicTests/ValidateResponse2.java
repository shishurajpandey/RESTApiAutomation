package basicTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.*;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse2 {
	
	
	@BeforeTest
	public void setup()
	{
		RestAssured.basePath="/maps/api";
		RestAssured.baseURI="https://maps.googleapis.com";
	}

	
	@Test
	public void ValidateResponse()
	{
    given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")		
	.when()
		.get("/distancematrix/json")
	.then()
	     .statusCode(200)
	.and()
	     .body("rows[0].elements[0].distance.text",equalTo("225 mi"))
	.and()     
	     .contentType(ContentType.JSON);
	
		
	}
}
