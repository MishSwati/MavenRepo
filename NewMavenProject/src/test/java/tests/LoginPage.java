package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.Screenshot;
import pages.DashboardPageObject;
import pages.LoginPageObject;
import pages.MyLeavePageObject;

public class LoginPage {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		LoginPage test = new LoginPage();

		test.loginTest();
		test.NavigatetoLeave();
		test.SearchLeave();
		
		
	}
	
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\smishra7\\OneDrive - Capgemini\\Documents\\Selenium SetUp\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		LoginPageObject loginobj = new LoginPageObject(driver);
		DashboardPageObject DashObj =  new DashboardPageObject(driver);
		Screenshot SSObj =  new Screenshot();
		loginobj.LoginToApplication("Admin","admin123");
		DashObj.VerifyLogin();
//		SSObj.takeSnapShot(driver, "C:\\Users\\smishra7\\eclipse-workspace\\NewMavenProject\\Screenshots\\test.png");
	}
	
	public void NavigatetoLeave() {
		MyLeavePageObject Leaveobj = new MyLeavePageObject(driver);
		Leaveobj.MoveToMyLeave();
	}
	
	public void SearchLeave() {
		MyLeavePageObject Leaveobj = new MyLeavePageObject(driver);
		Leaveobj.SearchLeave();
	}
}
