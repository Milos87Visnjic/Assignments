package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DemoQaPage extends BasePage {
    @FindBy(className = "text-success")
    public WebElement confirmResultText;

    @FindBy(id = "promptResult")
    public WebElement promptResultText;

    @FindBy(css = "button#tabButton")
    public WebElement newTabButton;

    @FindBy(css = "button#windowButton")
    public WebElement newWindowButton;

    @FindBy(css = "button#messageWindowButton")
    public WebElement newWindowMessageButton;

    @FindBy(className = "main-header")
    public WebElement headerBrowserWindowsPage;

    @FindBy(css = "div#draggable")
    public WebElement dragMe;

    @FindBy(css = "div#draggable~div")
    public WebElement dropHere;

    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickMeButton;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickMeButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;


    public WebElement clickMeButton(String name) {
        String css = "button#" + name + "Button";
        return Driver.get().findElement(By.cssSelector(css));
    }

    public void clickClickMe(String alertName) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(clickMeButton(alertName), 5);
        clickMeButton(alertName).click();
    }

    public void handleAlerts() {
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void handleTimerAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void handleConfirmAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(confirmResultText.getText());
    }

    public void handlePromptAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("NeoTech");
        alert.accept();
        System.out.println(promptResultText.getText());
    }

    public void clickOnNewTabButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(newTabButton, 5);
        newTabButton.click();
    }

    public void clickOnNewWindowButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(newWindowButton, 5);
        newWindowButton.click();
    }

    public void clickOnNewWindowMessageButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(newWindowMessageButton, 5);
        newWindowMessageButton.click();
    }

    public void validateNewTab() {
        ArrayList<String> windowTab = new ArrayList<>(Driver.get().getWindowHandles());
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().window(windowTab.get(1));
        System.out.println("New TAb URL : " + Driver.get().getCurrentUrl());
        System.out.println("Title : " + Driver.get().getTitle());
        Driver.get().switchTo().window(windowTab.get(0));

    }

    public void validateNewWindow() {
        ArrayList<String> windowTab = new ArrayList<>(Driver.get().getWindowHandles());
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().window(windowTab.get(2));
        System.out.println("New Window URL : " + Driver.get().getCurrentUrl());
        System.out.println(windowTab.size());
        System.out.println(Driver.get().getWindowHandles().size());
        Driver.get().close();
        Driver.get().switchTo().window(windowTab.get(0));
        System.out.println("Main Windows Page Header : " + headerBrowserWindowsPage.getText());
    }

    public void navigateToGamePortalOnNewTab() {
        ArrayList<String> windowTab = new ArrayList<>(Driver.get().getWindowHandles());
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().window(windowTab.get(2));
        Driver.get().get("https://qc-game-portal-client-tf-client-b2c.dev.avantagegames.com/");
    }

    public void usingSetHandlingNewTab() {
        BrowserUtils.waitFor(2);
        String parentTab=Driver.get().getWindowHandle();
        Set<String>tabs=Driver.get().getWindowHandles();
        Iterator<String>iterator=tabs.iterator();
        while (iterator.hasNext()) {
            String newTab = iterator.next();
            if(!parentTab.equals(newTab)){
                Driver.get().switchTo().window(newTab);
                System.out.println(Driver.get().getCurrentUrl());
            }
        }
        Driver.get().switchTo().window(parentTab);
    }

    public void navigateToGamePortalUsingSet() {
        BrowserUtils.waitFor(2);
        Set<String> tabs = Driver.get().getWindowHandles();
        System.out.println(tabs.size());
        System.out.println(Driver.get().getWindowHandles().size());
        //loop through each window
        for (String tab : tabs) {
            //one by one change it
            Driver.get().switchTo().window(tab);
            System.out.println(Driver.get().getCurrentUrl());
            System.out.println("Current Tab : "+tab);
            if (Driver.get().getCurrentUrl().contains("about:blank")) {
                BrowserUtils.waitFor(2);
                Driver.get().get("https://qc-game-portal-client-tf-client-b2c.dev.avantagegames.com/");
                break;
            }
        }
    }
    public void dragAndDrop() {
        Actions actions = new Actions(Driver.get());
        BrowserUtils.waitForPageToLoad(5);
        //actions.clickAndHold(dragMe).moveToElement(dropHere).release().build().perform();
        actions.dragAndDrop(dragMe, dropHere).perform();
    }

    public void verifyDropHereTextChanged() {
        BrowserUtils.waitFor(1);
        System.out.println(dropHere.getAttribute("innerHTML"));
        Assert.assertTrue(dropHere.getAttribute("innerHTML").contains("Dropped!"));
    }


    public void verifyTheMessage(WebElement element, String message) {
        BrowserUtils.waitForVisibility(element, 5);
        System.out.println(JavaScriptExecutorUtil.getTextByJS(element));
        Assert.assertTrue(JavaScriptExecutorUtil.getTextByJS(element).contains(message));
    }


}
