package com.qa.SeleniumDDT;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.SeleniumDDTExtras.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class stackTest {
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass
	public static void setup() {
    	System.setProperty("webdriver.chrome.driver","C:\\Data\\chromedriver.exe");
    	report = new ExtentReports(Constants.REPORTLOCATION, true);
	}
	
	@AfterClass
	public static void teardown() {
		report.flush();
	}

}