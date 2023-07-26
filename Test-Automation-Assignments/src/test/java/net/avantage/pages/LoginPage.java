package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "span[data-testid='loginBtn']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Join']/parent::button")
    public WebElement joinButton;
    @FindBy(xpath = "//span[contains(text(), 'Email')]")
    public WebElement emailButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "input[name='confirmPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//form[@id='logInForm']//input[@name='password']")
    public WebElement passwordBoxFeedback;

    @FindBy(xpath = "//input[@type='checkbox'][@name='acknowledged']")
    public WebElement termsAndConditionsCheckBox;

    /**
     * provides entering email and password, and then submit.
     *
     * @param email for
     */
    public void logIn(String email) {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(loginButton, 10);
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    public void verifyAvatarOrAvatarInitials() {
        try {
            Assert.assertTrue(avatar.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(avatarInitials.isDisplayed());
        }
    }


    public void loginWithParameters(String userName, String passWord){
      BrowserUtils.waitForPageToLoad(5);
      BrowserUtils.waitForClickablility(loginButton,5);
      BrowserUtils.removeObscuringElement(obscuringElementCookieBanner);
      loginButton.click();
      emailButton.click();
      emailInputBox.sendKeys(userName);
      passwordInputBox.sendKeys(passWord);
      submitButton.click();
    }

    public void verifyAvatar(String avtr){
   if (avtr=="avatar"){
       Assert.assertTrue(avatar.isDisplayed());
   } else if (avtr=="initials") {
       Assert.assertTrue(avatarInitials.isDisplayed());

   }
    }


}
