package specs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public class RequestSpecificationDemo 

{
	private String ConsumerKey="80I7jGouyDUzlkQ7lVEr8D4mm";
	private  String ConsumerSecret="h1dYoNvncAOJA657UYDqRV25LVUPJheEpPib3KzctPzm1VFNul";
	private String AccessToken="88117297-SKotOIhpQMcVmeHMMZcRgyU3raNXekz7KlPxkPfpx";
	private String TokenSecret="jIjeez4ZRbQ67N6mXtdfqWpxIootxjplw7FSMmYrC6uNh";
    RequestSpecBuilder requestBuilder;
    static RequestSpecification requestSpec;


	@BeforeTest
	public void setup()
	
	{
	/*	RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";*/
	
	requestBuilder=new RequestSpecBuilder();
	requestBuilder.setBasePath("/1.1/statuses");
	requestBuilder.setBaseUri("https://api.twitter.com");
	requestBuilder.addQueryParam("screen_name","SHISHURAJ_123");
	requestBuilder.addQueryParam("count", "2");
	
	AuthenticationScheme authScheme= RestAssured.oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret);
	
	requestBuilder.setAuth(authScheme);
	
	requestSpec=requestBuilder.build();
	
	}

	
	@Test
	public void readTweets()
	{

	given()
          .spec(requestSpec)	   
    .when()
        .get("user_timeline.json")
		.then()
        .statusCode(200);
       

	}
	
}
