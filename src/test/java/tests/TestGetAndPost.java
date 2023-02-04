package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestGetAndPost {
	@Test(enabled = false)
	public void get() {
		baseURI = "https://reqres.in";
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[2].first_name",
				equalTo("Tobias"));
		given().get("https://reqres.in/api/users?page=2").then().body("data.first_name", hasItems("Lindsay", "George"));

	}

	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("Name", "Rakesh");
		request.put("Job", "Tester");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";
		given().header("Content-Type", "Application/json").contentType(ContentType.JSON).body(request.toJSONString())
				.when().post("/api/users").then().statusCode(201).log().all();

	}

	@Test
	public void post_1() {
		JSONObject request = new JSONObject();
		request.put("Name", "Chaitanya");
		request.put("Job", "Playing");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";

		given().header("Content-Type", "Application/json").body(request.toJSONString()).when().post("/api/users").then()
				.statusCode(201).log().all();
	}

}
