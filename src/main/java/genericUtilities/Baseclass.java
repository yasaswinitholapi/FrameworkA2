package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.AddNewCategoryPage;
import PomPages.AddNewCoursePage;
import PomPages.AddNewUsersPage;
import PomPages.CorseListPage;
import PomPages.HomePage;
import PomPages.LognPage;
import PomPages.UsersPage;
import PomPages.category;

public class Baseclass {
	protected WebDriver driver;
	protected PropertiesUtility property;
	protected JavaUtility jutil;
	protected WebdriverUtilty web;
	protected EcelUtlty excel;
		protected LognPage login;
		protected HomePage home;
		protected UsersPage users;
		protected CorseListPage courseList;
		protected category category;
		protected AddNewUsersPage adduser;
		protected AddNewCoursePage addcourse;
		protected AddNewCategoryPage addCategory;
		public static WebDriver sdriver;
		public static JavaUtility sjutil;
	//@BeforeSuite
	//@BeforeTest

	@BeforeClass
	public void classSetup() {
		web=new WebdriverUtilty();
		jutil=new JavaUtility();
		property=new PropertiesUtility();
		excel=new EcelUtlty();
		property.propertesInit(Iconstantpath.PROPERTIES_FILE_PATH);
		driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	sdriver=driver;
	sjutil=jutil;
	}

	@BeforeMethod
	public void methodSetup() {
		login=new LognPage(driver);
		home=new HomePage(driver);
		users=new UsersPage(driver);
		courseList=new CorseListPage(driver);
		category=new category(driver);
		adduser=new AddNewUsersPage(driver);
		addcourse=new AddNewCoursePage(driver);
		addCategory=new AddNewCategoryPage(driver);
		
		excel.excelInit(Iconstantpath.EXCEL_PATH, "Sheet1");
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.loginToApp(property.readFromProperties("username"),
		property.readFromProperties("password"));
		Assert.assertEquals(home.getPageHeader(), "Home");
		
	}

	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signOutApp();
	}
	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	//@AfterTest
	//@AfterSuite
	}


