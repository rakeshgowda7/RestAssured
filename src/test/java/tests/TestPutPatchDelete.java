package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestPutPatchDelete {

	@Test
	public void put() {

		JSONObject request = new JSONObject();
		request.put("Name", "Rakesh");
		request.put("Job", "Automation Engineer");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";

		given().header("Content-Type", "Application/json").contentType(ContentType.JSON).body(request.toJSONString())
				.when().put("api/users/2").then().statusCode(200).log().all();

	}

	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("Name", "Rakesh");
		request.put("Job", "SDET");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";

		given().header("Content-Type", "Application/json").contentType(ContentType.JSON).body(request.toJSONString())
				.when().patch("api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void delete() {
		JSONObject request = new JSONObject();

		baseURI = "https://reqres.in";

		when().delete("api/users/2").then().statusCode(204).log().all();
	}
	

}
