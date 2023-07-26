package net.avantage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptExecutorDemo extends BasePage {

    @FindBy(css = "span[data-testid='loginBtn']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Join']")
    public WebElement joinButton;

    @FindBy(xpath = "(//span[text()='Join now for free'])[1]")
    public WebElement joinForFree;

    @FindBy(css = "tr[data-testid='table-row-63fd339ae49765f02d938b42']")
    public WebElement row1;

    @FindBy(xpath = "(//table[@aria-label='Contests table'])[1]")
    public WebElement table1;
}
