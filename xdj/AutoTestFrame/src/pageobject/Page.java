package pageobject;

import com.google.common.base.Function;
import function.Randomint;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Config;
import util.Log;

import java.util.List;

public class Page {

	public static WebDriver driver;

	public static String URL;
//	public static String URL = "http://10.10.10.211:8085/";

	public Page(){
		URL= Config.url;
		driver = PageConfig.getInstance().getWebdriver();
	}

	public Page(WebDriver driver) {
		URL= Config.url;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public static LoginPage navigateTo(WebDriver driver) {
		driver.get(URL);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public static  <T> T initPageElement(WebDriver driver,Class<T> pageClassToProxy){
		Log.logInfo("加载页面元素");
		return PageFactory.initElements(driver, pageClassToProxy);
	}

	public static  void initPageElement(WebDriver driver,Object classObkect){
		PageFactory.initElements(driver, classObkect);
		Log.logInfo("加载页面元素");
	}

	public static void get(WebDriver driver){
		driver.get(URL);
		sleep(2);
		Log.logInfo("打开连接："+URL);
//		driver.manage().window().maximize();
//		Log.logInfo("浏览器最大化");
	}

	public static boolean waitToDisplayed(final By by) {
		boolean waitDisplayed = new WebDriverWait(driver, 10)
				.until(new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver dr) {
						return dr.findElement(by).isDisplayed();
					}
				});
		if(waitDisplayed)
			Log.logInfo("元素经等待已显示"+by.toString());
		else
			Log.logInfo("元素在指定时间未显示"+by.toString());
		return waitDisplayed;
	}

	public static WebElement getElement(By by) {
		WebElement element = null;
		if (waitToDisplayed(by)) {
			element = driver.findElement(by);
			Log.logInfo("找到元素"+by.toString());
		}else
			Log.logInfo("经等待未找到元素"+by.toString());
		return element;
	}

	public  static boolean waitToDisplayed(final WebElement element) {
		boolean waitDisplayed = new WebDriverWait(driver, 10)
				.until(new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver dr) {
						return element.isDisplayed();
					}
				});
		if(waitDisplayed)
			Log.logInfo("元素经等待已显示"+element.getText());
		else
			Log.logInfo("元素在指定时间未显示"+element.getText());
		return waitDisplayed;
	}

	public static WebElement getElement(WebElement element) {
		if (waitToDisplayed(element)) {
			Log.logInfo("找到元素"+element.getText());
			return element;
		} else {
			Log.logInfo("未找到元素");
			return null;
		}
	}
	
	public static void clickElement(By by) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				by);
		Log.logInfo("点击元素"+by.toString());
//		waitForPageLoad();
	}

	public  static void clickElement(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				element);
		Log.logInfo("点击元素");
