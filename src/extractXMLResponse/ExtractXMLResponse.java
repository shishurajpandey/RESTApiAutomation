package extractXMLResponse;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.github.scribejava.apis.GitHubApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ExtractXMLResponse {

	
	@BeforeTest
	public void setup()
	{
		RestAssured.basePath="/maps/api";
		RestAssured.baseURI="https://maps.googleapis.com";
	}
	
	@Test
	public void ExtractXmlResponse()
	{
		Response response=
		given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyC6lwlP5X-syzIyxr5HXOXnylT5KGaIYx4")
	.when()
		.get("/distancematrix/xml")
	.then()
	.statusCode(200)
	.extract().response();
		
		String responseString= response.asString();
		System.out.println(responseString);
		String durationValue=response.path("DistanceMatrixResponse.row.element.duration.value");
		String distanceText=response.path("DistanceMatrixResponse.row.element.distance.text");
		System.out.println("Duration Value is "+ durationValue);
		System.out.println("Distance text is "+ distanceText);
		
	}
}
