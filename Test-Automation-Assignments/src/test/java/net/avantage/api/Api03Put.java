package net.avantage.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Api03Put {
    public void sendPutRequest() {
        String putEndpoint = "/posts/{postId}";
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        given()
                .contentType(ContentType.JSON)
                .body(Api03PutPayload.assignment3RequestBody())
                .pathParam("postId",1)
                .when()
                .put(putEndpoint)
                .then().statusCode(200).log().all();
    }
}
