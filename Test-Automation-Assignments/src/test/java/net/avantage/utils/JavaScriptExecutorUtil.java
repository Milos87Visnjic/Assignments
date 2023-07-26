package net.avantage.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorUtil {
    public static void flash(WebElement element, WebDriver driver){
        String bgColor=element.getCssValue("backgroundColor");
         for (int i=0;i<10;i++){
             changeColor("#00FF00", element,driver);
             changeColor(bgColor,element,driver);
             changeColor("#DC143C", element,driver);
         }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);

       try {
           Thread.sleep(200);
       }catch (InterruptedException exception){
           exception.printStackTrace();
       }
    }
    public static void drawBorder(WebElement element){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].style.border='3px solid red'",element);
    }
    public static void takeScreenShot() throws IOException {
        File src=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.FILE);
        File trg=new File("Users/neotech/Desktop/DemoPage.png");
        FileUtils.copyFile(src,trg);
    }

    public static String getTitleByJS(){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
       String title= jse.executeScript("return document.title;").toString();
       return title;
    }

    public static void clickElementByJS(WebElement element){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();",element);
    }

    public static void doubleClickByJS(WebElement element){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }

    public static void generateAlert(String message){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        jse.executeScript("alert('"+message+"')");
    }

    public static void getWindowSize(){
        JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
        System.out.println("Height is "+jse.executeScript("return window.innerHeight;"));
        System.out.println("Width is "+jse.executeScript("return window.innerWidth;"));
    }
    public static void doubleClickWithJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }

    public static String getTextByJS(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        return (String) jse.executeScript("return arguments[0].innerHTML;", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
