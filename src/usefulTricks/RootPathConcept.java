package usefulTricks;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.*;
import io.restassured.response.*;
public class RootPathConcept 

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
	given()
	    .auth()
	    .oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
	    .queryParam("screen_name","SHISHURAJ_123")
	    .queryParam("count", "2")
    .when()
        .get("user_timeline.json")
    .then()
        .statusCode(200)
        .body("user[0].name", equalTo("SHISHU RAJ PANDEY") )
        
        //Here adding root path as user it will be added in front of upcoming elements like name id and all
        .rootPath("user")
	    .body("name", hasItem("SHISHU RAJ PANDEY") )
	    .body("screen_name", hasItem("SHISHURAJ_123"))
	    .body("name", hasItem("SHISHU RAJ PANDEY"))
	    .rootPath("entities");
	    //.body("entities.hashtags[0].size()", equalTo(0));
//String responseString=response.asString("");
	}
	
}
