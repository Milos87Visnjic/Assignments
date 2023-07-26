package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.GuruPage;
import net.avantage.utils.Driver;

public class GuruStepDefs {

    GuruPage guruPage = new GuruPage();

    @Given("User navigates to Guru Drag and Drop Page")
    public void userNavigatesToGuruDragAndDropPage() {
        Driver.get().get("https://demo.guru99.com/test/drag_drop.html");
    }

    @When("User moves bank to Debit Side Account")
    public void user_moves_bank_to_debit_side_account() {
        guruPage.moveElement(guruPage.bankButton, guruPage.accountPlaceHolderDebitSide);
    }

    @Then("User validate the message in the Account placeholder")
    public void user_validate_the_message_in_the_account_placeholder() {
        guruPage.validateMovedElement(guruPage.accountPlaceHolderDebitSide,guruPage.bankButton);
    }

    @When("User moves an amount to Debit side amount placeholder")
    public void user_moves_an_amount_to_debit_side_amount_placeholder() {
        guruPage.moveElement(guruPage.first5000, guruPage.amountPlaceHolderDebitSide);
    }

    @Then("User validate Debit side amount place holder")
    public void user_validate_debit_side_amount_place_holder() {
        guruPage.validateMovedElement(guruPage.amountPlaceHolderDebitSide,guruPage.first5000);
    }

    @When("User moves sales to Credit side Account placeholder")
    public void user_moves_sales_to_credit_side_account_placeholder() {
        guruPage.moveElement(guruPage.salesButton, guruPage.accountPlaceHolderCreditSide);
    }

    @Then("User validates credit side account placeholder")
    public void user_validates_credit_side_account_placeholder() {
        guruPage.validateMovedElement(guruPage.accountPlaceHolderCreditSide,guruPage.salesButton);
    }

    @When("User moves an amount to credit side amount placeholder")
    public void user_moves_an_amount_to_credit_side_amount_placeholder() {
        guruPage.moveElement(guruPage.second5000, guruPage.amountPlaceHolderCreditSide);
    }

    @When("User validates credit side amount placeholder")
    public void user_validates_credit_side_amount_placeholder() {
        guruPage.validateMovedElement(guruPage.amountPlaceHolderCreditSide,guruPage.second5000);
    }


    @And("User prints result table")
    public void userPrintsResultTable() {
        guruPage.printResultTable();
    }

    @And("User verifies perfect message")
    public void userVerifiesPerfectMessage() {
        guruPage.verifyPerfectMessage();
    }
}
