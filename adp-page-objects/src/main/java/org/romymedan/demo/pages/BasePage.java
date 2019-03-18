package org.romymedan.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    private static final int TIMEOUT = 100;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT),this);
    }

    protected void waitForElementToAppear(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator,text)));
    }

    protected void waitForPageToLoad(){
        new WebDriverWait(driver, TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void scrollIntoTheElement(WebElement element){
        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        waitForPageToLoad();
    }

    protected void forceClick(WebElement inputElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", inputElement);
    }
}
