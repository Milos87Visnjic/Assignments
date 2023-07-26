package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.avantage.api.ApiDemo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static net.avantage.utils.Constants.PLAYER_ID;
import static net.avantage.utils.Constants.URL_API;
import org.junit.Assert;

public class ApiDemoStepDefs {
   ApiDemo apiDemo=new ApiDemo();

    @Given("Navigate to leagues URL")
    public void navigate_to_leagues_url() {
        apiDemo.navigateToBaseUrl();

    }

    @Given("Get leagues data")
    public void get_leagues_data() {
        apiDemo.getMethod();
    }

    @And("Get leagues data using hamcrest methods")
    public void getLeaguesDataUsingHamcrestMethods() {
        apiDemo.getMethodUsingHamcrestMatchers();
    }
}
