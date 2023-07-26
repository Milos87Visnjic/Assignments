package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndividualRankingsPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, 'rankings/individual')]//p")
    public WebElement individualHamburgerMenu;

    @FindBy(xpath = "//button[@id='simple-tab-individuals']//div[text()='Individuals']")
    public WebElement individualsButton;

    @FindBy(xpath = "//nav//span[contains(text(),'Regions')]")
    public WebElement regionsButton;

    @FindBy(xpath = "//li//span[text()='Top Rankings']")
    public WebElement topRankingsButton;

    @FindBy(xpath = "(//img[@alt='warning-icon'])[1]")
    public WebElement toolTipInRegions;

    @FindBy(xpath = "//img[@alt='warning-icon']")
    public WebElement toolTipInTopRankings;



    @FindBy(xpath = "//span[text()='Back']")
    public WebElement backButton;



    /**
     * This method enables to make locators of Rankings' Summary Table dynamic.
     * @param rowNumber
     * @param columnNumber
     * @return
     */
    public WebElement getLocatorsRankingsSummary(int rowNumber, int columnNumber) {
        String xpath = "//table/tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    /**
     * This method enables to make locators of summary Heads dynamic.
     * @param columnNumber
     * @return
     */
    public WebElement getLocatorsSummaryHeads(int columnNumber) {
        String xpath = "//table/thead/tr/th[" + columnNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    /**
     * This method enables to make locator of the arrow at the end of each row dynamic.
     * @param rowNumber
     * @return
     */
    public WebElement getRightArrowAtTheEndOfEachRow(int rowNumber) {
        String xpath = "//tbody/tr[" + rowNumber + "]/td[4]";
        return Driver.get().findElement(By.xpath(xpath));
    }


    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement rows;

    public WebElement getRowsColumns(int rowNumber, int columnNumber){
        String xpath="//tbody/tr["+rowNumber+"]/td["+columnNumber+"]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public void readRowNumbers(){
        for (int i=1;i<=4;i++){
            System.out.println(getRowsColumns(i, 1).getText());
        }
    }

    public void readColumnsAndRows(){
        //row
        for (int i=1;i<=4;i++){
            for (int j=1;j<=3;j++){
                System.out.print(getRowsColumns(i, j).getText()+ "\t\t");
            }
            System.out.println();
        }
    }

    /**
     * This method enables to click the hamburger menu button.
     */
    public void clickOnTheHamburgerMenu() {
        BrowserUtils.waitForVisibility(avatar, 5);
        BrowserUtils.waitForClickablility(hamburgerMenu, 5);
        hamburgerMenu.click();
    }

    /**
     * This method enables to click individuals button in dropdown menu.
     */
    public void clickOnIndividualButtonInDropdownMenu() {
        BrowserUtils.waitForClickablility(individualHamburgerMenu, 15);
        individualHamburgerMenu.click();
    }


    /**
     * This method enables to get all values in RankingsSummaryTable and verify them.
     */
    public void getRankingsSummaryTableValues() {
        //getting HeadLines
        for (int i = 1; i <= 3; i++) {
            System.out.print(getLocatorsSummaryHeads(i).getText() + "\t\t");
            Assert.assertTrue(getLocatorsSummaryHeads(i).isDisplayed());
        }
        System.out.println();
        //getting row values
        for (int i = 1; i <= 4; i++) {
            //getting column values
            for (int j = 1; j <= 3; j++) {
                System.out.print(getLocatorsRankingsSummary(i, j).getText() + "\t\t");
                Assert.assertTrue(getLocatorsRankingsSummary(i, j).isDisplayed());
            }
            System.out.println();
        }
    }

    /**
     * This method enables to verify back button functionality
     */
    public void verifyBackButtonFunction() {
        for (int i = 1; i <= 4; i++) {
            getRightArrowAtTheEndOfEachRow(i).click();
            BrowserUtils.waitForClickablility(backButton, 5);
            backButton.click();
            System.out.println("****" + i + " Row is checking");
            getRankingsSummaryTableValues();
            System.out.println("****" + i + " Row is verified");
        }
    }

    /**
     * This method enables to click on TopRankings button.
     */
    public void clickOnTopRankingsButton() {
        BrowserUtils.waitForClickablility(topRankingsButton, 5);
        BrowserUtils.clickWithJS(topRankingsButton);
    }



}
