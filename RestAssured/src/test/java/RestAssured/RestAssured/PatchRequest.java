package RestAssured.RestAssured;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;
public class PatchRequest {

	@Test
	public void patchrequest() {
		RestAssured.baseURI="https://reqres.in";
	    String R = given().log().all().header("Content-Type","application/json").body("{\r\n"
	    		+ "    \"job\": \"zion resident\"\r\n"
	    		+ "}").when().patch("/api/users/2").then().log().all().assertThat().statusCode(202).body("job",equalTo("president"))
	            .extract().response().asString();
	     System.out.println(R);
	     
	}
}
