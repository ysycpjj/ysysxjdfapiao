package com.young.appiumcombat.pages.ios;

import org.openqa.selenium.WebDriverException;


import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;

public class iOS_InitPage {
	/**初始化页面图片*/
	public static final String INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONTYPE ="iOSUIAutomation";
	public static final String INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONVALUE = ".scrollViews()[0].images()[0]";

	/**设置地区-全国体验版*/
	public static final String INITPAGE_RELATIVELAYOUT_NATIONALVERSION_LOACTIONTYPE ="iOSUIAutomation";
	public static final String INITPAGE_RELATIVELAYOUT_NATIONALVERSION_LOACTIONVALUE = ".tableViews()[0].cells()[5].staticTexts()[0]";
	
	/**设置地区页面标题-设置之后再次打开该页面显示的标题*/
	public static final String  INITPAGE_TESTVIEW_TITLE_LOCATIONTYPE = "iOSUIAutomation";
	public static final String  INITPAGE_TESTVIEW_TITLE_LOCATIONVALUE = ".navigationBars()[0].staticTexts()[0]";
	
	/**首次打开设置地区页面显示的标题*/
	//.tableViews()[0].staticTexts()[0]
	public static final String  INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONTYPE = "iOSUIAutomation";
	public static final String  INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONVALUE = ".tableViews()[0].staticTexts()[0]";
	//.navigationBars()[0].staticTexts()[0]
	
	/**检查初始化页面的图片和翻页元素是否存在*/
	public static void pageViewCorrect(AppiumUtil appiumUtil,int i){
		appiumUtil.waitForElementToLoad(10,INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONTYPE,INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONTYPE,INITPAGE_IMAGVIEW_HELLOIMAGE_LOACTIONVALUE),"经检查：初始化第"+i+"页图片 不存在");

	}
	
	/**翻页*/
	public static void pageFlip(AppiumUtil appiumUtil) {
		appiumUtil.pause(5);
		try{
			appiumUtil.swipeForiOS("Left",300,1);
		}catch(WebDriverException e){
			appiumUtil.logWriter("info", "抛出了WebDriverExeption!");
		}
		
	}

	/**设置为全国体验版*/
	public static void setToNationalVersion(AppiumUtil appiumUtil){
		
		appiumUtil.waitForElementToLoad(10,INITPAGE_RELATIVELAYOUT_NATIONALVERSION_LOACTIONTYPE,INITPAGE_RELATIVELAYOUT_NATIONALVERSION_LOACTIONVALUE);
		appiumUtil.click(appiumUtil.findElement("iOSUIAutomation",INITPAGE_RELATIVELAYOUT_NATIONALVERSION_LOACTIONVALUE));
	}
	/**验证是否是全国体验版*/
	public static void verifyTheVersion(AppiumUtil appiumUtil){
		String value =iOS_HomePage.getCity(appiumUtil);
		System.out.println("value ="+value);
		Assertion.assertTrue(value.trim().equals("全国"),"期望结果是:全国，实际结果为:"+value+";");
		
	}
	/**初始化页面*/
	public static void initPageAndCheckPageView(AppiumUtil appiumUtil){
		for(int i=1;i<3;i++){
			appiumUtil.pause(2);
			iOS_InitPage.pageViewCorrect(appiumUtil, i);
			iOS_InitPage.pageFlip(appiumUtil);
			appiumUtil.pause(2);
		}
		iOS_InitPage.pageViewCorrect(appiumUtil, 3);
		iOS_InitPage.pageFlip(appiumUtil);
		appiumUtil.pause(2); 
		appiumUtil.waitForElementToLoad(10,INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONTYPE,INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONTYPE,INITPAGE_TESTVIEW_FIRSTOPENTITLE_LOCATIONVALUE), "经检查：设置地区页面标题 不存在");
		appiumUtil.pause(2);
		iOS_InitPage.setToNationalVersion(appiumUtil);
		appiumUtil.pause(2);
	}
	

}
