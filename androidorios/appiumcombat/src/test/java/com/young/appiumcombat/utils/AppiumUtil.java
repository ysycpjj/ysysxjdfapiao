package com.young.appiumcombat.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.*;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.android.AndroidElement;




import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author young	
 * @description appium api封装
 * */

public class AppiumUtil {
	
	public static  AppiumDriver<WebElement> driver; 
	public static  ITestResult it;
	/**定义日志输出对象*/
	public static Logger logger = Logger.getLogger(AppiumUtil.class);
	
	/**获取driver
	 * @throws  */
	public AppiumDriver<WebElement> getDriver(String url,DesiredCapabilities capabilities,String platform){
		
			if(platform.equalsIgnoreCase("android")){
				try {
					driver = new AndroidDriver<WebElement>(new URL(url), capabilities);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}else if(platform.equalsIgnoreCase("ios")){
				try {
					driver = new IOSDriver<WebElement> (new URL(url),capabilities);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}else{
				
			}
			return driver;
 
	}
	
	/**退出app*/
	public void closeApp(String appName){
		driver.closeApp();
		logger.info(appName+"已经关闭");
	}
	
	/**退出移动浏览器*/
	public void quit(){
		driver.quit();
		logger.info("driver已被清理");
	}
	/**通过By对象 去查找某个元素*/
	public  WebElement findElement(By by){	
		/*try{
			return driver.findElement(by);
		}catch(NoSuchElementException e){
			logger.info("要找的元素不存在！返回空");
		}
		return null;*/
		return driver.findElement(by);
	}
	
	/**
	 * 通过By对象 去查找一组元素
	 * */
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	/**
	 * 通过xpath 去查找一组元素
	 * */
	public List<WebElement> findElements(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	
	
	/**清空元素内容*/
	public void clear(By byElement){
		WebElement element = findElement(byElement);
		element.clear();
		logger.info("清空元素："+getLocatorByElement(element, ">")+"上的内容");
	}
	/**清空元素内容*/
	public void clear(WebElement element){
		element.clear();
		logger.info("清空元素："+getLocatorByElement(element, ">")+"上的内容");
	}
	
	public void focusOnElement(WebElement element){
		new Actions(driver).moveToElement(element).perform();
		pause(2);
	}
	/**输入内容,可用于Android输入内容，ios不支持*/
	public void typeContent(By byElement,String str){
		WebElement element = findElement(byElement);
		element.sendKeys(str);
		logger.info("在元素："+getLocatorByElement(element, ">")+"输入内容："+str);
	}


	/**输入内容，用于ios输入内容，Android是否支持不确定*/
	public void typeContentForIos(WebElement element,String str){
		((IOSElement)(element)).setValue(str);
		int i=0;
		while(element.getText()==null && i++<5){
			pause(2);
		}
		logger.info("在元素："+getLocatorByElement(element, ">")+"输入内容："+str);
	}
	/**输入内容*/
	public void typeContentForAndroid(WebElement element,String str){
		element.sendKeys(str);
		int i=0;
		System.out.println("content:"+element.getText());
		while(element.getText()=="" && i++<5){
			pause(2);
		}
		logger.info("在元素："+getLocatorByElement(element, ">")+"输入内容："+str);
	}

	/**点击*/
	public void click(By byElement){
		WebElement element = findElement(byElement);
		try{
		element.click();
		logger.info("点击元素："+getLocatorByElement(element, ">"));
		}catch(Exception e){
			logger.error("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
//			Assert.fail("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
		}
		
	}

	/**点击*/
	public void click(WebElement element){
		try{
			element.click();
		logger.info("点击元素："+getLocatorByElement(element, ">"));
		}catch(Exception e){
			logger.error("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
			Assert.fail("点击元素:"+getLocatorByElement(element, ">")+"失败", e);
		}
		
	}
	
	/**点击*/
	public void click( String locateWay,String locateValue){
		try{
			findElement(locateWay,locateValue).click();
		logger.info("点击元素："+locateWay+":"+locateValue);
		}catch(Exception e){
			logger.error("点击元素："+locateWay+":"+locateValue+"失败", e);
			Assert.fail("点击元素："+locateWay+":"+locateValue+"失败", e);
		}
		
	}
	
	/**查找一个元素 - appium新增的查找元素方法*/
	public WebElement findElement(String locateWay,String locateValue){
		WebElement element = null;
	switch(locateWay){
	case "AccessibilityId":
		element = driver.findElementByAccessibilityId(locateValue);
		break;
	case "AndroidUIAutomator":
	    element = ((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator(locateValue);
		break;
	case "ClassName":
		element = driver.findElementByClassName(locateValue);
		break;
	case "CSS":
		element = driver.findElementByCssSelector(locateValue);
		break;
	case "ID":
		element = driver.findElementById(locateValue);
		break;
	case "LinkText":
		element = driver.findElementByLinkText(locateValue);
		break;
	case "Name":
		element = driver.findElementByName(locateValue);
		break;
	case "PartialLinkText":
		element = driver.findElementByPartialLinkText(locateValue);
		break;
	case "TagName":
		element = driver.findElementByTagName(locateValue);
		break;
	case "Xpath":
		element = driver.findElementByXPath(locateValue);
		break;
	case "iOSUIAutomation":
		element = ((IOSDriver<WebElement>)driver).findElementByIosUIAutomation(locateValue);
		break;
	default:
		logger.error("定位方式："+locateWay+"不被支持");
//		Assert.fail("定位方式："+locateWay+"不被支持");
		
		}
	return element;

	}
	
	/**查找一组元素 - appium新增的查找元素方法*/
	public List<?> findElements(String locateWay,String locateValue){
		List<?> element=null;
	switch(locateWay){
		
	case "AccessibilityId":
		element = driver.findElementsByAccessibilityId(locateValue);
		break;
	case "AndroidUIAutomator":
		element = ((AndroidDriver<?>)driver).findElementsByAndroidUIAutomator(locateValue);
	     break;
	case "ClassName":
		element = driver.findElementsByClassName(locateValue);
		break;
	case "CSS":
		element = driver.findElementsByCssSelector(locateValue);
		break;
	case "ID":
		element = driver.findElementsById(locateValue);
		break;
	case "LinkText":
		element = driver.findElementsByLinkText(locateValue);
		break;
	case "Name":
		element = driver.findElementsByName(locateValue);
		break;
	case "PartialLinkText":
		element = driver.findElementsByPartialLinkText(locateValue);
		break;
	case "TagName":
		element = driver.findElementsByTagName(locateValue);
		break;
	case "Xpath":
		element = driver.findElementsByXPath(locateValue);
		break;
	case "iOSUIAutomation":
		element = ((IOSDriver<?>)driver).findElementsByIosUIAutomation(locateValue);
		break;
	default:
		logger.error("定位方式："+locateWay+"不被支持");
		Assert.fail("定位方式："+locateWay+"不被支持");
		
		}
	return element;

	}
	
	/**获取文本1*/
	public String getText(By by){
		return findElement(by).getText().trim();
	}
	/**获取文本3*/
	public String getText(String xpath){
		return findElement(By.xpath(xpath)).getText().trim();
	}
	
	/**获取文本2*/
	public String getText(String locateWay,String locateValue){
		String str="";
	switch(locateWay){
		
	case "AccessibilityId":
		str = driver.findElementByAccessibilityId(locateValue).getText().trim();
		break;
	case "AndroidUIAutomator":
		str = ((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator(locateValue).getText().trim();
			break;
	case "iOSUIAutomation":
		str = ((IOSDriver<WebElement>)driver).findElementByIosUIAutomation(locateValue).getText().trim();
			break;
	case "ClassName":
		str = driver.findElementByClassName(locateValue).getText().trim();
		break;
	case "CSS":
		str = driver.findElementByCssSelector(locateValue).getText().trim();
		break;
	case "ID":
		str = driver.findElementById(locateValue).getText().trim();
		break;
	case "LinkText":
		str = driver.findElementByLinkText(locateValue).getText().trim();
		break;
	case "Name":
		str = driver.findElementByName(locateValue).getText().trim();
		break;
	case "PartialLinkText":
		str = driver.findElementByPartialLinkText(locateValue).getText().trim();
		break;
	case "TagName":
		str = driver.findElementByTagName(locateValue).getText().trim();
		break;
	case "Xpath":
		str = driver.findElementByXPath(locateValue).getText().trim();
		break;
	default:
		logger.error("定位方式："+locateWay+"不被支持");
		Assert.fail("定位方式："+locateWay+"不被支持");
		
		}
	return str;

	}
	
	/**提交*/
	public void submit(By by){
		WebElement element=findElement(by);
		try{
			element.submit();
		}catch(Exception e){
			logger.error("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
			Assert.fail("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
		}
		logger.info("在元素："+getLocatorByElement(element, ">")+"做了提交操作");
	}
	
	/**提交*/
	public void submit(WebElement element){
		try{
			element.submit();
		}catch(Exception e){
			logger.error("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
			Assert.fail("在元素："+getLocatorByElement(element, ">")+"做的提交操作失败",e);
		}
		logger.info("在元素："+getLocatorByElement(element, ">")+"做了提交操作");
	}
	
	/**
	 * 获得webview页面的标题
	 * */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * 获得元素 属性的文本
	 * */
	public String getAttributeText(By elementLocator, String attribute) {
		return findElement(elementLocator).getAttribute(attribute).trim();
	}
	
	/**
	 *Func 1: 在给定的时间内去查找元素，如果没找到则超时，抛出异常,传入的为：by 对象
	 * */
	public void waitForElementToLoad(int elementTimeOut, final By By) {
		boolean flag=true;
		logger.info("开始查找元素[" + By + "]");
		try {
			(new WebDriverWait(driver, elementTimeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			flag = false;
			logger.error("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + By + "]");
//			Assert.fail("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + By + "]");

		}
		if(flag)
			logger.info("找到了元素 [" + By + "]");
	}


	/**
	 *Func 2: 在给定的时间内去查找元素，使用ios uiautomator来查找元素，如果没找到则超时，抛出异常,传入的为：查找方式和元素的值
	 * */
	public  void waitForElementToLoad(int elementTimeOut, final String locateWay, final String locateValue){
		boolean flag=true;
		logger.info("开始查找元素[" + locateValue + "]");
		try {
			(new WebDriverWait(driver, elementTimeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = findElement(locateWay,locateValue);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			flag = false;
			logger.error("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + locateValue + "]");
//			Assert.fail("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + By + "]");

		}
		if(flag)
			logger.info("找到了元素 [" + locateValue + "]");
	}

	
	/**
	 *Func 3: 在给定的时间内去查找元素，如果没找到则超时，抛出异常,传入的为：xpath
	 * */
	public void waitForElementToLoad(int elementTimeOut, final String xpath) {
		boolean flag=true;
		logger.info("开始查找元素[" + xpath + "]");
		try {
			(new WebDriverWait(driver, elementTimeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By.xpath(xpath));
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			flag=false;
			logger.error("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + xpath + "]");
//			Assert.fail("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + xpath + "]");

		}
		if(flag)
			logger.info("找到了元素 [" + xpath + "]");
	}
	
	/**
	 * 判断文本是不是和需求要求的文本一致
	 * **/
	public void isTextCorrect(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			logger.error("期望的文字是 [" + expected + "] 但是找到了 [" + actual + "]");
			Assert.fail("期望的文字是 [" + expected + "] 但是找到了 [" + actual + "]");

		}
		logger.info("找到了期望的文字: [" + expected + "]");

	}
	
	/**
	 * 暂停当前用例的执行，暂停的时间为：sleepTime
	 * */
	public void pause(int sleepTime) {
		if (sleepTime <= 0) {
			return;
		}
		try {
			TimeUnit.SECONDS.sleep(sleepTime); 
			logger.info("暂停:"+sleepTime+"秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/** 根据元素来获取此元素的定位值 */
	public String getLocatorByElement(WebElement element, String expectText) {
		String text = element.toString();
		String expect = null;
		try {
			expect = text.substring(text.indexOf(expectText) + 1, text.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to find the string [" + expectText + "]");
		}

		return expect;

	}
	
	
	/**
	 * 判断实际文本时候包含期望文本
	 * 
	 * @param actual
	 *            实际文本
	 * @param expect
	 *            期望文本
	 */
	public void isContains(String actual, String expect) {
		try {
			Assert.assertTrue(actual.contains(expect));
		} catch (AssertionError e) {
			logger.error("The [" + actual + "] is not contains [" + expect + "]");
			Assert.fail("The [" + actual + "] is not contains [" + expect + "]");
		}
		logger.info("The [" + actual + "] is contains [" + expect + "]");
	}
	
	
	/**
	 * Func 2:判断实际文本时候包含期望文本，忽略大小写
	 * 
	 * @param actual
	 *            实际文本
	 * @param expect
	 *            期望文本
	 */
	public void isContainsIgnoreCase(String actual, String expect) {
		
		String actualToLowerCase = actual.toLowerCase();
		String expectToLowerCase =expect.toLowerCase();
		try {
			Assert.assertTrue(actualToLowerCase.contains(expectToLowerCase));
		} catch (AssertionError e) {
			logger.error("The [" + actual + "] is not contains [" + expect + "]");
			Assert.fail("The [" + actual + "] is not contains [" + expect + "]");
		}
		logger.info("The [" + actual + "] is contains [" + expect + "]");
	}
	
	/**跳转到webview页面*/
	public void switchWebview(int index){
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
		System.out.println(context); 
		//打印出来看看有哪些context
		}
		driver.context((String) contexts.toArray()[index]);
		
	}
	
	
	/**跳转到webview页面*/
	public void switchWebview(String contextName){
		try{
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
		System.out.println(context); 
		//打印出来看看有哪些context
		}
		driver.context(contextName);
		}catch(NoSuchContextException nce){
			logger.error("没有这个context:"+contextName, nce);
			Assert.fail("没有这个context:"+contextName, nce);
		}
		
	}
	

	/**跳转到webview页面-不完整的contextName*/
	public void switchWebviewByKeyWord(String keyWord){
		try{
		Set<String> contexts = driver.getContextHandles();
		pause(2);
		for (String context : contexts) {
			pause(2);
			System.out.println(context); 
			if(context.contains(keyWord))
				driver.context(context);
		//打印出来看看有哪些context
		}
//		driver.context(contextName);
		}catch(NoSuchContextException nce){
			logger.error("没有这个context:"+keyWord, nce);
//			Assert.fail("没有这个context:"+contextName, nce);
		}
		logger.info("切入context:"+keyWord);
	}
	

	/**
	 * 执行JavaScript 方法
	 * */
	public void executeJS(String js) {
		((JavascriptExecutor) driver).executeScript(js);
		logger.info("执行JavaScript语句：[" + js + "]");
	}
	
	/**
	 * 执行JavaScript 方法和对象 
	 * 用法：seleniumUtil.executeJS("arguments[0].click();", seleniumUtil.findElementBy(MyOrdersPage.MOP_TAB_ORDERCLOSE));
	 * */
	public void executeJS(String js, Object... args) {
		((JavascriptExecutor) driver).executeScript(js, args);
		logger.info("执行JavaScript语句：[" + js + "]");
	}
	
	/**检查元素是不是存在*/
	public  boolean doesElementsExist(By byElement){
		try{
			findElement(byElement);
			return true;
		}catch(NoSuchElementException nee){
			return false;
		}
		
		
	}
	/**检查元素是不是存在,传入定位方式和值*/
	public  boolean doesElementsExist(String locateWay,String locateValue){
		try{
			findElement(locateWay,locateValue);
			return true;
		}catch(NoSuchElementException nee){
			return false;
		}


	}
	/**长按操作*/
	public void longPress(By by){
		TouchAction tAction=new TouchAction(driver);
		tAction.longPress(findElement(by)).perform();
	}
	
	/**滑动*/
	public void swipe(int beginX,int beginY,int endX,int endY){
		TouchAction tAction=new TouchAction(driver);
		try{
		tAction.press(beginX,beginY).moveTo(endX,endY).release().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**滚动 - 根据文本模糊匹配*/
	public void scroll(String text){
		driver.scrollTo(text);
	}
	
	/**滚动 - 根据文本精准匹配*/
	public WebElement scrollExact(String text){
		return driver.scrollToExact(text);
	} 
	
	/**拖拽操作*/
	public void DragAndDrop(By dragElement,By dropElement){
		TouchAction act=new TouchAction(driver);
		act.press(findElement(dragElement)).perform();
		act.moveTo(findElement(dropElement)).release().perform();
	}
	
	/**放大和缩小*/
	public void zoomAndPinch(int beginX,int beginY,int endX,int endY){
	   int scrHeight = driver.manage().window().getSize().getHeight();
	   int scrWidth = driver.manage().window().getSize().getWidth();
		MultiTouchAction multiTouch = new MultiTouchAction(driver);
		TouchAction tAction0 = new TouchAction(driver);
		TouchAction tAction1 = new TouchAction(driver);
		tAction0.press(scrWidth/2,scrHeight/2).waitAction(1000).moveTo(beginX,beginY).release();
		tAction1.press(scrWidth/2,scrHeight/2+40).waitAction(1000).moveTo(endX,endY).release();
		multiTouch.add(tAction0).add(tAction1);
		multiTouch.perform();

	}
	
	/**app置于后台运行*/
	public void runBackgound(int runTimes){
		driver.runAppInBackground(runTimes);
		
	}
	
	/**收起键盘*/
	public void hideKeyboard(){
		driver.hideKeyboard();
		logger.info("虚拟键盘已经收起");
		
	}
	
	/**安装app*/
	public void instalApp(String appPath){
		try{
		driver.installApp(appPath);
		}catch(Exception e){
			logger.error("app安装失败",e);
			Assert.fail("app安装失败",e);
		}
	}
	
	/**app是否安装*/
	public boolean isAppInstalled(String appPackage){
		
		if(driver.isAppInstalled(appPackage)){
			logger.info(appPackage+":已经安装");
			return true;
		}else {
			logger.info(appPackage+":未安装");
			return false;
		}
	}
	
	/**页面过长时候滑动页面 window.scrollTo(左边距,上边距); */
	public void scrollPage(int x,int y){
		String js ="window.scrollTo("+x+","+y+");";
	    ((JavascriptExecutor)driver).executeScript(js);
	}
	
	/***/
	public void handleAlert(String handleStrategy){
		Alert a = ((IOSDriver<WebElement>)driver).switchTo().alert();
		if(handleStrategy.equalsIgnoreCase("yes")){
			a.accept();
			logger.info("接受了alert");
		}else if(handleStrategy.equalsIgnoreCase("no")){
			a.dismiss();
			logger.info("忽略了alert");
		}else{
			logger.error("处理alert的策略不对，只能是yes或者no,你选择的是："+handleStrategy);
			Assert.fail("处理alert的策略不对，只能是yes或者no,你选择的是："+handleStrategy);
		}
	}

	/**检查是否存在alert，如果在，接受或拒绝*/
	public boolean doesAlertExist(String handleStrategy){
//		Alert a = ((IOSDriver<WebElement>)driver).switchTo().alert();
		try{
			Alert a = driver.switchTo().alert();
			if(handleStrategy.equalsIgnoreCase("yes")){
				a.accept();
				logger.info("接受了alert");
			}else if(handleStrategy.equalsIgnoreCase("no")){
				a.dismiss();
				logger.info("忽略了alert");
			}else{
				logger.error("处理alert的策略不对，只能是yes或者no,你选择的是："+handleStrategy);
				Assert.fail("处理alert的策略不对，只能是yes或者no,你选择的是："+handleStrategy);
			}
			return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}
	
	/** 
	 * 向左滑动，适用于ios，ios模拟器大小基本与实际分别率相同,swipe方法自1.5之后，参数为：起始位置x,y,移动量x,y,时间
	 * @param during
	 * @param num 
	 * @throws InterruptedException 
	 */  
	public  void swipeForiOS(String direction,int during, int num)  {
		int width=driver.manage().window().getSize().width;
	    int height=driver.manage().window().getSize().height;  
	    System.out.println("width:"+width+";height"+height);
		int[] leftPoint ={(int)(width *1/ 6.0)+5,(int)( height / 2.0)};
		int[] rightPoint ={(int)(width *5/ 6.0)+5,(int)( height / 2.0)};
		int[] upPoint ={(int)(width *1/ 2.0),(int)( height *1/ 6.0)-5};
		int[] downPoint ={(int)(width *1/ 2.0),(int)( height *5/6.0)+5};
	    int moveDuration =(int)(width * 2 / 3.0)-5;
	    int[] moveFrom;
		for (int i = 0; i < num; i++) {
			pause(3);
			switch (direction) {
				case "Up":
					moveFrom = downPoint;
					System.out.println("moveFrom:x="+moveFrom[0]+",y="+ moveFrom[1]+"moveDuration =:"+moveDuration);
					driver.swipe(moveFrom[0], moveFrom[1], 0, moveDuration * -1, during);
					break;
				case "Down":
					moveFrom = upPoint;
					System.out.println("moveFrom:x="+moveFrom[0]+",y="+ moveFrom[1]+"moveDuration =:"+moveDuration);
					driver.swipe(moveFrom[0], moveFrom[1], 0, moveDuration, during);
					break;
				case "Left":
					moveFrom = rightPoint;
					System.out.println("moveFrom:x="+moveFrom[0]+",y="+ moveFrom[1]+"moveDuration =:"+moveDuration);
					driver.swipe(moveFrom[0], moveFrom[1], moveDuration * -1, 0, during);
					break;
				case "Right":
					moveFrom = leftPoint;
					System.out.println("moveFrom:x="+moveFrom[0]+",y="+ moveFrom[1]+"moveDuration =:"+moveDuration);
					driver.swipe(moveFrom[0], moveFrom[1], moveDuration, 0, during);
					break;
			}

		}
		pause(3);
	}
	/**
	 * 用于WebVIEW元素，滚动到元素，传入的为：webElement
	 * */
	public void scrollToWebElement(WebElement element){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	/**
	 * 用于滚动到WebElement，传入的为：By对象
	 * */
	public void scrollToWebElement(By by){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(by));
	}

	
	
	/**安卓的滑动操作，根据页面元素计算窗口大小，再滑动指定方向*/
	public void swipForAndroid(String direction,WebElement element) throws WebDriverException{
		int [] size = getWinSizeFromElement(element);
		System.out.println("win width="+size[0]+";height ="+size[1]);
		int[] leftPoint ={(int)(size[0] *1/ 10.0)>50?50:(int)(size[0] *1/ 10.0),(int)( size[1] / 2.0)};
		int[] rightPoint ={leftPoint[0]==50?size[0]-50:(int)(size[0] *9/ 10.0),(int)( size[1] / 2.0)};
		//需要再调试下
		int[] upPoint ={(int)(size[0] *1/ 2.0),(int)( size[1] *1/ 10.0)>50?50:(int)( size[1] *1/ 10.0)};
		int[] downPoint ={(int)(size[0] *1/ 2.0), size[1]-(int)( size[1] *9/10.0)>50? size[1]-50:(int)( size[1] *9/10.0)};
		pause(3);
		TouchAction tAction=new TouchAction(driver);
		switch(direction){
		case "Left":
			pause(5);
			System.out.println("FromX ="+rightPoint[0]+"FromY="+rightPoint[1]+";TOX ="+leftPoint[0]+"ToY="+leftPoint[1]);
			tAction.press(rightPoint[0],rightPoint[1]).waitAction(1000).moveTo(leftPoint[0],leftPoint[1]).release();
			pause(1);
			tAction.perform();
			pause(3);
			break;
		case "Right":
			pause(3);
			tAction.press(leftPoint[0],leftPoint[1]).waitAction(800).moveTo(rightPoint[0],rightPoint[1]).release();
			pause(1);
			tAction.perform();
			pause(3);
			break;
		case "Up":
			pause(3);
			//225,575  225,115
			tAction.press(200,500).waitAction(800).moveTo(200,10).release().perform();
//			tAction.press(downPoint[0],downPoint[1]).waitAction(800).moveTo(upPoint[0],upPoint[1]).release();
			pause(1);
			tAction.perform();
			pause(3);
			break;
		case "Down":
			pause(3);
			tAction.press(upPoint[0],upPoint[1]).waitAction(800).moveTo(downPoint[0],downPoint[1]).release();
			pause(1);
			tAction.perform();
			pause(3);
			break;
		default :
			System.out.println("The direction is illegal");
			break;
		}

	}
	
	/**向左滑动，模拟器Device为：480*800,实际显示尺度无法确定，故此只实现了整个页面左右滑动，坐标写死*//*
	public void swipByTouchAction(String direction) throws WebDriverException{
		pause(5);
		TouchAction tAction=new TouchAction(driver);
		switch(direction){
		case "Left":
			pause(5);
			tAction.press(350,500).waitAction(1000).moveTo(50,500).release().perform();
			pause(5);
			break;
		case "Right":
			pause(3);
			tAction.press(10,500).waitAction(800).moveTo(400,500).release().perform();
			pause(1);
			break;
		case "Up":
			pause(3);
			tAction.press(200,500).waitAction(800).moveTo(200,10).release().perform();
			pause(1);
			break;
		case "Down":
			pause(3);
			tAction.press(200,10).waitAction(800).moveTo(200,500).release().perform();
			pause(1);
			break;
		default :
			System.out.println("The direction is illegal");
			break;
		}

	}
*/
	/**写入日志操作*/
	public void logWriter(String logLevel,String logMessage){
		switch(logLevel){
		case "info":
			logger.info(logMessage);
			break;
		case "error":
			logger.error(logMessage);
			break;
		case "warn":
			logger.warn(logMessage);
			break;
		default :
			logger.info("日志级别不合法，写入日志信息："+logMessage+" 失败");
			break;
		}
	}
	/**根据页面元素获取页面大小，因为安卓，使用driver获取的是分别率，不是实际的dp,主要用于Android*/
	public int[] getWinSizeFromElement(WebElement element){
		  Dimension dimension = element.getSize();
		  int[] size = {dimension.width,dimension.height};
		  return size;
	}
	/**根据页面元素获取页面大小，主要用于Android*/
	public int[] getWinSizeFromElement(By by){
		  Dimension dimension = findElement(by) .getSize();
		  int[] size = {dimension.width,dimension.height};
		  return size;
	}
	
	
	public void installIOSAPP(String appFunPath) throws IOException{
		Runtime.getRuntime().exec("xcrun simctl install booted "+appFunPath);
		
	}
	
	public void uninstallIOSAPP(String appPackage) throws IOException{
		Runtime.getRuntime().exec("xcrun simctl uninstall booted "+appPackage);
	}
	
	public void installAndroidAPP(String appFunPath){
		if(driver.isAppInstalled(appFunPath))
			logWriter("info","APP 已经安装");
		else
			driver.installApp(appFunPath);
	}
	
	
	public void uninstallAndroidAPP(String appPackage){
		driver.removeApp(appPackage);
	}
	
	public void pressKey(Keys key) {
	    Actions builder = new Actions(driver);
		Action action = builder.sendKeys(key).build();
		action.perform();
		System.out.println("Pressed Enter \"" + key + "\" key");
	}
	
	
}
