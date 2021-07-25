package GetRequestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETRequest{

    @Test
    void getResponseWithOutQueryTest(){
        //The api endpoint
        RestAssured.baseURI="https://fakestoreapi.com/products";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given()
                                                        .when();

        //Response Object
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("THe response body is "+responseBody);

        //Verifiying the received status code of response
        int statusCode = response.getStatusCode();
        System.out.println("The Status Code is = "+statusCode);
        Assert.assertEquals(200,statusCode);
        System.out.println("Status Code is Correct");

        //Validating Status line
        System.out.println(response.statusLine());
        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");



    }

}
