package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.BooksPage;
import net.avantage.utils.Driver;

public class BooksStepDefs {
    BooksPage booksPage = new BooksPage();

    @Given("Navigate Books page")
    public void navigate_books_page() {
        Driver.get().get("https://books-pwakit.appspot.com/");
    }

    @Given("Input a book name in shadowDom")
    public void input_a_book_name_in_shadow_dom() {
        booksPage.typeAnItem();
    }

    @And("Click on item title")
    public void clickOnItemTitle() {
        booksPage.clickOnItemTitle();
    }

    @Then("Get item title in detail page")
    public void getItemTitleInDetailPage() {
        booksPage.getItemTitle();

    }

    @When("Click on preview button")
    public void click_on_preview_button() {
        booksPage.clickOnPreviewButton();
    }

    @Then("verify book preview is opened")
    public void verify_book_preview_is_opened() {
        booksPage.verifyBookViewer();
    }
}
