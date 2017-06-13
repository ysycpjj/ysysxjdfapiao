package function;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.openqa.selenium.safari.SafariDriver;
import util.Config;
import util.IOUtils;
import util.Log;

public class Browser {

	private static WebDriver driver;

	public static WebDriver openBrowser(char browser) {
		switch (browser) {
		case 'f':
			driver = new FirefoxDriver();
			break;
		case 'i':
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe\\");
			System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe\\");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			break;
		case 'c':
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public static WebDriver openBrowser() {
		if ("firefox".equals(Config.browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(Config.browser)) {
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe\\");
			System.setProperty("webdriver.ie.bin", "C:\\Program Files\\Internet Explorer\\iexplore.exe\\");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			driver = new InternetExplorerDriver(capabilities);
		} else if ("chrome".equals(Config.browser)) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
		} else {
			Log.logInfo(Config.browser + " 的值不正确，请检查！");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Config.waitTime, TimeUnit.SECONDS);
		return driver;
	}

	public static void switchWindow(int i) {
		driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[i - 1]);
	}

	public static void switchToLastWindow() {
		driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[driver.getWindowHandles().size() - 1]);
	}
	public static WebDriver getWebDriver() {
		String browserBin;
		switch(Config.browser){
			case "firefox":
				browserBin = "webdriver.firefox.bin";
				break;
/*			case "chrome":
				browserBin = "webdriver.chrome.bin";
				break;
			case "safari":
				browserBin ="webdriver.safari.bin"*/
			default:
				browserBin = "webdriver.firefox.bin";
				break;
		}
		System.setProperty(browserBin, Config.browserPath);
		String path = Config.exportPath;
		IOUtils.createDir(path);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.downloadDir", path);
		profile.setPreference("browser.download.defaultFolder", path);
		profile.setPreference("browser.download.dir", path);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("extensions.update.autoUpdateDefault", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip");
		driver = new FirefoxDriver(profile);
		return driver;
		/*driver = new SafariDriver();
		return driver;*/
	}
}
