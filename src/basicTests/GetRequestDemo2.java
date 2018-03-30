package basicTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestDemo2 {
		
	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
		
		//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4
}

	
	@Test(enabled=false)
	public void GetResponseTest()
	{
		given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")
		.when()
		.get("/distancematrix/json")
		.then()
		.statusCode(208);
	}
	
	@Test 
	public void GetResponseBody()
	{
		Response response=
	given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")
	.when()
		.get("/distancematrix/json");
		
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().prettyPrint());
		
	}

	
	
}
