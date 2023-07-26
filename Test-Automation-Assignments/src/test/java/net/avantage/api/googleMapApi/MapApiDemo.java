package net.avantage.api.googleMapApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MapApiDemo {
    static String place_id;

    public static void addNewPoint() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String body = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"My house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(body).
                when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200)
                .body("status", equalTo("OK")).header("Content-Type", "application/json;charset=UTF-8")
                .extract().response();

        Response response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.requestBody()).
                when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200)
                .body("status", equalTo("OK")).header("Content-Type", "application/json;charset=UTF-8")
                .extract().response();
        place_id = response.jsonPath().getString("place_id");
        response.prettyPrint();

    }

    public static void changeAddress() {

        given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .and().body(Payload.updateBody(place_id))
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));
    }
}
