import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutREquest {
	
	@Test
	public void updateEmployeeDetails(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/update";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "TestA");
		requestParams.put("salary", "1500");
		requestParams.put("age", "25");
		httpRequest.header("content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.PUT,"/19");
		
		int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, statusCode);
        
        String status = response.jsonPath().get("status");
        Assert.assertEquals(status, "success");
	}

}
