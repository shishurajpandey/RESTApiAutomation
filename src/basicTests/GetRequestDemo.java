package basicTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetRequestDemo {
	
	// https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4
	
	@BeforeClass
	public void Setup()
	{
		RestAssured.baseURI= "https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
		//RestAssured.DEFAULT_URI="https://maps.googleapis.com";
	}
	
	@Test(enabled=true)
	public void statusCodeVerification()
	{
	given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")		
	.when()
		.get("/distancematrix/json")
	.then()
		.statusCode(200);
	}
	
	@Test
	public void getResponseBody()
	{
	Response response=
	
	given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")		
	.when()
		.get("/distancematrix/json");
	
	System.out.println(response.asString());
	System.out.println(response.prettyPrint());
	}
	
	
}
