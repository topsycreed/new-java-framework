import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class ApiTests {
    @Test
    void createUser() {
        String baseUrl = "https://petstore.swagger.io/v2/";
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                    .baseUri(baseUrl)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(body).
                when()
                    .post("user")
                    .andReturn();
        response.body().prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkUserResponseBody() {
        String baseUrl = "https://petstore.swagger.io/v2/";
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        given()
                    .baseUri(baseUrl)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(body).
                when()
                    .post("user")
                .then()
                    .statusCode(200)
                    .body("code", equalTo(200))
                    .body("type", equalTo("unknown"))
                    .body("message", notNullValue(String.class));
    }
}
