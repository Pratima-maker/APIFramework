package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import files.APIResources;
import files.Payloads;
import files.utils;
import pojo.EventManagement;
import pojo.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Then;




public class StepDefinitions extends utils{
	
	RequestSpecification reqlogin;  
	EventManagement response;
	String accessToken;
	String authResponse;
	Payloads data = new Payloads();

	@Given("Provide Email Id and Password")
	public void provide_email_id_and_password() throws IOException {
			
		 reqlogin = given().relaxedHTTPSValidation().spec(requestSpecification()).log().all().body(data.Login());
	}
	@When("User calls {string} API with post request")
	public void user_calls_api_with_post_request(String resource) {
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
	    response = reqlogin.when().post(resourceAPI.getResource()).then().log().all().extract().response().as(EventManagement.class);
		System.out.println(response.getToken());
	    accessToken = response.getToken();
	}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
		 authResponse = reqlogin.auth().oauth2(accessToken)
				.log().all().when().get("/api/auth/me").asString();
		System.out.println(authResponse);

	}
	@Then("Status in response body is OK")
	public void status_in_response_body_is_ok() {
		String list = reqlogin.log().all()
				.when().get("/api/events?category=Conference&city=Hyderabad&search=summit&page=1&limit=10").asString();
		System.out.println(list);
	}
}

