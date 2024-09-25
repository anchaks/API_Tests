package requests;

import org.junit.jupiter.api.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAndVerifyHeaderInfo 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		RequestSpecification httpRequest=RestAssured.given();
		Response response =httpRequest.request(Method.GET,"BookStore/v1/Books");
		
		Headers headerResponse=response.getHeaders();
		System.out.println("Headers on response are:"+headerResponse);		
		
		int count =headerResponse.asList().size();
		System.out.println("Number of headers:"+count);
		//Verify header count
		Assertions.assertEquals(7,count);//will generate an assertion if count does not match with expected value
		
		//get particular header value
		String headerValue=response.getHeader("Content-Type");
		System.out.println("Particular header value:"+headerValue);
		
		//Verify header value. if okay, no error will be created in the console
		Assertions.assertEquals("application/json; charset=utf-8", headerValue);
	}

}
