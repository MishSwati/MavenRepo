package common;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screesht {
	WebDriver driver = null;
	//	Constructor
	public screesht(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenshot(WebDriver driver,String screenshotName){
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);		
			//Move image file to new destination
			File DestFile=new File(screenshotName);
			//Copy file at destination
			FileUtils.copyFile(source, DestFile);			
			System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}
}