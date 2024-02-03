package PomPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebdriverUtilty;

public class category {
	// Declaration
	@FindBy(xpath = "//h1[normalize-space(text())='Category']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	private String deletepath = "//td[text()='%s']/ancestor::tr/descendant::button[text()=' Delete']";

	@FindBy(name = "delete")
	private WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement successMessage;

	// Initialization

	public category(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {

		return pageHeader.getText();

	}

	public void clickNewButton() {
		newButton.click();
	}

	public void deleteCourse(WebdriverUtilty web, String categoryName) {

		web.convertPathToWebElement(deletepath, categoryName).click();
		deleteButton.click();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

}
