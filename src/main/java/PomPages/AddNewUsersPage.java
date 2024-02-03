package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUsersPage {
//Declaration
	@FindBy(xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	@FindBy(xpath="//input[@id='email' and @required]")
	private WebElement emailTF;
	@FindBy(xpath="//input[@id='password' and @required]")
	private WebElement passwordTF;
	@FindBy(xpath="//input[@id='firstname' and @required]")
	private WebElement firstnameTF;
	@FindBy(xpath="//input[@id='lastname' and @required]")
	private WebElement lastnameTF;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement addressTextArea;
	@FindBy(xpath="//input[@id='contact']")
	private WebElement contactInfoTF;
	@FindBy(xpath="//input[@id='photo'])[2]")
	private WebElement photoUploadButton;
	@FindBy(xpath="//button[text()=' save' and @name='add']")
	private WebElement saveButton;
	//Initialization
	public AddNewUsersPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setEmail(String Email) {
		emailTF.sendKeys(Email);
	}
	public void setPassword(String password) {
		emailTF.sendKeys(password);
	}
	public void setFirstName(String firstname) {
		emailTF.sendKeys(firstname);
	}
	public void setLastName(String lastname) {
		emailTF.sendKeys(lastname);
	}
	public void setAddress(String address) {
		addressTextArea.sendKeys(address);
	}
	public void setContactInfo(String contact) {
		emailTF.sendKeys(contact);
	}
	public void uploadPhoto(String photopath) {
		emailTF.sendKeys(photopath);
	}
	public void clickSave()
	{
	saveButton.click();	
	}
	
	
}

