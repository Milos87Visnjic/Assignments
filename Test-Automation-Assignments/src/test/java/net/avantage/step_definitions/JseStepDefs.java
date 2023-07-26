package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.avantage.pages.JavaScriptExecutorDemo;
import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import net.avantage.utils.JavaScriptExecutorUtil;

import java.io.IOException;

public class JseStepDefs {
    JavaScriptExecutorDemo javaScriptExecutorDemo = new JavaScriptExecutorDemo();

    @Given("User flashes join button")
    public void user_flashes_join_button() throws IOException {
        BrowserUtils.waitForVisibility(javaScriptExecutorDemo.joinButton, 5);
        JavaScriptExecutorUtil.drawBorder(javaScriptExecutorDemo.table1);
        JavaScriptExecutorUtil.takeScreenShot();
        JavaScriptExecutorUtil.flash(javaScriptExecutorDemo.joinButton, Driver.get());
        System.out.println(JavaScriptExecutorUtil.getTitleByJS());
        JavaScriptExecutorUtil.clickElementByJS(javaScriptExecutorDemo.loginButton);
        JavaScriptExecutorUtil.generateAlert("Ooops!.. You clicked on login button....");
        BrowserUtils.waitFor(2);


    }

    @Given("User navigates to twoplugs page")
    public void userNavigatesToTwoplugsPage() {
        Driver.get().get("https://www.twoplugs.com/");
    }

    @And("User use jse")
    public void userUseJse() {
        JavaScriptExecutorUtil.getWindowSize();
    }
}
