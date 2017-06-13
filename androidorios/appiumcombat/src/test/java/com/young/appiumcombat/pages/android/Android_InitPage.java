package com.young.appiumcombat.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;


import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;
import org.openqa.selenium.WebElement;

public class Android_InitPage {
	/**权限设置dialog*/
	public static final By INITPAGE_DIALOG_PREMISSION = By.id("com.android.packageinstaller:id/dialog_container");
	/**权限设置-接受按钮*/
	public static final By INITPAGE_BUTTON_PREMISSIONALLOW = By.id("com.android.packageinstaller:id/permission_allow_button");
	/**初始化页面图片*/
	public static final By INITPAGE_IMAGVIEW_HELLO = By.id("com.ysyc.itaxer:id/iv");
	/**初始化页面翻页图标*/
	public static final By INITPAGE_IMAGVIEW_PAGEFLIP =By.id("com.ysyc.itaxer:id/guid_ll");
	/**设置地区-全国体验版*/
	public static final By INITPAGE_RELATIVELAYOUT_NATIONALVERSION = By.id("com.ysyc.itaxer:id/rlGlobal");
	/**设置地区页面标题*/
	public static final By INITPAGE_TESTVIEW_TITLE = By.id("com.ysyc.itaxer:id/title");


	/**真机需要设置权限*/
	public static void premissionAllow(AppiumUtil appiumUtil){
		while(true){
			try {
				WebElement element = appiumUtil.findElement(INITPAGE_DIALOG_PREMISSION);
				appiumUtil.click(INITPAGE_BUTTON_PREMISSIONALLOW);
				appiumUtil.pause(2);
				appiumUtil.logWriter("info","权限项设置成功");
			}catch (NoSuchElementException e){
				appiumUtil.logWriter("info","不需要设置权限或权限已设置成功");
				break;
			}
		}

	}
	
	/**检查初始化页面的图片和翻页元素是否存在*/
	public static void pageViewCorrect(AppiumUtil appiumUtil,int i){
		appiumUtil.waitForElementToLoad(10, INITPAGE_IMAGVIEW_HELLO);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_IMAGVIEW_HELLO),"经检查：初始化第"+i+"页图片 不存在"); 
		appiumUtil.waitForElementToLoad(10, INITPAGE_IMAGVIEW_PAGEFLIP);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_IMAGVIEW_PAGEFLIP),"经检查：初始化第"+i+"页翻页图标 不存在");
	}
	
	/**翻页*/
	public static void pageFlip(AppiumUtil appiumUtil) {
		//向左滑动一次
		appiumUtil.pause(3);
		try{
			appiumUtil.swipForAndroid("Left",appiumUtil.findElement( INITPAGE_IMAGVIEW_HELLO));
		}catch(WebDriverException e){
			appiumUtil.logWriter("info", "抛出了WebDriverExeption!");
			System.out.println("抛出了WebDriverExeption!");
		}
		
	}
	
	public static void setToNationalVersion(AppiumUtil appiumUtil){
		appiumUtil.waitForElementToLoad(20, INITPAGE_RELATIVELAYOUT_NATIONALVERSION);
		appiumUtil.click(INITPAGE_RELATIVELAYOUT_NATIONALVERSION);
	}
	
	public static void verifyTheVersion(AppiumUtil appiumUtil){
		String value =Android_HomePage.getCity(appiumUtil);
		System.out.println("value ="+value);
		Assertion.assertTrue(value.trim().equals("全国"),"期望结果是:全国，实际结果为:"+value+";");
		
	}
	
	public static void initPageAndCheckPageView(AppiumUtil appiumUtil){
		for(int i=1;i<3;i++){
			appiumUtil.pause(2);
			Android_InitPage.pageViewCorrect(appiumUtil, i);
			Android_InitPage.pageFlip(appiumUtil);
			appiumUtil.pause(2);
		}
		Android_InitPage.pageViewCorrect(appiumUtil, 3);
		Android_InitPage.pageFlip(appiumUtil);
		appiumUtil.pause(2); 
		Android_InitPage.setToNationalVersion(appiumUtil);
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, INITPAGE_TESTVIEW_TITLE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_TESTVIEW_TITLE), "经检查：设置地区页面标题 不存在");
		
	}
	

}
