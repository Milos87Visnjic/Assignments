package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.DemoPage;
import net.avantage.pages.IndividualRankingsPage;
import net.avantage.pages.JavaScriptExecutorDemo;
import net.avantage.pages.LoginPage;
import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;
import org.junit.Assert;
import org.openqa.selenium.WindowType;

import java.io.IOException;

public class DemoStepDefs {
    DemoPage demoPage = new DemoPage();
    LoginPage loginPage = new LoginPage();

    IndividualRankingsPage individualRankingsPage = new IndividualRankingsPage();

    @Given("User navigates to Demo Page")
    public void user_navigates_to_demo_page() {
        demoPage.navigateToDemoPage();
    }

    @And("User scroll down to Sortable Data Tables")
    public void userScrollDownToSortableDataTables() {
        BrowserUtils.scrollToElement(demoPage.sortableDataTables);
    }

    @And("User click on Sortable Data Tables")
    public void userClickOnSortableDataTables() {
        demoPage.clickOnSortableDataTables();
    }

    @Then("User verifies Example One is displayed")
    public void userVerifiesExampleOneIsDisplayed() {
        Assert.assertTrue(demoPage.example1.isDisplayed());
    }

    @And("User verifies first table")
    public void userVerifiesFirstTable() {
        demoPage.validateTable();
    }

    @And("User verifies LastNames and FirstNames are in ascending order")
    public void userVerifiesLastNamesAndFirstNamesAreInAscendingOrder() {
        demoPage.validateAscendingOrder();
    }

    @And("User prints rows and column numbers")
    public void userPrintsRowsAndColumnNumbers() {
        demoPage.printRowsNumbers();
        demoPage.printColumnNumber();
    }

    @And("User prints second row and third column")
    public void userPrintsSecondRowAndThirdColumn() {
        demoPage.printSecondRow();
        demoPage.printThirdColumn();
    }

    @When("User log in {string} and {string}")
    public void userLogInAnd(String usernames, String password) {
        loginPage.loginWithParameters(usernames, password);
    }

    @Then("User verify {string}")
    public void userVerify(String avatar) {
        loginPage.verifyAvatar(avatar);
    }

    @And("User logs in with the parameters {string} and {string}")
    public void userLogsInWithTheParametersAndQW(String name, String pass) {
        loginPage.loginWithParameters(name, pass);
    }

    @And("User clicks on Individuals button in dropdown")
    public void userClicksOnIndividualsButtonInDropdown() {
        demoPage.clickIndividualInDropdownMenu();
    }

    @And("User clicks on Regions")
    public void userClicksOnRegions() {
        demoPage.clickOnRegionsButton();
    }

    @Given("User clicks on individual item on the menu")
    public void user_clicks_on_individual_item_on_the_menu() {
        demoPage.individualItemOnMenu.click();
    }

    @Given("User clicks on region button")
    public void user_clicks_on_region_button() {
        demoPage.regionsButton.click();
    }

