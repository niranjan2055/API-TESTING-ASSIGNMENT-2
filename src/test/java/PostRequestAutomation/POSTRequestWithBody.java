package PostRequestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POSTRequestWithBody {
    @Test
    void postRequestWithBody(){
        RestAssured.baseURI="https://reqres.in/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given().
                                                        when();

        //creating json body
        JSONObject payload = new JSONObject();
        payload.put("name","Niranjan");
        payload.put("address","Bangalore");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(payload.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST,"api/users");
        String responseBody = response.getBody().asString();
        System.out.println("The Received Response Body :\n"+responseBody);

        //Validating Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);

        //Validating User Creation
        Assert.assertTrue(responseBody.contains("createdAt"));

    }
}
