package net.avantage.step_definitions;

import io.cucumber.java.en.Given;
import net.avantage.api.DataUsaApi;
import net.avantage.api.googleMapApi.AssignmentApi2;
import net.avantage.api.googleMapApi.MapApiDemo;

public class DataUsaStepDefs {

    DataUsaApi dataUsaApi = new DataUsaApi();

    @Given("Navigate to USA data page")
    public void navigate_to_usa_data_page() {
        dataUsaApi.navigateUsaPopulationPage();
    }

    @Given("Get population data")
    public void get_population_data() {
       /* dataUsaApi.getUsaPopulationData();
        dataUsaApi.getMethodUsingHamcrestMethods();
        dataUsaApi.getMethodUsingJsoPath();

        MapApiDemo.addNewPoint();
        MapApiDemo.changeAddress();
 */
        AssignmentApi2.makePostRequest();
        AssignmentApi2.makePutRequest();
    }
}
