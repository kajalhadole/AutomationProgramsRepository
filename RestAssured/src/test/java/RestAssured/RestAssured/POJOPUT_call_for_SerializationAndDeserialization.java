package RestAssured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
//import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class POJOPUT_call_for_SerializationAndDeserialization {

	@Test
	public void putRequest() {
	POJORequestbody Reqbody = new POJORequestbody();
	Reqbody.setName ("morpheus");
	Reqbody.setJob ("zion resident");
	
	RestAssured.baseURI="https://reqres.in/";
	POJOResponsebody Responsebody =given().log().all().header("Content-Type","application/json").body(Reqbody).expect().defaultParser(Parser.JSON)
	.when().get("/api/users/2")
	.then().log().all().assertThat().statusCode(200).body("job", equalTo("zion resident")).extract().response().as(POJOResponsebody.class);
	System.out.println("-----------------");
	System.out.println(Responsebody.getJob());
}
}