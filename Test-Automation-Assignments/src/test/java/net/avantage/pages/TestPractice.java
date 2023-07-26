package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestPractice extends BasePage {

    @FindBy(css = "button[name='click']")
    public WebElement clickMeButton;

    @FindBy(css = "button[name='dblClick']")
    public WebElement doubleClickMeButton;

    @FindBy(css = "div#draggable")
    public WebElement dragMe;

    @FindBy(css = "div#droppable")
    public WebElement dropHere;

    @FindBy(css = "div#div2")
    public WebElement thirdSquare;

    @FindBy(xpath = "//ol[@id='selectable']//li")
    public List<WebElement> selectableTable;

    Actions actions = new Actions(Driver.get());

    public void handleClickMeButton() {
        BrowserUtils.waitForPageToLoad(5);
        actions.click(clickMeButton).perform();
    }

    public void handleAlertPopsUp(String text) {
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitForAlertIsPresent(5);
        BrowserUtils.waitFor(1);
        System.out.println(alert.getText());
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
    }

    public void doubleClickOnDoubleClickMeButton() {
        actions.doubleClick(doubleClickMeButton).perform();
    }

    public void hoverOverThirdSquare() {
        actions.moveToElement(thirdSquare).perform();
    }

    public void handleSelectableTable() {
        for (WebElement element : selectableTable) {
            actions.click(element).perform();
            Assert.assertTrue(element.getAttribute("class").contains("selected"));
            System.out.println("The "+element.getText()+ " is validated  ");
        }
    }
}
