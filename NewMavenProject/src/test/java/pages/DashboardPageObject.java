package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject {
	WebDriver driver = null;
	By welcmMsg = By.id("welcome");
	
//	Constructor
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void VerifyLogin() {
		if (driver.findElement(welcmMsg).isDisplayed()) {
			System.out.println("Login Success");
			System.out.println("User Logged in Successfully");
			
		} else {
			System.out.println("Login Failed");

		}
	}
}
