import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class API {
    public static void main(String[] args) {
        // Set the base URI for REST Assured
        RestAssured.baseURI = "https://qa.koel.app/api/interaction/recently-played";

        // Create a request specification
        RequestSpecification httpRequest = given();

        // Define the endpoint for the GET request
        String endpoint = "api/interaction/play"; // Replace with your actual endpoint

        // Make a GET request and store the response
        Response response = httpRequest.get(endpoint);

        // Print the status code of the response
        System.out.println("Status Code: " + response.getStatusCode());

        // Assert the status code if you expect a specific one
        // assertEquals(200, response.getStatusCode());

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
