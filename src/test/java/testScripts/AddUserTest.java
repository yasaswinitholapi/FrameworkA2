package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.Baseclass;
//THS S ADD USER PROGRAMM

public class AddUserTest extends Baseclass {
@Test
public void addUserTest() throws InterruptedException{

	SoftAssert soft=new SoftAssert();
	home.clickUsersTab();
	soft.assertTrue(users.getPageHeader().contains("Users"));
	users.clickNewButton();
	Thread.sleep(3000);
	soft.assertEquals(adduser.getPageHeader(), "Add new user");
	Map<String, String> map=excel.readFromExcel("Add User");
	adduser.setEmail(map.get("Email"));
	adduser.setPassword(map.get("password"));
	adduser.setFirstName(map.get("Firstname"));
	adduser.setLastName(map.get("LastName"));
	adduser.setAddress(map.get("Address"));
	adduser.setContactInfo(map.get("Contactinfo"));
	adduser.uploadPhoto(map.get("Photo"));
	
	adduser.clickSave();
	soft.assertEquals(users.getSuccessMessage(), "Success!");
	soft.assertAll();
}
}