//		waitForPageLoad();
	}
	
	public static void sendKeys(WebElement element, String keys) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				element);
		element.clear();
		element.sendKeys(keys);
		Log.logInfo("为元素："+element.getText()+",输入内容："+keys);
	}

	public static void sendKeys(By by, String keys) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(by));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				by);
		((WebElement) by).clear();
		((WebElement) by).sendKeys(keys);
		Log.logInfo("为元素："+by.toString()+",输入内容："+keys);
	}
	
	public static void selectByValue(WebElement element, String value) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(element));
		waitForSelectLoad(element.findElements(By.xpath("//option")));
		Select se1 = new Select(element);
		se1.selectByValue(value);
		Log.logInfo("选择下拉框："+element.getText()+"中的："+value);
	}

	public static void selectByIndex(WebElement element, int index) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(element));
		waitForSelectLoad(element.findElements(By.xpath("//option")));
		Select se1 = new Select(element);
		se1.selectByIndex(index);
		Log.logInfo("选择下拉框："+element.getText()+"中的第"+index+"个");
	}

	public static void selectByText(WebElement element, String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(element));
		waitForSelectLoad(element.findElements(By.xpath("//option")));
		Select se1 = new Select(element);
		se1.selectByVisibleText(text);
		Log.logInfo("选择下拉框："+element.getText()+"中包含："+text+"的项");
	}

	public static void selectRandomOption(WebElement element) {
		waitElementExist(element);
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
		String b = element.toString();
		String c = getStringAfter(b, "xpath: ", "]");
		waitForSelectLoad(element.findElements(By.xpath(c + "//option")));
		List<WebElement> li = element.findElements(By.xpath(c + "//option"));
		waitForSelectLoad(li);
		int a = li.size();
		Select se1 = new Select(element);
		se1.selectByIndex(Randomint.randomint(1, a-1));
		Log.logInfo("选择下拉框："+element.getText()+"中随机项");
	}

	public static void switchWindow(int i) {
		driver.switchTo().window(
				driver.getWindowHandles().toArray(new String[0])[i - 1]);
		Log.logInfo("切入第"+i+"个页面");
	}

	public static void switchToLastWindow() {
		driver.switchTo().window(
				driver.getWindowHandles().toArray(new String[0])[driver
						.getWindowHandles().size() - 1]);
		Log.logInfo("切入最后一个页面");
	}

	public static void waitElement(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(element));
		Log.logInfo("等待元素可见"+element.getText());
	}


	public static void waitElements(List<WebElement> list) {
		for(int i=0;i<list.size();i++){
			new WebDriverWait(driver, 10).until(ExpectedConditions
					.visibilityOf(list.get(i)));
		}
		Log.logInfo("等待元素"+list.size()+"个可见");
	}


	public static void waitElement(By by) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOfElementLocated(by));
		Log.logInfo("等待元素可见"+by.toString());
	}

	public static boolean isExist(WebElement element) {
		boolean b = true;
		try {
			String tagName =element.getTagName();
			Log.logInfo("元素存在"+tagName);
		} catch (Exception e) {
			b = false;
			Log.logInfo("元素不存在");
		}
		return b;
	}

	public void scrollToElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollToElement(WebElement element,boolean upOrDown) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + upOrDown + ");", element);
	}

	public static boolean isExist(By by) {
		boolean b = true;
		try {
			driver.findElement(by);
			Log.logInfo("找到元素"+by.toString());
		} catch (Exception e) {
			b = false;
			Log.logInfo("未找到元素");
		}
		return b;
	}

	public static Function<WebDriver, Boolean> isPageLoaded() {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
	}

	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(isPageLoaded());
		}catch (UnhandledAlertException e){
			Log.logError("捕捉到异常的Alert,Alert信息为："+e.getAlertText());
		}
	}

	public static Function<WebDriver, Boolean> haveMoreThanOneOption(final By by) {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				WebElement webElement = driver.findElement(by);
				if (webElement == null) {
					return false;
				} else {
					int size = webElement.findElements(By.tagName("option"))
							.size();
					return size >= 1;
				}
			}
		};
	}

	public static void waitForSelectLoad(By by) {
		new WebDriverWait(driver, 10).until(haveMoreThanOneOption(by));
	}

	public static Function<WebDriver, Boolean> haveMoreThanOneOption(
			final List<WebElement> element) {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (element == null) {
					return false;
				} else {
					int size = element.size();
					return size >= 1;
				}
			}
		};
	}

	public static void waitForSelectLoad(List<WebElement> element) {
		new WebDriverWait(driver, 10).until(haveMoreThanOneOption(element));
	}

	public static Function<WebDriver, Boolean> waitForElementExist(final WebElement element) {
		return new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (isExist(element)) {
					return true;
				} else {
					return false;
				}
			}
		};
	}

	public static void waitElementExist(WebElement element) {
		new WebDriverWait(driver, 10).until(waitForElementExist(element));
	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
			Log.logInfo("等待"+time+"秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getStringAfter(String before, String word) {
		int b = before.lastIndexOf(word);
		String result = before.substring(b + word.length());
		return result;
	}
	
	public static String getStringAfter(String before, String start, String end) {
		int b = before.lastIndexOf(start);
		int c = before.lastIndexOf(end);
		String result = before.substring(b + start.length(), c);
		return result;
	}


	public static boolean alertOption(String option){
		Boolean flag=true;
		Alert alert=null;
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions
						.alertIsPresent());
			alert = driver.switchTo().alert();
			Log.logInfo("找到Alert");
		}catch(TimeoutException | NoAlertPresentException |UnhandledAlertException exception){
			flag=false;
			Log.logInfo("未找到Alert");
		}
		if(flag && option.equals("accept")){
			Log.logInfo(alert.getText());
			alert.accept();
			Log.logInfo("接受Alert");
		}else if (flag && option.equals("dismiss")) {
			Log.logInfo(alert.getText());
			alert.dismiss();
			Log.logInfo("拒绝Alert");
		}
		return flag;
	}
}
