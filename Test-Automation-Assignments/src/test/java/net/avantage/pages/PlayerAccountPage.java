package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayerAccountPage extends LoginPage {

    @FindBy(xpath = "//p[contains(@class, 'account')]/span")
    public WebElement loginButton;

    @FindBy(xpath = "//button[contains(@class, 'account')]//span[contains(text(), 'Email')]")
    public WebElement emailButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//div")
    public WebElement avatarInitialsButton;

    @FindBy(xpath = "//div[text()='Player Account']")
    public WebElement playerAccountTab;

    @FindBy(xpath = "//h1[contains(@class,'account')]")

    public WebElement playerAccountName;

    @FindBy(xpath = "//p[text()='Player Profile']")
    public WebElement playerProfileButton;

    @FindBy(xpath = "//p[text()='Nafiseh Ghazimoradi']")
    public WebElement playerProfileName;


    @FindBy(xpath = "//button[@id='accountDropdownTab-tab-Player Account']")
    public WebElement playerAccountButton;

    @FindBy(xpath = "//p[text()='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath = "//p[text()='Edit Communications']")
    public WebElement editCommunicationButton;

    @FindBy(css = "input[name='marketingNotificationsAccepted']")
    public WebElement futureContestsCheckBox;

    @FindBy(name = "isMarketingNotificationsEmailActive")
    public WebElement emailCheckBox;

    @FindBy(name = "isMarketingNotificationsTextActive")
    public WebElement textCheckBox;

    @FindBy(css = "button img[alt='Feedback']")
    public WebElement feedBackIcon;

    @FindBy(css = "body > us-widget")
    public WebElement usWidget;

    /**
     * This method enables to click AvatrInitials button.
     */

    public void clickOnTheAvatar() {
        BrowserUtils.waitForClickablility(avatarInitialsButton, 15);
        avatarInitialsButton.click();
    }


    /**
     * This method enables to click PlayerProfile button.
     */

    public void PlayerProfileButton() {
        BrowserUtils.waitForClickablility(playerProfileButton, 5);
        playerProfileButton.click();
    }


    /**
     * This method enables to click Player Account Tab.
     */
    public void PlayerAccountTab() {
        BrowserUtils.waitForClickablility(playerAccountTab, 10);
        playerAccountTab.click();
    }

    public void logIn() {
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(ConfigurationReader.get("email"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    /**
     * This method enables to click avatar or userInitials
     */
    public void clickAvatar() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForPageToLoad(5);
        try {
            avatar.click();
        } catch (Exception e) {
            avatarInitials.click();
            e.printStackTrace();
        }
    }

    /**
     * This method enables to click Player Account Button
     */
    public void clickPlayerAccountButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(playerAccountButton, 5);
        playerAccountButton.click();
    }

    /**
     * This method enables to click settings button
     */
    public void clickSettingsButton() {
        BrowserUtils.waitForClickablility(settingsButton, 5);
        settingsButton.click();
    }

    /**
     * This method enables to click Edit Comm Button
     */
    public void clickEditCommButton() {
        BrowserUtils.waitForClickablility(editCommunicationButton, 5);
        editCommunicationButton.click();
    }

    /**
     * This method enables to select check box in Edit Comm
     */
    public void selectCheckBoxEditComm() {
        BrowserUtils.waitForElementToBeSelectable(futureContestsCheckBox, 5);
        if (!futureContestsCheckBox.isSelected()) {
            futureContestsCheckBox.click();
        }
        if (!emailCheckBox.isSelected()) {
            emailCheckBox.click();
        }
        if (!textCheckBox.isSelected()) {
            textCheckBox.click();
        }
    }

    public void validateCheckBoxes() {
        Assert.assertTrue(futureContestsCheckBox.isSelected());
        Assert.assertTrue(emailCheckBox.isSelected());
        Assert.assertTrue(textCheckBox.isSelected());
    }
    public static SearchContext expandShadowElement(WebElement element) {
        return (SearchContext) ((JavascriptExecutor) Driver.get()).executeScript("return arguments[0].shadowRoot", element);
    }
    public void getFedBackText() {

/*
//Not working
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        WebElement feedbackText= (WebElement) jse.executeScript("return document.querySelector('body > us-widget').shadowRoot.querySelector('#appRoot div > h1')");
        System.out.println(feedbackText.getText());

 */

        SearchContext shadowRoot= expandShadowElement(usWidget);
        WebElement feedBackText=shadowRoot.findElement(By.cssSelector("#appRoot div > h1"));
        System.out.println(feedBackText.getText());


/*
        SearchContext shadowRoot = usWidget.getShadowRoot();
        BrowserUtils.waitFor(1);
        WebElement feedBackText=shadowRoot.findElement(By.cssSelector("#appRoot div > h1"));
        System.out.println(feedBackText.getText());

 */
    }

    public void clickOnFeedBackButton(){
        BrowserUtils.waitFor(1);
        feedBackIcon.click();
        BrowserUtils.waitFor(2);
    }

    public void requestSupport() {
        String test = "NeoTech";
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        String str = "return document.querySelector('body > us-widget').shadowRoot.querySelector('#appRoot button:nth-child(1) span')";
        WebElement requestSupp = (WebElement) jse.executeScript(str);
        JavaScriptExecutorUtil.clickElementByJS(requestSupp);
        BrowserUtils.waitFor(2);
        WebElement yourRequest = (WebElement) jse.executeScript("return document.querySelector('body > us-widget').shadowRoot.querySelector('#request')");
        yourRequest.sendKeys(test);
        BrowserUtils.waitFor(2);
        WebElement yourFeedBack = (WebElement) jse.executeScript("return document.querySelector('body > us-widget').shadowRoot.querySelector('#comment')");
        yourFeedBack.sendKeys(test);
        WebElement submit = (WebElement) jse.executeScript("return document.querySelector('body > us-widget').shadowRoot.querySelector('#feedback button:nth-child(3) span')");
        JavaScriptExecutorUtil.clickElementByJS(submit);
    }
}

