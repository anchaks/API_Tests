package requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTime
{
	public static void main(String args[])
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		RequestSpecification httpRequest=RestAssured.given();
		Response response =httpRequest.request(Method.GET,"BookStore/v1/Books");
		
		double apiTime=response.getTime();
		System.out.println("the time for athe API to function:"+apiTime+"ms");
	}

}
