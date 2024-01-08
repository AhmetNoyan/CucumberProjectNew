package api_tests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.junit.Assert.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.BrowserUtilities;

import static io.restassured.RestAssured.*;

public class PetStoreAPIs {

	BrowserUtilities utils=new BrowserUtilities();
	String baseURL="https://petstore.swagger.io/v2";
	Response response;
	int petID=22112;
	int petId;
	
	@Test
	public void createApet_with_JSON_File() {
		String endpoint="/pet";
		 petId=111+utils.randomNumber();
		
		File requestBody=new File("./src/test/resources/json_files/createApet.json");
		response=given().contentType("application/json")
		.accept(ContentType.JSON)
		.body(requestBody)
		.when()
		.post(baseURL+endpoint)
		.thenReturn();
		
		petId = response.jsonPath().getInt("id");
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		assertEquals(response.jsonPath().getInt("id"), petId);
		
		System.out.println(response.path("name").toString());
		System.out.println(response.path("category.name").toString());
		System.out.println(response.jsonPath().get("id").toString());
		System.out.println(response.jsonPath().get("status").toString());
		System.out.println(response.jsonPath().get("tags[0].name").toString());
		
	}
	@Test
	public void createApet() {
		String endpoint="/pet";
		 petId=111+utils.randomNumber();
		String requestBody="{\n"
				+ "  \"id\": "+petId+",\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 21,\n"
				+ "    \"name\": \"Dog\"\n"
				+ "  },\n"
				+ "  \"name\": \"Mountain\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 21999,\n"
				+ "      \"name\": \"M_21999\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"pending\"\n"
				+ "}";
		
		response=given().contentType("application/json")
		.accept(ContentType.JSON)
		.body(requestBody)
		.when()
		.post(baseURL+endpoint)
		.thenReturn();
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json");
		assertEquals(response.jsonPath().getInt("id"), petId);
		
		System.out.println(response.path("name").toString());
		System.out.println(response.path("category.name").toString());
		System.out.println(response.jsonPath().get("id").toString());
		System.out.println(response.jsonPath().get("status").toString());
		System.out.println(response.jsonPath().get("tags[0].name").toString());
		
	}
	
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
