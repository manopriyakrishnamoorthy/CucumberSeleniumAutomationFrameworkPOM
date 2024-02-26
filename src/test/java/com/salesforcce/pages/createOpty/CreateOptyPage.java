package com.salesforcce.pages.createOpty;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class CreateOptyPage extends BasePage {
	@FindBy(xpath="//a[text()='Opportunities']") WebElement opty;
	@FindBy(xpath="//select[@id='fcf']") WebElement optyDropdown;
	@FindBy(xpath="//select[@id='fcf']/option") List<WebElement> actualoptions;
	@FindBy(xpath="//input[@value=' New ']") WebElement newButton;
	@FindBy(xpath="//input[@id='opp3']") WebElement OptyName;
	@FindBy(xpath="//input[@id='opp4']") WebElement optyAccount;
	@FindBy(xpath="//input[@id='opp9']") WebElement optyDate;
	@FindBy(xpath="//select[@id='opp11']")WebElement optyStage;
	@FindBy(xpath="//input[@id='opp12']")WebElement optyProb;
	@FindBy(xpath="//input[@id='opp17']")WebElement optyPrimarySource;
	@FindBy(xpath="//select[@id='opp6']")WebElement optyLeadSource;
	@FindBy(xpath="//input[@value=' Save ']") WebElement optySave;
	@FindBy(xpath="//a[text()='Opportunity Pipeline']") WebElement optyPipeline;
	@FindBy(xpath="//a[text()='Stuck Opportunities']") WebElement optyStuck;
	@FindBy(xpath="//select[@id='quarter_q']") WebElement intervalDropdown;
	@FindBy(xpath="//select[@id='open']") WebElement include;
	
	public CreateOptyPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOptyLink() {
		clickElement(opty, "opty link");
	}
	
	public void clickOptyDropdown() {
		clickElement(optyDropdown, "opty dropdown");
	}
	
	public List<WebElement> getOptyOptions() {
		return actualoptions;
	}
	
	public List<String> getOptyOptionsAsText() {
		List<String> options = new ArrayList<String>();
		for(WebElement option:actualoptions) {
			//option.getText();
			options.add(option.getText());
		}
		return options;
		
	}
	
	public void clickNewButton() {
		clickElement(newButton, "new button");
	}
	
	public void enterOptyName(String data) {
		enterText(OptyName, data, "opty name");
	}
	
	public void enterOptyAcc(String data) {
		enterText(optyAccount, data, "opty account");
	}
	
	public void enterOptydate(String data) {
		enterText(optyDate, data, "opty date");
	}

     public void selectStageOption() {
    	 select(optyStage, "Prospecting", "stage option");
     }
	
     public void probClear() {
    	 clearElement(optyProb, "opty prob");
     }
     
     public void enterProb(String data) {
    	 enterText(optyProb, data, "opty prob");
     }
     
     public void enterPrimarySource(String data) {
    	 enterText(optyPrimarySource, data, "opty primanysource");
     }
     
     public void selectleadSourceOption() {
    	 select(optyLeadSource, "Web", "opty lead source");
     }
     
     public void clickSave() {
    	 clickElement(optySave, "save button");
     }
	
     public void clickOptyPipeline() {
    	 clickElement(optyPipeline, "pipeline link");
     }
     
     public void clickOptyStuck() {
    	 clickElement(optyStage, "opty stuck link");
     }
     
     public void selectOptionInterval() {
    	 select(intervalDropdown, "Next FQ", "interval option");
     }
     
     public void selectOptionInclude() {
    	 select(include, "Open Opportunities", "include option");
     }
     
}