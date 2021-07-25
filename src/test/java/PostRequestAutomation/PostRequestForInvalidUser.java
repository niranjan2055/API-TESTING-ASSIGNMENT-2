package PostRequestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRequestForInvalidUser {

    @Test
    void invalidUserPostRequestTest() {
        RestAssured.baseURI = "https://reqres.in/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given().
                                                        when();

        //creating json body
        JSONObject payload = new JSONObject();
        payload.put("email", "notregisteredmail@gmail.com");
        payload.put("password", "junktext");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(payload.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST, "api/login");
        String responseBody = response.getBody().asString();
        System.out.println("The Received Response Body :\n" + responseBody);

        //Validating Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);

        //Validating User Creation
        Assert.assertTrue(responseBody.contains("error"));
    }
}