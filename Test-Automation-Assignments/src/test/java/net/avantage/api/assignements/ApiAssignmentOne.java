package net.avantage.api.assignements;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ApiAssignmentOne {

        public void navigateToUSA(){
                RestAssured.baseURI="https://datausa.io";
        }

        public void getMethod(){
                Response response = given().get("/api/data?drilldowns=Nation&measures=Population");
                response.prettyPrint();
                String year = response.jsonPath().getString("data.Year[0]");
                String population = response.jsonPath().getString("data.Population[0]");
                System.out.println("In the year  " +  year  +  "  there was population of "  +  population +  " people");
                assertEquals(response.statusCode(),200);

        }

        public void getMethodHamcrest(){
                given().
                        log().all().pathParam("api","api").pathParam("method", "data")
                        .when()
                        .get("/{api}/{method}?drilldowns=Nation&measures=Population")
                                .then().log().all().assertThat().statusCode(200).body("data.'ID Nation[0]'", equalTo("01000US"));
        }

        public void getMethodJsonPath(){

                String json = given().
                        log().all().pathParam("api","api").pathParam("method","data")
                        .queryParam("drilldowns","Nation").queryParam("measures","Population")
                        .when()
                        .get("/{api}/{method}")
                        .then().log().all().assertThat().statusCode(200).body("data.'ID Nation[0]'", equalTo("01000US"))
                        .extract().asString();

                JsonPath jsonPath = new JsonPath(json);
                System.out.println("The population of the year " + jsonPath.getString("data.'ID Year[7]'" + " was " + jsonPath.getString("data.Population[7]")));
                System.out.println("source_description : "+jsonPath.getString("source.annotations.source_description[0]"));
        }



}



