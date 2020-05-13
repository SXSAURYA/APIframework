package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} ,{string} {string}")
	public void add_Place_Payload_with(String name, String lng, String add) throws IOException {
		req = given().spec(requestSpecification()).body(data.addPlacePayload(name,lng,add));
	}

	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   req= given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	   System.out.println("delete place is working fine");
	}

	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete action
		res = new ResponseSpecBuilder().expectStatusCode(200).build();
		if (method.equalsIgnoreCase("post")) {
			response = req.when().post(APIResources.valueOf(resource).getResource()).then().spec(res).log().all().extract().response();	
		}else if (method.equalsIgnoreCase("put")) {
			response = req.when().put(APIResources.valueOf(resource).getResource()).then().spec(res).log().all().extract().response();
		}else if (method.equalsIgnoreCase("delete")) {
			response = req.when().delete(APIResources.valueOf(resource).getResource()).then().spec(res).log().all().extract().response();
		}else {
			response = req.when().get(APIResources.valueOf(resource).getResource()).then().spec(res).log().all().extract().response();
		}
	}

	@Then("the API call is success with status code {int}")
	public void the_API_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(int1.intValue(), response.getStatusCode());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals("Expected key "+string+" value "+string2+" is not equals to actuals "+response.jsonPath().getString(string), string2, response.jsonPath().getString(string));
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String name, String resource) throws IOException {
		place_id = response.jsonPath().getString("place_id");
	    req = given().spec(requestSpecification()).queryParam("place_id", place_id);
	    user_calls_with_request(resource, "GET");
	    assertEquals(name, response.jsonPath().get("name"));
	    
	}

}
