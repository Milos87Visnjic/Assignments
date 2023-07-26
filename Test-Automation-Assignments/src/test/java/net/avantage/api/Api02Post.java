package net.avantage.api;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.request;
import java.util.HashMap;
import org.junit.Assert;
public class Api02Post {
    public void postUsingHashMap (){
   HashMap data= new HashMap();
   data.put("userId", 11);
   data.put("id", 101);
   data.put("title","Nafis-Title");
   data.put("body","Nafis-This is to test Post Request");
   given()
           .contentType("application/json")
           .body(data)
           .when()
           .post("https://jsonplaceholder.typicode.com/posts")
           .then()
           .statusCode(201)
           .body("userId", equalTo(11))
           .body("id",equalTo(101))
           .body("title", equalTo("Nafis-Title"))
           .body("body", equalTo("Nafis-This is to test Post Request"))
           .log().all();
   }
}
