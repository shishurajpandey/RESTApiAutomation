package usefulTricks;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.*;
import io.restassured.response.*;
public class ResponseTimeCheck 

{
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
	public void readTweets()
	{
	
// long time = 
	given()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
	    .queryParam("screen_name","SHISHURAJ_123")
	    .queryParam("count", "2")
    .when()
        .get("user_timeline.json")
     
        //.time();    //Used to get response time of particular request, Here commented out to use timer as assertion in our test case.
	  //.timeIn(TimeUnit.SECONDS);
		
		//System.out.println(time);
    
		.then()
        .statusCode(200)
       // .time(lessThan(800L), TimeUnit.MILLISECONDS)    //Using response time as assertion. If response time will be less than 800 miliseconds then test case will be passed
        .time(lessThan(3L), TimeUnit.SECONDS)
        .body("user[0].name", equalTo("SHISHU RAJ PANDEY"))
	    .body("user.name", hasItem("SHISHU RAJ PANDEY") )
	    .body("user.screen_name", hasItem("SHISHURAJ_123"))
	    .body("user.name", hasItem("SHISHU RAJ PANDEY"));

	}
	
}
