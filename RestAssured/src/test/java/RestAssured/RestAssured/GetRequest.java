package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class GetRequest {

	@Test
	
	public void getRequest() {
		
	RestAssured.baseURI = "https://reqres.in/";
	
	String  R = given().log().all().header("content-type","application/json").when().get("/api/users?page=2").
	then().log().all().assertThat().statusCode(200).body("page", equalTo(2)).extract().response().asString();
	System.out.println(R);
	
	JsonPath J = new JsonPath(R);
	String t = J.getString("total"); //see the console where "total: 12"
	System.out.println(t);
	
	String d = J.getString("data[0].id"); // see the console where below total we get  "data[0].id" 
	System.out.println(d);
	
	String firstName = J.getString("data[0].first_name"); // see the console where below total we get  "data[0].first_name" ----"Michael"
	System.out.println(firstName);
	
	String LastName = J.getString("data[4].last_name"); // see the console where below total we get  "data[1].id"------ "George"
	System.out.println(LastName);
	
	String d1 = J.getString("data[1].id"); // see the console where below total we get  "data[1].id"------ "Lindsay"
	System.out.println(d1);
	
	
}
}