package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Class
public class LoginPageObject {
	WebDriver driver = null;
	By userName = By.id("txtUsername");
	By passwrd = By.id("txtPassword");
	By login = By.id("btnLogin");
	
//	Constructor
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginToApplication(String name,String pass) {
		driver.findElement(userName).sendKeys(name);
		driver.findElement(passwrd).sendKeys(pass);
		driver.findElement(login).click();	
		
	}
}
