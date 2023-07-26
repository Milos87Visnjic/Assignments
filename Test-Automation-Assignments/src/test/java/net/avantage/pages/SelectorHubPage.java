package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectorHubPage {

    public SelectorHubPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div#userName")
    public WebElement shadowHostUserName;

    @FindBy(css = "div#userPass")
    public WebElement userPass;

    @FindBy(css = "input#glaf")
    public WebElement destinyBox;

    @FindBy(css = "button#close")
    public WebElement closeButton;


    public void typeUserName() {
        BrowserUtils.waitForClickablility(shadowHostUserName, 5);
        SearchContext shadowRoot1 = shadowHostUserName.getShadowRoot();
        WebElement enterName = shadowRoot1.findElement(By.cssSelector("input#kils"));
        enterName.sendKeys("who who");
    }

    public void closeShadowDom() {
        BrowserUtils.waitForClickablility(userPass, 5);
        userPass.click();
        Actions action = new Actions(Driver.get());
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("NeoTech").perform();
    }

    public void handleIframeInShadowRoot() {
        BrowserUtils.waitFor(5);
        WebElement userName = Driver.get().findElement(By.cssSelector("div#userName"));
        BrowserUtils.waitFor(2);
        SearchContext shadowRoot = userName.getShadowRoot();
        WebElement iframePact1 = shadowRoot.findElement(By.cssSelector("iframe#pact1"));
        Driver.get().switchTo().frame(iframePact1);
        BrowserUtils.waitFor(1);
        destinyBox.sendKeys("NeoTech");

    }

    public void handleCloseButton() {
        BrowserUtils.hover(closeButton);
        BrowserUtils.waitFor(3);
        JavaScriptExecutorUtil.highlightElement(closeButton);
        JavaScriptExecutorUtil.flash(closeButton, Driver.get());
    }

    public void shadowRootInsideIframe() {
        BrowserUtils.waitFor(4);
        BrowserUtils.waitForPageToLoad(5);
        WebElement iframePact = Driver.get().findElement(By.cssSelector("iframe#pact"));
        Driver.get().switchTo().frame(iframePact);
        WebElement snackTime = Driver.get().findElement(By.cssSelector("div#snacktime"));
        SearchContext shadowRoot1 = snackTime.getShadowRoot();
        WebElement tea = shadowRoot1.findElement(By.cssSelector("input#tea"));
        System.out.println(tea.getAttribute("placeholder"));
        tea.sendKeys("I love Tea");
        BrowserUtils.waitFor(2);
        WebElement app2=shadowRoot1.findElement(By.cssSelector("div#app2"));
        SearchContext shadowRoot2=app2.getShadowRoot();
        WebElement whatWouldYouLike=shadowRoot2.findElement(By.cssSelector("input#pizza"));
        System.out.println(whatWouldYouLike.getAttribute("placeholder"));
        whatWouldYouLike.sendKeys("borek");
        WebElement concepts=shadowRoot1.findElement(By.cssSelector("div#concepts"));
        BrowserUtils.waitFor(2);
        concepts.click();
        Actions actions=new Actions(Driver.get());
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("No It does not support").perform();
        actions.sendKeys(Keys.TAB).perform();
        BrowserUtils.waitFor(2);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
