package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.TestPractice;
import net.avantage.utils.Driver;
import org.junit.Assert;

public class TestPracticeStepDefs {
    TestPractice testPractice = new TestPractice();

    @Given("User navigates to Test Practice actions page")
    public void user_navigates_to_test_practice_actions_page() {
        Driver.get().get("http://www.uitestpractice.com/Students/Actions");
    }

    @When("User clicks on first Click Me button")
    public void user_clicks_on_first_click_me_button() {
        testPractice.handleClickMeButton();
    }

    @Then("User handles the alerts pops up")
    public void user_handles_the_alerts_pops_up() {
        testPractice.handleAlertPopsUp("Clicked");
    }

    @When("User Double clicks on double click me button")
    public void userDoubleClicksOnDoubleClickMeButton() {
        testPractice.doubleClickOnDoubleClickMeButton();
    }

    @Then("User handles the alerts pops up after double click")
    public void userHandlesTheAlertsPopsUpAfterDoubleClick() {
        testPractice.handleAlertPopsUp("Double Clicked");
    }

    @When("User hover over third square")
    public void userHoverOverThirdSquare() {
        testPractice.hoverOverThirdSquare();
    }

    @Then("User validates the color changed")
    public void userValidatesTheColorChanged() {
        Assert.assertTrue(testPractice.thirdSquare.getAttribute("style").contains("128"));
    }

    @And("User handles selectable table")
    public void userHandlesSelectableTable() {
        testPractice.handleSelectableTable();
    }
}
