package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class ValidateResponeTime {

	@Test
	public void getvalidateResponseTime() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response R = given().log().all().header("Content-Type","application/json").when().get("/api/users/2");
		
		long Rtime = R.getTime();
		System.out.println(Rtime);
		ValidatableResponse val = R.then().log().all();
		val.statusCode(200);
		val.time(Matchers.lessThan(4000L));
	}
}
