import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	void getEmployeeDetails(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, statusCode);
	}
}