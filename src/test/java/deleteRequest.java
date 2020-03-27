import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteRequest {
	
	@Test
	void deleteEmployee(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/delete";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.DELETE,"/22");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, statusCode);
        
        String status = response.jsonPath().get("status");
        Assert.assertEquals(status, "success");
        
        Assert.assertEquals(response.jsonPath().get("message"),"successfully! deleted Records");
	}

}
