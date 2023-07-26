package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.avantage.api.assignements.ApiAssignementTwoAndThree;
import net.avantage.api.assignements.ApiAssignmentOne;

public class APIAssginementsStepDefs {

    ApiAssignmentOne apiAssignments = new ApiAssignmentOne();
    ApiAssignementTwoAndThree apiAssignementTwo = new ApiAssignementTwoAndThree();





    @Given("Navigate to USA population page")
    public void navigate_to_usa_population_page() {
       apiAssignments.navigateToUSA();
    }
    @And("Get population data info")
    public void get_population_data_info() {
       apiAssignments.getMethodJsonPath();
    }

    @Given("Make post Request")
    public void make_post_request() {
        apiAssignementTwo.PostRequest();


    }

    @Given("Make put request")
    public void make_put_request() {
        apiAssignementTwo.PutRequest();

    }



}
