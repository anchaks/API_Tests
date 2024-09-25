package requests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat; // For assertion
import static org.hamcrest.Matchers.hasItem;         // For hasItem matcher

import org.junit.jupiter.api.Assertions;

public class GetBookData 
{

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/";
		RequestSpecification httpRequest=RestAssured.given();
		Response response =httpRequest.request(Method.GET,"BookStore/v1/Books");
		
		//GET RESPONSE BODY
		//String responseBody=response.getBody().asString(); 
		// Pretty print the response body
        String prettyResponseBody = response.getBody().prettyPrint();
		
		//create Jsonpath object from the response body and extract data from the response using Jsonpath
		JsonPath jsonPath=response.jsonPath();
		String expectedBookTitle="Git Pocket Guide";
		
		/*using assertThat, we can assert that a specific value exists in the list of values in the response body
		hasItem(expectedBookTitle) checks if the list contains the specified book title*/
		
		assertThat("Given book title should be there",jsonPath.getList("books.title"),hasItem(expectedBookTitle));
		//assertThat("Given book title is not present",jsonPath.getList("books.title"),hasItem("Java LEarnings"));//fail test case
		
		//We can also assertions to check if a value exists in the list or not
		//Assertions.assertTrue(prettyResponseBody.contains("xyz"));
	}

}
