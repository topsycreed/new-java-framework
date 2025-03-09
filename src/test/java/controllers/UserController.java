package controllers;

import config.TestPropertiesConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserController {
    RequestSpecification requestSpecification;
    private static final String USER_ENDPOINT = "user";
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public UserController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(configProperties.getApiBaseUrl())
                .filter(new AllureRestAssured());
    }

    public Response createUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .post(USER_ENDPOINT)
                .andReturn();
    }

    public Response updateUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .put(USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }

    public Response getUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .get(USER_ENDPOINT + "/" + username)
                .andReturn();
    }

    public Response deleteUserByUsername(String username) {
        return given(this.requestSpecification)
                .when()
                .delete(USER_ENDPOINT + "/" + username)
                .andReturn();
    }
}
