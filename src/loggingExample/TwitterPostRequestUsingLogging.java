package loggingExample;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.*;
import io.restassured.response.*;
public class TwitterPostRequestUsingLogging {

	
	private String ConsumerKey="80I7jGouyDUzlkQ7lVEr8D4mm";
	
	private  String ConsumerSecret="h1dYoNvncAOJA657UYDqRV25LVUPJheEpPib3KzctPzm1VFNul";
	
	private String AccessToken="88117297-SKotOIhpQMcVmeHMMZcRgyU3raNXekz7KlPxkPfpx";
	
	private String TokenSecret="jIjeez4ZRbQ67N6mXtdfqWpxIootxjplw7FSMmYrC6uNh";


	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	
	}

	@Test
	public void TwitterPostRequestLogging()
	{
	given()
	    .log()
	  //.all()
	  //.body()
	 // .everything()
	 // .parameters()
	//  .headers()
	    .ifValidationFails()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
        .queryParam("status","Third tweet using Rest Api and Oauth")
     .when()
         .post("update.json")
     .then()
         .statusCode(203); //for failing the validation
        
	}
	
}
