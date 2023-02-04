package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidation {
	@Test
	public void schemaTest() {

		baseURI = "https://reqres.in";

		given().get("/api/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("Schema.json"))
				.statusCode(200);

	}
}
