package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TestLocalAPI {

	@Test(enabled = false)
	public void get() {
		baseURI = "http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();
	}

	@Test(enabled = false)
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Raghu");
		request.put("lastName", "G K");
		request.put("subjectID", "2");

		baseURI = "http://localhost:3000/";
		given().accept(ContentType.JSON).header("Content-Type", "Application/json").body(request.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();

		JSONObject request1 = new JSONObject();
		request1.put("firstName", "Shivanna ");
		request1.put("lastName", "R");
		request1.put("subjectID", "2");

		given().accept(ContentType.JSON).header("Content-Type", "Application/json").body(request1.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();
	}

	@Test(enabled = false)
	public void put() {
		JSONObject request1 = new JSONObject();
		request1.put("firstName", "Shivanna ");
		request1.put("lastName", "N Rangappa");
		request1.put("subjectID", "3");
		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "Application/json").accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(request1.toJSONString()).when().put("/users/4").then().statusCode(200).log().all();

//		given().get("http://localhost:3000/users").then().statusCode(200).body("users[3].id", equalTo(4));

	}

	@Test
	public void delete() {
		baseURI = "http://localhost:3000/";
		when().delete("/users/4").then().statusCode(200);
	}

}
