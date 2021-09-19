package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyLeavePageObject {
	WebDriver driver = null;
	By mainMenuLeave = By.id("menu_leave_viewLeaveModule");
	By myLeave = By.name("My Leave");
	By from = By.id("calFromDate");
	By to = By.id("calToDate");
	By search = By.id("btnSearch");
	
	
//	Constructor
	public MyLeavePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void MoveToMyLeave() {
		if (driver.findElement(mainMenuLeave).isDisplayed()) {
			System.out.println("Leave Main Menu exist");
			driver.findElement(mainMenuLeave).click();
//			driver.findElement(myLeave).click();
		} else {
			System.out.println("Leave Main Menu NOT exist");
		}
	}
	
	public void SearchLeave() {
		driver.findElement(from).clear();
		driver.findElement(from).sendKeys("01-01-2021");
		driver.findElement(to).clear();
		driver.findElement(to).sendKeys("31-12-2022");
		driver.findElement(search).click();
		System.out.println("Seach Leave is done");
	}
}
