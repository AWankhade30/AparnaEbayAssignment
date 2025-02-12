package APIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class APIAssignment {

	@Test 
	public void validateBPIResponse() {
		
		//Define the API endpoint
		String URL = "api.coindesk.com/v1/bpi/currentprice.json,";
		
		//send get request and get response
		Response response= RestAssured.get(URL);
		
		//Convert response to json path
		JsonPath jsonPath=response.jsonPath();
		
		//Extract the BPI data 
		String usd = jsonPath.getString("bpi.USD.code");
		String gbp = jsonPath.getString("bpi.GBP.code");
		String eur = jsonPath.getString("bpi.EUR.code");
		
		String gbpDescription = jsonPath.getString("bpi.GBP.description");
		
		//Assertion/ validate the response
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(usd, "USD");
		Assert.assertEquals(gbp, "GBP");
		Assert.assertEquals(eur, "EUR");
		
		Assert.assertEquals(gbpDescription, "British Pound Sterling");
		
		System.out.println("API Response:"+response.prettyPrint());
		
		
		
		
	}
}
