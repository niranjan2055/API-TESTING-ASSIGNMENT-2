package GetRequestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.StringConcatFactory;

public class GETRequestWithQueryParameter {
    @Test
    void getRequestWithQueryParametersTest(){

        RestAssured.baseURI = "https://fakestoreapi.com/";

        RequestSpecification httpRequest = RestAssured.given().
                                                        when();

        //Sending Query to get the product list in descending order
        Response response = httpRequest.request(Method.GET,"products?sort=desc");

        String responseBody = response.getBody().asString();
        System.out.println("THE RESPONSE RECEIVED: \n"+responseBody);

        //Validating status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        //Validating Status line
        String statusline = response.getStatusLine();
        System.out.println(statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");


    }

}
