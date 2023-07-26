package net.avantage.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DataUsaApi {

    public void navigateUsaPopulationPage() {
        RestAssured.baseURI = "https://datausa.io";
    }

    public void getUsaPopulationData() {
        Response response = given().get("/api/data?drilldowns=Nation&measures=Population");
        System.out.println("Population of 2020 : "+response.jsonPath().getString("data.Population[0]"));
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);

        System.out.println("**********************************\n");
    }

    public void getMethodUsingHamcrestMethods() {
        given().log().all().pathParam("api", "api").pathParam("source", "data")
                .when()
                .get("/{api}/{source}?drilldowns=Nation&measures=Population")
                .then().log().all().assertThat().statusCode(200).body("data.'ID Nation'[0]", equalTo("01000US"));
        System.out.println("**********************************\n");
    }

    public void getMethodUsingJsoPath() {
        String body = given().log().all().pathParam("api", "api").pathParam("source", "data")
                .queryParam("drilldowns","Nation").queryParam("measures","Population")
                .when()
                .get("/{api}/{source}")
                .then().log().all().assertThat().statusCode(200).body("data.'ID Nation'[0]", equalTo("01000US"))
                .extract().asString();

        JsonPath jsonPath=new JsonPath(body);
        System.out.println("Population of 2013 : "+jsonPath.getString("data.Population[7]"));
        System.out.println("source_description : "+jsonPath.getString("source.annotations.source_description[0]"));
    }

}
