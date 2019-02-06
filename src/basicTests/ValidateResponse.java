package basicTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


public class ValidateResponse {
	
	@BeforeMethod
	public void Setup()
	{
		RestAssured.baseURI= "https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
	}
	
	@Test
	public void statusCodeVerification()
	{
		System.out.println("Hello ");
	given()
	.contentType(ContentType.JSON)
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
	

