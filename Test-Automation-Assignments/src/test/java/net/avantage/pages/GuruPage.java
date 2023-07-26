package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GuruPage extends BasePage {

    @FindBy(id = "credit2")
    public WebElement bankButton;

    @FindBy(css = "ol#bank")
    public WebElement accountPlaceHolderDebitSide;

    @FindBy(id = "amt7")
    public WebElement amountPlaceHolderDebitSide;

    @FindBy(xpath = "(//li[@data-id='2'])[1]")
    public WebElement first5000;

    @FindBy(xpath = "(//li[@data-id='2'])[2]")
    public WebElement second5000;

    @FindBy(id = "credit1")
    public WebElement salesButton;

    @FindBy(css = "ol#loan")
    public WebElement accountPlaceHolderCreditSide;

    @FindBy(id = "amt8")
    public WebElement amountPlaceHolderCreditSide;

    @FindBy(xpath = "//a[contains(text(),'Perfect')]")
    public WebElement perfectMessage;

    public WebElement locateResultTable(String columnNumber){
        String xpath="//div[@id='bal3']//tr/td["+columnNumber+"]";
        return Driver.get().findElement(By.xpath(xpath));
    }
    public void moveElement(WebElement from, WebElement to) {
        Actions actions = new Actions(Driver.get());
        BrowserUtils.waitForPageToLoad(5);
        actions.dragAndDrop(from, to).perform();
    }

    public void validateMovedElement(WebElement element, WebElement movedElement){
        BrowserUtils.waitFor(1);
        Assert.assertEquals(element.getText(),movedElement.getText());
    }

    public void printResultTable(){
        BrowserUtils.waitFor(1);
        BrowserUtils.scrollToElement(locateResultTable(String.valueOf(3)));
        for (int i=1;i<=4;i++){
            System.out.print(locateResultTable(String.valueOf(i)).getText()+" ");
        }
        System.out.println();
    }

    public void verifyPerfectMessage(){
        Assert.assertTrue(perfectMessage.isDisplayed());
        if(perfectMessage.isDisplayed()) {
            System.out.println("*************************");
            System.out.println("Perfect Displayed !!!");
            System.out.println("*************************");
            System.out.println("!!!"+perfectMessage.getText().toUpperCase()+"!!");
            System.out.println("*************************");
        }
        else {
            System.out.println("Perfect not Displayed !!!");
        }
    }

}
