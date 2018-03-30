package twitterApisExample;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.*;
import io.restassured.response.*;
public class TwitterExtractResponseUsingJsonPath {

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
	public void TwitterPostRequest()
	{
	
	Response response=
	given()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
        .queryParam("status","First tweet using Rest Api and Oauth")
     .when()
         .post("update.json")
     .then()
         .statusCode(200)
         .extract().response();
	
	  /*  String id=response.path("id_str");
        System.out.println(id);*/
	
	String responseString=response.asString();
	System.out.println(responseString);
	
	JsonPath jspath=new JsonPath(responseString);
	System.out.println("The username is "+jspath.get("user.name"));
	System.out.println("The location is "+jspath.get("user.location"));
	
	}
	
}
