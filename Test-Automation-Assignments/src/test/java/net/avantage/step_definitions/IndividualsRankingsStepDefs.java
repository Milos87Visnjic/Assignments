package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.IndividualRankingsPage;
import net.avantage.pages.LoginPage;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;

public class IndividualsRankingsStepDefs {
    IndividualRankingsPage individualRankingsPage = new IndividualRankingsPage();
    LoginPage loginPage = new LoginPage();

    @And("User clicks on the hamburger menu")
    public void userClicksOnTheHamburgerMenu() {
        individualRankingsPage.clickOnTheHamburgerMenu();
    }

    @When("User clicks on Individuals button in dropdown menu")
    public void userClicksOnIndividualsButtonInDropdownMenu() {
        individualRankingsPage.clickOnIndividualButtonInDropdownMenu();
    }

    @And("The user logs in")
    public void theUserLogsIn() {
        loginPage.logIn(ConfigurationReader.get("email"));
    }


    @And("User gets summary of IRS")
    public void userGetsSummaryOfIRS() {
        individualRankingsPage.getRankingsSummaryTableValues();
    }

    @When("User clicks on the arrow at the end of each row and verifies back button functioning")
    public void userClicksOnTheArrowAtTheEndOfEachRowAndVerifiesBackButtonFunctioning() {
        individualRankingsPage.verifyBackButtonFunction();
    }

    @Then("User views row numbers")
    public void userViewsRowNumbers() {
        individualRankingsPage.readRowNumbers();
        individualRankingsPage.readColumnsAndRows();
    }

    @And("User clicks on TopRankings button")
    public void userClicksOnTopRankingsButton() {
        individualRankingsPage.clickOnTopRankingsButton();
    }


}
