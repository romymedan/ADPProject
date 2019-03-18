package org.romymedan.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * page objects for the search results page
 */
public class SearchResultsPage extends BasePage {

    // page elements
    private static By keywordTextInput = By.cssSelector("input[name='keyword']");
    private static By selectJobCategory = By.id("cws_jobsearch_multiCategory");
    private static By selectLanguage = By.cssSelector("#cws_jobsearch_language");
    private static By searchButton = By.cssSelector("#cws-adv-search-btn");
    private static By searchResults = By.cssSelector("#widget-jobsearch-results-list > ol > li");


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(){
        driver.get("https://jobs.adp.com/job-search-results");
    }

    public void inputText(String text){
        driver.findElement(keywordTextInput).sendKeys(text);
    }

    public void jobCategorySelection(String jobCategory){
        Select listJobs = new Select(driver.findElement(selectJobCategory));
        listJobs.selectByValue(jobCategory);
        waitForPageToLoad();
    }

    public void selectlanguage(String language){
        Select listLanguages = new Select(driver.findElement(selectLanguage));
        listLanguages.selectByVisibleText(language);
        waitForPageToLoad();
    }

    public void clickOnSearchButton(String button){
        driver.findElement(searchButton).click();
        waitForPageToLoad();
    }

    public boolean findTheJob(String myJob){
        waitForPageToLoad();
        List<WebElement> jobs = driver.findElements(searchResults);
        for (WebElement job : jobs) {
            if(job.getText().contains(myJob)){
                return true;
            }
        }
        return false;
    }

}
