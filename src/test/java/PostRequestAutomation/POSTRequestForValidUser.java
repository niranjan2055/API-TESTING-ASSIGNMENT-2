package PostRequestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POSTRequestForValidUser {

    @Test
    void validUserPostRequestTest(){

        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given()
                                                        .when();

        //RequestObject
        JSONObject payload = new JSONObject();
        payload.put("email","eve.holt@reqres.in");
        payload.put("password","cityslicka");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(payload.toJSONString());

        //ResponseObject
        Response response  = httpRequest.request(Method.POST,"api/login");
        String responseBody = response.getBody().asString();

        //Validating StatusCode
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println("TOKEN RECEIVED AS RESPONSE For Sucessfull Login\n"+responseBody);

    }
}
