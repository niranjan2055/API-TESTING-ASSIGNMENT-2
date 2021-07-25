package GetRequestAutomation;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETRequestWithoutQueryParameter {

    @Test
    void GETRequestWithoutQueryParameterTest(){
       Response response =  given().
                            when().
                            get("https://fakestoreapi.com/products");
       int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode,200);
       System.out.println(response.body().asString());
    }
}
