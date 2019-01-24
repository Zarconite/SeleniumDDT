package com.qa.SeleniumDDT;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.SeleniumDDT.*;
import com.qa.SeleniumDDTExtras.Constants;
import com.qa.SeleniumDDT.LandingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {

	WebElement element;
	WebDriver driver;
	String searchQuery;

	@Before
	public void setup() {
    	System.setProperty(Constants.CHROMEWEBDRIVER,Constants.CHROMEWEBDRIVERLOCATION);
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	stackTest.test = stackTest.report.startTest("Verify scenarios..");
		searchQuery="";
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String websiteLink){
		stackTest.test.log(LogStatus.INFO, "Navigating to test page..");
		driver.get(websiteLink);
		stackTest.test.log(LogStatus.INFO, "Navigation complete!");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchString){
		stackTest.test.log(LogStatus.INFO, "Entering search query..");
		searchQuery=searchString.replaceAll("\\s+","+");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.searchFor(searchString);
		stackTest.test.log(LogStatus.INFO, "Search complete!");
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search(){
		stackTest.test.log(LogStatus.INFO, "Running comparison..");
		if(driver.getCurrentUrl().toLowerCase().contains(searchQuery.toLowerCase())) {
			stackTest.test.log(LogStatus.PASS, "Expected should contain actual value | Expected: " + driver.getCurrentUrl() + " | Actual: " + searchQuery.replaceAll("\\s+","+"));
		}
		else {
			stackTest.test.log(LogStatus.FAIL, "Expected should contain actual value | Expected: " + driver.getCurrentUrl() + " | Actual: " + searchQuery.replaceAll("\\s+","+"));	
		}
		assertEquals("Result should be identical", true, driver.getCurrentUrl().toLowerCase().contains(searchQuery.toLowerCase()));
	}
	
	@After
	public void end() {
		stackTest.report.endTest(stackTest.test);
		driver.quit();
	}
	
}
