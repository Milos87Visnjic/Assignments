package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

// import net.avantage.pages.Amazon;

import net.avantage.utils.Driver;
/**
public class AmazonStepDefs {

    Amazon amazon = new Amazon();

    @Given("Navigate to {string}")
    public void navigate_to(String url) {
        Driver.get().get(url);
    }

    @Given("Type {string} in search menu")
    public void type_in_search_menu(String java) {
        amazon.typeValueInSearchItem(java);
    }

    @Given("Select sort by high to low")
    public void select_sort_by_high_to_low() {
        amazon.selectSortBy();
    }

    @Given("Handle all departments menu")
    public void handle_all_departments_menu() {
        amazon.handleAllDepartmentsDropDownMenu();
    }

    @Given("Click on first item")
    public void click_on_first_item() {
        amazon.clickFirstResult();
    }

    @And("Add {int} items to cart")
    public void addItemsToCart(int amount)  {
        amazon.selectAmountOfItem(amount-1);
    }

    @And("Click dont change button")
    public void clickDontChangeButton() {
        amazon.clickDontChangeButton();

    }
}
**/