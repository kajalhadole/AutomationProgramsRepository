/**
 * 
 */
package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PutRequest {

	@Test
	public void putrequest() {
		
		RestAssured.baseURI ="https://reqres.in/";
		String putrequest = given().log().all().header("content-type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").when().put("/api/users/2").then().log().all().assertThat().statusCode(200).body("job", equalTo("zion resident"))
		   .extract().response().asString();
		System.out.println(putrequest);
		
		
		//optional not necessary
		JsonPath J = new JsonPath(putrequest);
		String JOB = J.getString("job"); //see the console where "job : zion resident"
		System.out.println(JOB);
	}
}
