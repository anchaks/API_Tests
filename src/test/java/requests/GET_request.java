package requests;

import org.junit.jupiter.api.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_request {

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response response =httpRequest.request(Method.GET,"BookStore/v1/Books");
		
		Response response = httpRequest.request(Method.GET,"BookStore/v1/Books/tomarjonye/tomuuu");//for assertion test case for wrong status code received in response
		
		int statusCode=response.getStatusCode();//return type int
		System.out.println("The status code is:"+statusCode);
		
		//GET RESPONSE BODY
		//String responseBody=response.getBody().asString(); 
		//String responseBody=response.getBody().prettyPrint();//this formats and prints the json body in a pretty format with indentation and new lines
		
		//Assertions.assertEquals(200, statusCode);//to verify if status codes match
	
		//System.out.println("Response body is:"+responseBody);
		
		

	}

}