    @Given("User clicks on top ranking button")
    public void user_clicks_on_top_ranking_button() {
        BrowserUtils.waitFor(2);
        demoPage.topRankingButton.click();
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs);
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs2);
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs3);
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String tiers) {
        demoPage.tiers(tiers).click();
    }

    @Then("verify that {string} are clicked")
    public void verify_that_are_clicked(String tiers) {
        Assert.assertTrue("aria-selected", true);
    }

    @And("User clicks on Regions button")
    public void userClicksOnRegionsButton() {
        demoPage.clickOnRegionsButton();
    }

    @And("User verifies that {string} is {string}")
    public void userVerifiesThatIs(String tier, String selected) {
        Assert.assertEquals(demoPage.tiers(tier).getAttribute("aria-selected"), selected);
        Assert.assertTrue(demoPage.tiers(tier).getAttribute("style").contains("rgb"));
    }
    @And("User clicks on {string} button in Hamburger Menu")
    public void userClicksOnButtonInHamburgerMenu(String leaguesName) {
        demoPage.clickLeaguesNameInHamburgerMenu(leaguesName);
    }
    @And("User verifies {string} in selectionBox")
    public void userVerifiesInSelectionBox(String leaguesName) {
        Assert.assertEquals(leaguesName, demoPage.selectionBoxVerify.getAttribute("value"));
    }
    @Given("user navigates to HeroKupappWindows url")
    public void user_navigates_to_hero_kupapp_windows_url() {
        Driver.get().get(ConfigurationReader.get("heroKuWindows_URL"));
    }

    @When("user clicks on Click Here")
    public void user_clicks_on_click_here() {
        BrowserUtils.waitForClickablility(demoPage.heroKuNewTabClickMe, 5);
        demoPage.heroKuNewTabClickMe.click();
    }

    @Then("Print current url")
    public void print_current_url() {
        demoPage.validateNewTabHerokuPage();
    }
    @When("user goes back to previos window and Click on Elemental Selenium")
    public void user_goes_back_to_previos_window_and_click_on_elemental_selenium() {
        demoPage.getBakToPreviousTab();
        demoPage.clickElementalSelenium();
    }
    @Then("Print current url for Elemental Selenium")
    public void print_current_url_for_elemental_selenium() {
    }
    @Then("user opens a new tab")
    public void user_opens_a_new_tab() {
        demoPage.openNewTabHeroku();
    }

    @When("user Navigates to elementalselenium page in that tab")
    public void userNavigatesToElementalseleniumPageInThatTab() {
        demoPage.navigaleToElementalSeleniumPage();
    }

    @Then("Print number of tabs that are opened")
    public void printNumberManyTabsAreOpenedAndCompareSecondAndThirdTabURLsIfTheyAreEqual() {
        demoPage.printNumberOfOpenTabs();
    }
    @And("Compare second and third tab URLs if they are equal")
    public void compareSecondAndThirdTabURLsIfTheyAreEqual() {
    }
    @Then("Navigate to the main window")
    public void navigate_to_the_main_window() {
        demoPage.navigateToMainWindow();
    }
    @Then("Print the header in the main window")
    public void print_the_header_in_the_main_window() {
    }
    @Given("User navigates to demo windows page")
    public void userNavigatesToDemoWindowsPage() {
        Driver.get().get("https://the-internet.herokuapp.com/windows");
    }

    @And("User clicks click here button")
    public void userClicksClickHereButton() {
        demoPage.clickOnClickHereButton();
    }

    @Then("User handles new tab")
    public void userHandlesNewTab() {
        demoPage.handleNewTab();
    }

    @When("User clicks on Elemental Selenium button")
    public void userClicksOnElementalSeleniumButton() {
        demoPage.clickOnElementalSeleniumButton();
    }

    @Then("User handles Elemental Selenium Tab")
    public void userHandlesElementalSeleniumTab() {
        demoPage.handleElementalSeleniumTab();
    }

    @And("User opens a new tab")
    public void userOpensANewTab() {
        Driver.get().switchTo().newWindow(WindowType.TAB);
    }

    @When("User Navigates to Elemental selenium page")
    public void userNavigatesToElementalSeleniumPage() {
        Driver.get().get("http://elementalselenium.com/");
    }

    @Then("User prints tab numbers")
    public void userPrintsTabNumbers() {
        demoPage.printActiveTabsNumbers();
    }

    @And("User compares tabs three and tabs four")
    public void userComparesTabsThreeAndTabsFour() {
        demoPage.handleOpenedNewTab();
        demoPage.validateTabsUrls();
    }
    @And("User prints main window header")
    public void userPrintsMainWindowHeader() {
        demoPage.printMainWindowHeader();
    }

    @Given("Navigate to herOku remove elements page")
    public void navigateToHerOkuRemoveElementsPage() {
        Driver.get().get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Given("print title using jse")
    public void print_title_using_jse() {
        System.out.println(JavaScriptExecutorUtil.getTitleByJS());
    }

    @And("draw border addRemove Element text")
    public void drawBorderAddRemoveElementText(){
        BrowserUtils.waitForClickablility(demoPage.addElementButton, 5);
        JavaScriptExecutorUtil.drawBorder(demoPage.addRemoveElementText);

    }

    @Given("flash the color of addElement")
    public void flash_the_color_of_add_element() {
        JavaScriptExecutorUtil.flash(demoPage.addElementButton, Driver.get());
    }

    @Given("take screenShot")
    public void take_screen_shot() throws IOException {
        JavaScriptExecutorUtil.takeScreenShot();
    }

    @Given("add alert")
    public void add_alert() {
        JavaScriptExecutorUtil.generateAlert("You added new element");
        BrowserUtils.waitFor(2);
    }
    @Given("Navigates to herOku app shadow dom page")
    public void navigates_to_her_oku_app_shadow_dom_page() {
        Driver.get().get("https://the-internet.herokuapp.com/shadowdom");
    }

    @Given("Get first shadow dom element")
    public void get_first_shadow_dom_element() {
        demoPage.handleShadowDom();
    }

}







