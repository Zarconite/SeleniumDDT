package com.qa.SeleniumDDT;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	
	public void searchFor(String input) {
		
		searchBox.click();
		searchBox.sendKeys(input,Keys.RETURN);
		
	}
	
}
	

