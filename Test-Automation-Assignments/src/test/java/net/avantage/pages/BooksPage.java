package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

    public BooksPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "body > book-app")
    public WebElement bookApp;

    public void typeAnItem() {
        SearchContext shadowRoot1 = bookApp.getShadowRoot();
        WebElement appHeader = shadowRoot1.findElement(By.cssSelector("app-header"));
        BrowserUtils.waitFor(1);
        WebElement appToolBar = appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
        WebElement bookInputDecorator = appToolBar.findElement(By.cssSelector("book-input-decorator"));
        WebElement inputBox = bookInputDecorator.findElement(By.cssSelector("input#input"));
        inputBox.sendKeys("DaVinci Code");
        new Actions(Driver.get()).sendKeys(Keys.ENTER).perform();
    }

    public void clickOnItemTitle() {
        SearchContext shadowRoot1 = bookApp.getShadowRoot();
        WebElement book_explore = shadowRoot1.findElement(By.cssSelector("main > book-explore"));
        BrowserUtils.waitFor(1);
        SearchContext shadowRoot2 = book_explore.getShadowRoot();
        WebElement book_item = shadowRoot2.findElement(By.cssSelector("section book-item"));
        SearchContext shadowRoot3 = book_item.getShadowRoot();
        WebElement itemTitle = shadowRoot3.findElement(By.cssSelector("a h2"));
        System.out.println("Title after search in search page -->  "+itemTitle.getText());
        JavaScriptExecutorUtil.clickElementByJS(itemTitle);
    }

    public void getItemTitle(){
        SearchContext shadowRoot1 = bookApp.getShadowRoot();
        WebElement book_detail=shadowRoot1.findElement(By.cssSelector("main > book-detail"));
        SearchContext shadowRoot2=book_detail.getShadowRoot();
        WebElement bookTitle=shadowRoot2.findElement(By.cssSelector("section h2"));
        System.out.println("Book title in detail page : "+bookTitle.getText());
    }

    public void clickOnPreviewButton(){
        SearchContext shadowRoot1 = bookApp.getShadowRoot();
        WebElement book_detail=shadowRoot1.findElement(By.cssSelector("main > book-detail"));
        SearchContext shadowRoot2=book_detail.getShadowRoot();
        WebElement previewButton=shadowRoot2.findElement(By.cssSelector("section a"));
        previewButton.click();
    }

    public void verifyBookViewer(){
        SearchContext shadowRoot1 = bookApp.getShadowRoot();
        WebElement bookViewer=shadowRoot1.findElement(By.cssSelector("main > book-viewer"));
        SearchContext shadowRoot2=bookViewer.getShadowRoot();
        WebElement bookPreview=shadowRoot2.findElement(By.cssSelector("div#viewer"));
        Assert.assertTrue(bookPreview.isDisplayed());
    }
}
