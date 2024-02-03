package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.Baseclass;
import genericUtilities.Iconstantpath;

public class AddCategoryTest  extends Baseclass {
@Test
	
	public void addCategoryTest() throws InterruptedException{
			SoftAssert soft=new SoftAssert();
				home.clickcoursesTab();
				home.clickCategoryLink();
				soft.assertTrue(category.getPageHeader().contains("Category"));
				
				
				category.clickNewButton();
				Thread.sleep(3000);
				soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
				Map<String ,String>map=excel.readFromExcel("Add Category");
				addCategory.setName(map.get("Name"));
				addCategory.clickSave();
				soft.assertEquals(category.getSuccessMessage(),"Success!");
				category.deleteCourse(web, map.get("Name"));
				soft.assertEquals(category.getSuccessMessage(), "Success!");
				if(category.getSuccessMessage().equals("Success!")) {
					excel.updateTestStatus("Add Category", "pass", Iconstantpath.EXCEL_PATH);
				}
				else {
					excel.updateTestStatus("Add Category", "Fail", Iconstantpath.EXCEL_PATH);
				}
				soft.assertAll();
				


}
	}