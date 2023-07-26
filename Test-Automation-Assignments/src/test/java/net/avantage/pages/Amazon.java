package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

   /** public Amazon() {

        PageFactory.initElements(Driver.get(), this);

    @FindBy(css = "select#searchDropdownBox")
    public WebElement allDepartmentsDropDownMenu;

    @FindBy(css = "input#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = "select[name='s']")
    public WebElement sortByMenu;

    @FindBy(css = "input[data-action-type='DISMISS'][class='a-button-input']")
    public WebElement dontChangeButton;

    @FindBy(id = "nav-search-submit-button")
    public WebElement submitButton;

    @FindBy(css = "img[data-image-index='1']")
    public WebElement firstResult;

    @FindBy(css = "span[data-action='a-dropdown-button']")
    public WebElement selectAmount;

    @FindBy(css = "li[class='a-dropdown-item']")
    public List<WebElement>numbers;

    public void clickDontChangeButton(){
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForPageToLoad(5);
        dontChangeButton.click();
    }
    public void handleAllDepartmentsDropDownMenu() {
        BrowserUtils.waitFor(1);
        Select allDepartments = new Select(allDepartmentsDropDownMenu);
        List<WebElement> options = allDepartments.getOptions();
        System.out.println(options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        allDepartments.selectByVisibleText("Software");
    }

    public void typeValueInSearchItem(String item) {
        BrowserUtils.waitForClickablility(searchBox, 5);
        searchBox.sendKeys(item);
        submitButton.click();
    }

    public void selectSortBy() {
        BrowserUtils.waitFor(1);
        Select sortBy = new Select(sortByMenu);
        List<WebElement> options = sortBy.getOptions();
        System.out.println(options.size());
        options.get(2).click();
    }

    public void clickFirstResult(){
        BrowserUtils.waitForClickablility(firstResult,5);
        firstResult.click();
    }

    public void selectAmountOfItem(Integer value){
        BrowserUtils.waitForClickablility(selectAmount,5);
        selectAmount.click();
        numbers.get(value).click();
    }

}   **/
