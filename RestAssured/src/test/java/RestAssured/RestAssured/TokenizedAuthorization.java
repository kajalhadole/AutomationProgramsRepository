package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class TokenizedAuthorization {
    @Test
	public void genrateToken() {
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger/";
		String postR= given().log().all().header("Conent-Type","application/json").body("{\r\n"
				+ "  \"userName\": \"kajal\",\r\n"
				+ "  \"password\": \"kajal1996\"\r\n"
				+ "}").when().post("/Account/v1/GenerateToken")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath J = new JsonPath(postR);
		String T = J.getString("token");
		System.out.println(T);
		
	}
}
