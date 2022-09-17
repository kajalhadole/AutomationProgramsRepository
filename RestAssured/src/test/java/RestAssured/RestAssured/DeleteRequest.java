/**
 * 
 */
package RestAssured.RestAssured;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeleteRequest {
	
	@Test
	public void deleterequest() {
		
		RestAssured.baseURI= "https://reqres.in";
		
		given().log().all().header("content-type","application/json")
		.when().delete("/api/users/2").then().log().all().assertThat().statusCode(204);
	}

}
