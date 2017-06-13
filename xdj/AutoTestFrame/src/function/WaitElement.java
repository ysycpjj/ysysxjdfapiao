package function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitElement {

	private static WebDriver driver;

	private static WebDriverWait wait;

	protected static Function<WebDriver, Boolean> isPageLoaded() {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
	}

	public static void waitForElementLocated(By by, char s, WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		switch (s) {
		case 'v':
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			break;
		case 'c':
			wait.until(ExpectedConditions.elementToBeClickable(by));
			break;
		}
	}

	public static void waitForElement(WebElement element, char s,
			WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		switch (s) {
		case 'v':
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case 'c':
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;
		}
	}

	public static void waitForAndClickElementLocated(By by, char s,
			WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		switch (s) {
		case 'v':
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).click();
			break;
		case 'c':
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
			break;
		}
	}

	public static void waitForAndClickElement(WebElement element, char s,
			WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		switch (s) {
		case 'v':
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			break;
		case 'c':
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			break;
		}
	}

	public static void sleep(int microSeconds) {
		try {
			Thread.sleep(microSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitAndScrollAndClick(WebDriver driver,
			WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);
	}

	public static void waitAndClick(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);
	}

	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(isPageLoaded());
	}
}
