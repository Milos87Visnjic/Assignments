package net.avantage.api.assignements;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ApiAssignementTwoAndThree {

    static int userId;
    public static void PostRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String postUrl = "/posts";

        Response response = given().header("Content-type", "application/json")
                .and().body(Payload.assignmentBody())
                .when().post(postUrl)
                .then().log().all().assertThat().statusCode(201).assertThat().body("userId", equalTo(5))
                .body("title", equalTo("Milan"))
                .body("body", equalTo("Is the Best")).body("id", equalTo(101))
                .header("Content-type", containsString("application/json")).extract().response();
        userId=response.jsonPath().getInt("userId");

        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().getInt("userId"), 5);
        assertEquals(response.jsonPath().getString("title"), "Milan");
    }

    public static void PutRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String putUrl = "/posts/"+userId;

        Faker faker = new Faker();
        String title = faker.name().firstName();
        String body = faker.chuckNorris().fact();

        String updateBody = "{\n" +
                "        \"title\": \""+title+"\",\n" +
                "        \"body\": \""+body+"\",\n" +
                "         \"userId\": "+userId+",\n" +
                "          \"id\": 5\n" +
                "}";

        Response response = given().header("Content-type", "application/json")
                .and().body(updateBody)
                .when().put(putUrl)
                .then().log().all().assertThat().statusCode(200).assertThat().body("userId", equalTo(userId))
                .body("title", equalTo(title))
                .body("body", equalTo(body)).body("id", equalTo(5))
                .header("Content-type", containsString("application/json")).extract().response();


        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("userId"), userId);
        assertEquals(response.jsonPath().getString("title"), title);
    }

}
