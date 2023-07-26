package net.avantage.utils;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * Moves the mouse to given element
     * <p>
     * param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    /**
     * This method enables to remove obscuring element to prevent clicking an element.
     *
     * @param obscuringElement
     */
    public static void removeObscuringElement(WebElement obscuringElement) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].parentNode.removeChild(arguments[0])", obscuringElement);
    }

    /**
     * This methods enables to check if the list is ascending order.
     * @param listOfElements
     */
    public static void checkTheListInAscendingOrder(List<WebElement> listOfElements) {
        List<String> rankinList = BrowserUtils.getElementsText(listOfElements);
        boolean isSorted = Ordering.natural().isOrdered(rankinList);
        try {
            if (isSorted) {
                Assert.assertTrue(isSorted);
                System.out.println("The list is in ascending order");
                System.out.println(rankinList);
            }else {
                System.out.println("the list is NOT in ascending order");
                System.out.println(rankinList);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * return a list of string from a list of elements
     * <p>
     * param list of webelements
     * return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    /**
     * Performs a pause
     * <p>
     * param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * waits for provided element to be selected
     * @param element
     * @param seconds
     */
    public static void waitForElementToBeSelectable(WebElement element, int seconds){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeSelected(element));
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     * <p>
     * param element
     * param timeToWaitInSec
     * return
     */
    public static void waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * <p>
     * param element
     * param timeout
     * return
     */
    public static void waitForClickablility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     * @param seconds
     */
    public static void waitForPageToLoad(int seconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    /**
     * Verifies whether the element is displayed on page
     * <p>
     * param element
     * throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }


    /**
     * Clicks on an element using JavaScript
     * <p>
     * param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     * <p>
     * param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     * <p>
     * param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).build().perform();
    }

    /**
     * Waits for provided alert to be present
     * @param seconds
     */
    public static void waitForAlertIsPresent(int seconds){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (NoAlertPresentException noAlert){
            noAlert.getMessage();
        }

}

    /**
     * Prints out elements coordinates
     */
    public static void getCords(WebElement element){
        Point point=element.getLocation();
        int xCord=point.getX();
        int yCord= point.getY();

        System.out.println(xCord + " ; " + yCord);
    }

    /**
     * This method enables to verify text of web element
     * @param element
     * @param message
     */
    public static void verifyElementText(WebElement element, String message){
        waitForVisibility(element,5);
        System.out.println(element.getText());
        Assert.assertTrue(element.getText().contains(message));
    }

    /**
     * This method enables to make right-click on an element
     * @param element
     */
    public static void rightClick(WebElement element) {
        waitForClickablility(element,5);
        Actions actions=new Actions(Driver.get());
        actions.contextClick(element).perform();
    }


}
