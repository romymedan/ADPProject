package org.romymedan.demo.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.romymedan.demo.TestNGRunner;
import org.romymedan.demo.pages.SearchResultsPage;
import org.testng.Assert;

/**
 * step definitions for feature file
 */
public class StepDefinitions {
    SearchResultsPage page = new SearchResultsPage(TestNGRunner.getDriver());
    @Given("^I am on the search results page$")
    public void iAmOnThePage () {
        page.navigateTo();
    }

    @When("^I type \"([^\"]*)\" in the 'Keyword' field$")
    public void iTypeInTheField(String name) {
        page.inputText(name);
    }

    @And("^I select \"([^\"]*)\" in the 'Select a Job Category' field$")
    public void iSelectInTheSelectAJobCategoryField(String jobCategory) throws InterruptedException {
        page.jobCategorySelection(jobCategory);
        Thread.sleep(1000);

    }

    @And("^I select \"([^\"]*)\" in the 'Language' field$")
    public void iSelectInTheLanguageField(String language) throws InterruptedException {
        page.selectlanguage(language);
        Thread.sleep(1000);
    }

    @Then("^I click on the \"([^\"]*)\" button$")
    public void iClickOnTheButton(String searchButton) throws Throwable {
        page.clickOnSearchButton(searchButton);
    }

    @And("^I should see the position \"([^\"]*)\"$")
    public void iShouldSeeThePosition(String myJob) throws InterruptedException {
        Assert.assertTrue(page.findTheJob(myJob),"The job " + myJob + " was not found");
        Thread.sleep(1000);
    }
}
