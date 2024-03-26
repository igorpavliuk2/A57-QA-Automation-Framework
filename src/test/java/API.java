import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class API {
    public static void main(String[] args) {
        // Set the base URI for REST Assured
        baseURI = "https://qa.koel.app";
        String token = "236928|mc1OWojHQfcql1OFBYoe3Gd2BXPeHA3K0P8rqUuz";
        // Create a request specification
        System.out.println(given().header("Authorization", "bearer " + token).when().get("api/data").then().assertThat().statusCode(200));
        // Define the endpoint for the GET request
        String endpoint = "api/data"; // Replace with your actual endpoint

        // Make a GET request and store the response
       String response = baseURI;

        // Print the status code of the response
        //System.out.println("Status Code: " + response.getStatusCode());

        // Assert the status code if you expect a specific one
        // assertEquals(200, response.getStatusCode());

        // Print the response body
        //System.out.println("Response Body: " + response.getBody().asString());
    }
}
