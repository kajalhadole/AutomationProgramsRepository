package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class PostRequest {

	@Test
	
	public void postRequest() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		String postrequest = given().log().all().header("content-type","application/json").body("{\r\n" //
				+ "    \"name\": \"morpheus\",\r\n"                                                     //  main code if interviewer ask 
				+ "    \"job\": \"leader\"\r\n"                                                         //  then write only this
				+ "}").when().post("/api/users").then().log().all().assertThat().statusCode(201)        //
		.body("name", equalTo("morpheus")).extract().response().asString();                             //
		System.out.println(postrequest);                                                                //
	
		//optional thing 
		JsonPath J = new JsonPath(postrequest);
		String JOB = J.getString("job"); //see the console where "job : leader"
		System.out.println(JOB);
		
	
}
}