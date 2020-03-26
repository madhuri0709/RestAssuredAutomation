import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void CreateUser(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "TestA");
		requestParams.put("salary", "1000");
		requestParams.put("age", "25");
		httpRequest.header("content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/create");
		
		int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, statusCode);
        
        String status = response.jsonPath().get("status");
        Assert.assertEquals(status, "success");
        
        Map<String, String> user = response.jsonPath().getMap("data");
        System.out.println(user.get("name"));
        System.out.println(user.get("salary"));
        System.out.println(user.get("age"));
        
        Assert.assertEquals(requestParams.get("name"), user.get("name"));
        Assert.assertEquals(requestParams.get("salary"), user.get("salary"));
        Assert.assertEquals(requestParams.get("age"), user.get("age"));
	}

}