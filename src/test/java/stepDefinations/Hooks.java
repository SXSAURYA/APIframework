package stepDefinations;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	StepDefination step = new StepDefination();

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
       //Create Place id in case of place id is null
		if (StepDefination.place_id == null) {
			step.add_Place_Payload_with("James Paul", "malyalam", "Dallas");
			step.user_calls_with_request("AddPlaceAPI", "Post");
			step.verify_place_Id_created_maps_to_using("James Paul", "GetPlaceAPI");
		}
	}

	@After("@DeletePlace")
	public void afterScenario() {

	}
}
