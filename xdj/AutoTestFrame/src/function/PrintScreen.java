package function;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class PrintScreen {
	
//	WebDriver driver;

	public void printScreen(WebDriver driver) {
		try {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("d:\\screenshot.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
