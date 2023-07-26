package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.CPFrontEndPage;
import org.junit.Assert;

public class CPFrontEndPageStepDefs {

    CPFrontEndPage cpFrontEndPage = new CPFrontEndPage();

    @And("User clicks on Play for Fun Contests button in Hamburger menu")
    public void userClicksOnPlayForFunContestsButtonInHamburgerMenu() {
        cpFrontEndPage.clickPlayForFunContestsButton();
    }

    @Then("User verifies Play For Fun button is clicked")
    public void userVerifiesPlayForFunButtonIsClicked() {
        Assert.assertEquals(cpFrontEndPage.playForFunButton.getAttribute("aria-selected"), "true");
        Assert.assertTrue(cpFrontEndPage.playForFunButton.getAttribute("style").contains("rgb"));
    }

    @And("User clicks on Soonest Start selection box")
    public void userClicksOnSoonestStartSelectionBox() {
        cpFrontEndPage.clickSoonestStartSelectionBox();
    }

    @When("User clicks on Latest Start button")
    public void userClicksOnLatestStartButton() {
        cpFrontEndPage.clickLatestStartButton();
    }

    @Then("User verifies contests number in contests table")
    public void userVerifiesContestsNumberInContestsTable() {
        Assert.assertFalse(cpFrontEndPage.rowsOfContestsTable.isEmpty());
    }

    @When("User clicks on third contest")
    public void user_clicks_on_third_contest() {
        cpFrontEndPage.clickThirdContestPlayButton();

    }

    @Then("User verifies game dates")
    public void user_verifies_game_dates() {
        Assert.assertEquals(cpFrontEndPage.getDateOnPlayNowPage(), cpFrontEndPage.locateContestsTable(3, 1).getText());
        cpFrontEndPage.getContestsNumberInContestTable();
    }

    @When("User clicks on Most Players button")
    public void userClicksOnMostPlayersButton() {
        cpFrontEndPage.clickOnMostPlayersButton();
    }

    @When("User clicks on Fewest Players button")
    public void userClicksOnFewestPlayersButton() {
        cpFrontEndPage.clickOnFewestPlayers();
    }
}
