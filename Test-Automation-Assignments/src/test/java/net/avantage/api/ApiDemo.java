package net.avantage.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static net.avantage.utils.Constants.PLAYER_ID;
import static net.avantage.utils.Constants.URL_API;
import static org.hamcrest.Matchers.equalTo;

public class ApiDemo {

    public void navigateToBaseUrl(){
        RestAssured.baseURI = URL_API;
    }

    public void getMethod() {
        Response response = RestAssured.given().get("/qc/getLeaguePreferences/29617efe-e286-4f9c-a531-13c7d45cbfb0");
        response.prettyPrint();
        String playerId=response.jsonPath().getString("leaguePreferences.playerId");
        System.out.println("PlayerId : "+playerId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(playerId,PLAYER_ID);
    }

    public void getMethodUsingHamcrestMatchers() {  //BDD style

        //verify using statusCode(), body() and equalTo()
        given().
                accept("application/json").
                pathParam("environment", "qc").pathParam("method", "getLeaguePreferences").pathParam("playerId", PLAYER_ID)
                .when()
                .get("/{environment}/{method}/{playerId}")
                .then().log().all().assertThat().statusCode(200).body("leaguePreferences.playerId", equalTo(PLAYER_ID));

//Using JsonPath Method,
        String json = given().
                accept("application/json").
                pathParam("environment", "qc").pathParam("method", "getLeaguePreferences").pathParam("playerId", PLAYER_ID)
                .when()
                .get("/{environment}/{method}/{playerId}")
                .then().log().all().assertThat().statusCode(200).body("leaguePreferences.playerId", equalTo(PLAYER_ID))
                .extract().asString();

        JsonPath jsonPath = new JsonPath(json);
        System.out.println("PlayerId : " + jsonPath.getString("leaguePreferences.playerId"));
        System.out.println(jsonPath.getString("leaguePreferences.'Avantage Baccarat'.International.teamName"));


    }
}
