package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CPFrontEndPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(),'How to Play')]")
    public WebElement howToPlayButtonInHamburgerMenu;

    @FindBy(xpath = "//p[contains(text(),'Getting Started')]")
    public WebElement gettingStarted;

    @FindBy(css = "button#simple-tab-social")
    public WebElement playForFunButton;

    @FindBy(css = "button#simple-tab-RMG")
    public WebElement playForRealMoneyButton;

    @FindBy(xpath = "(//video[@id='video']/following-sibling::button)[6]")
    public WebElement videoButton;

    @FindBy(xpath = "//video[@id='video'][contains(@poster,'e7a33bf5e8')]")
    public WebElement video;

    @FindBy(xpath = "//p[text()='Play for Fun Contests']")
    public WebElement playForFunContestsInHamburgerMenu;

    @FindBy(xpath = "//div[@aria-haspopup='listbox'][text()='Soonest Start']")
    public WebElement soonestStartSelectionBox;

    @FindBy(css = "li[data-value='Latest Start']")
    public WebElement latestStart;

    @FindBy(css = "li[data-value='Most Players']")
    public WebElement mostPlayers;

    @FindBy(css = "li[data-value='Fewest Players']")
    public WebElement fewestPlayers;

    @FindBy(xpath = "//span[@id='simple-tabpanel-social']//table[@aria-label='Contests table']//tbody/tr/td[1]")
    public List<WebElement> rowsOfContestsTable;

    @FindBy(xpath = "//div/p[3]")
    public WebElement dateOnPlayNowPage;

    public WebElement locateContestsTable(int rowNumber, int columnNumber) {
        String xpath = "//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public void clickPlayForFunContestsButton() {
        BrowserUtils.waitForClickablility(playForFunContestsInHamburgerMenu, 5);
        playForFunContestsInHamburgerMenu.click();
    }

    public void clickSoonestStartSelectionBox() {
        BrowserUtils.waitForClickablility(soonestStartSelectionBox, 5);
        soonestStartSelectionBox.click();
    }

    public void clickLatestStartButton() {
        BrowserUtils.waitForClickablility(latestStart, 5);
        latestStart.click();
    }

    public void getContestsNumberInContestTable() {
        BrowserUtils.waitForPageToLoad(5);
        System.out.println("There are "+rowsOfContestsTable.size()+" contests available");
    }

    public void clickThirdContestPlayButton() {
        BrowserUtils.waitForPageToLoad(5);
        locateContestsTable(3, 3).click();
    }

    public String getDateOnPlayNowPage() {
        BrowserUtils.waitForVisibility(dateOnPlayNowPage, 5);
        String dateAssert = dateOnPlayNowPage.getText().substring(0, 12);
        return dateAssert;
    }

    public void clickOnMostPlayersButton(){
        BrowserUtils.waitForClickablility(mostPlayers,5);
        mostPlayers.click();
    }
    public void clickOnFewestPlayers(){
        BrowserUtils.waitForClickablility(fewestPlayers,5);
        fewestPlayers.click();
    }
}
