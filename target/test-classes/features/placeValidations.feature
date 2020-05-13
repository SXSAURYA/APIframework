Feature: Validation Place API's 

@AddPlace @Regression
Scenario Outline: Verify if Place is being successfully Added using AddPlaceAPI 
	Given Add Place Payload with "<name>" ,"<language>" "<address>" 
	When user calls "AddPlaceAPI" with "Post" request 
	Then the API call is success with status code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify place_Id created maps to "<name>" using "GetPlaceAPI"
	
	Examples: 
		| name          | language | address          |
		| Roger Faderer | English  | Word cross center|
#		|James Anderson | Spanish  | WBA House        |
#		| Jim Carry     | Japanise | Cacatium         |


@DeletePlace
Scenario: Verify if delete place functioanlity is working 
	Given Delete place payload 
	When user calls "DeletePlaceAPI" with "Post" request 
	Then the API call is success with status code 200 
	And "status" in response body is "OK" 