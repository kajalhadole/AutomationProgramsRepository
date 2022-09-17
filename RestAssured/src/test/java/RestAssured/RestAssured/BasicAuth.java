package RestAssured.RestAssured;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
public class BasicAuth {
	
	@Test
	public void basicAuth() {
		
		RestAssured.baseURI="https://postman-echo.com/";
		
		given().log().all().header("content-type","application/json").auth().preemptive().basic("postman", "password")
		.when().get("/basic-auth")
		.then().log().all().assertThat().statusCode(200);
		
		//this is a basic authentication  that we required to write 1st before using any request like get, put ,patch ,etc
	}

}
