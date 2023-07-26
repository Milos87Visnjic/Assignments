package net.avantage.pages;

import net.avantage.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatirPage {

    public WatirPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div#shadow_host")
    public WebElement shadowHost;

    public SearchContext expandRootElement(WebElement element) {
        return (SearchContext) ((JavascriptExecutor) Driver.get()).executeScript(
                "return arguments[0].shadowRoot", element);
    }

    public void getNestedTextUsingJSExecutor() {
        SearchContext shadowRootOne = expandRootElement(shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement(nestedShadowHost);
        WebElement nestedText = shadowRootTwo.findElement(By.cssSelector("#nested_shadow_content > div"));
        System.out.println("JSE --> " + nestedText.getText());
    }

    public void getTextInNestedShadowHost() {
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot();
        WebElement nestedText = shadowRootTwo.findElement(By.cssSelector("#nested_shadow_content > div"));
        System.out.println("ShadowRoot Method --> " + nestedText.getText());
    }
}
