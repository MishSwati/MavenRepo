package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.screesht;
import pages.DashboardPageObject;
import pages.LoginPageObject;
import pages.MyLeavePageObject;

public class DemoTest {
	private static WebDriver driver = null;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\smishra7\\OneDrive - Capgemini\\Documents\\Selenium SetUp\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println("Browser is successfully Launched ");
	}

	@Test(priority = 1)
	public void login() {
		LoginPageObject loginobj = new LoginPageObject(driver);
		DashboardPageObject DashObj =  new DashboardPageObject(driver);
		loginobj.LoginToApplication("Admin","admin123");
		DashObj.VerifyLogin();
	}

	@Test(priority = 2)
	public void Leave() {
		MyLeavePageObject Leaveobj = new MyLeavePageObject(driver);
		Leaveobj.MoveToMyLeave();
		Leaveobj.SearchLeave();
	}

	@AfterTest
	public void closeAppication() {
		driver.close();
		driver.quit();
		System.out.println("Driver is close and Quit");
	}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.SUCCESS==result.getStatus()){
			String testName = result.getName();
			screesht SSbj = new screesht(driver);
			SSbj.captureScreenshot(driver,"C:\\Users\\smishra7\\eclipse-workspace\\NewMavenProject\\Screenshots\\"+testName+System.currentTimeMillis()+".png");	
		}
	}
}

