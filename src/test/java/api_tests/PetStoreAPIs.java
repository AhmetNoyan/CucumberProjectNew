package api_tests;

import static org.testng.Assert.assertEquals;

import org.junit.Assert.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PetStoreAPIs {

	String baseURL="https://petstore.swagger.io/v2";
	Response response;
	int petID=22112;
	
	@Test
	public void findPetByStatus() {
		String endPoint="/pet/findByStatus";
		given().contentType("application/json").
		accept(ContentType.JSON)
		.when().get(baseURL+endPoint+"?status=sold")
		.then().statusCode(200)
		.and().contentType("application/json");
	}
	
	@Test
	public void findPetByStatus_providingQueryParam() {
		// The test is directly calling to the end point with query parameter as a header 
		// and getting the response into a Response object, 
		// Then validating the status code and content type
		String endPoint="/pet/findByStatus";
		response=given().contentType("application/json").
		accept(ContentType.JSON)
		.queryParam("status", "sold")
		.when().get(baseURL+endPoint)
		.thenReturn();
		
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		assertEquals(response.contentType(), "application/json");
	}
	
	@Test
	public void findPetByID() {
		String endPoint="/pet/"+petID;
		
		
		response=given().contentType("application/json").
		accept(ContentType.JSON)
		.get(baseURL+endPoint)
		.thenReturn();
		
		
		assertEquals(response.statusCode(), 200);
		assertEquals(response.contentType(), "application/json");
		assertEquals(response.jsonPath().getInt("id"), petID);
		assertEquals(response.jsonPath().getInt("category.id"), 21);
		assertEquals(response.jsonPath().getString("category.name"), "Dog");
		assertEquals(response.jsonPath().getString("name"), "Mountain");
		assertEquals(response.jsonPath().getString("status"), "pending");
	}
}
