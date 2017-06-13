package com.young.appiumcombat.pages.android;

import org.openqa.selenium.By;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;

public class Android_ApplyTaxPage {

	/**申报缴税页标题*/
	public static final By APPLYTAX_TETVIEW_TITLE = By.id("com.ysyc.itaxer:id/title");
	/**申报缴税-中心图片*/
	public static final By APPLYTAX_WEBVIEWIMG_CENTORIMG =By.className("img_box");
	/**申报缴税-内容信息*/
	public static final By APPLYTAX_WEBVIEWIMG_CONTENT = By.className("btn_wrap");
	/**申报缴税-内容信息-前置部分*/
	public static final By APPLYTAX_WEBVIEWIMG_CONTENTPRE = By.id("province");
	/**申报缴税-内容信息-统计数量*/
	public static final By APPLYTAX_WEBVIEWIMG_CONTENTCOUNT = By.id("count");
	/**申报缴税页面'我也想用此功能'按钮*/
	public static final By APPLYTAX_WEBCIEWA_APPLYBUTTON =By.id("vote");
	/**申报缴税-返回主页*/
	public static final By APPLYTAX_IMGBUTTON_BACKTOHOME = By.id("com.ysyc.itaxer:id/left");
			
	public static void applyTaxUICHeck(AppiumUtil appiumUtil){
		appiumUtil.waitForElementToLoad(10, APPLYTAX_TETVIEW_TITLE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(APPLYTAX_TETVIEW_TITLE)
				&& appiumUtil.getText(APPLYTAX_TETVIEW_TITLE).equals("申报缴税")
				, "经检查：申报缴税页标题 不存在");
		appiumUtil.pause(2);
		appiumUtil.switchWebviewByKeyWord("WEBVIEW_com.ysyc.itaxer");
		appiumUtil.pause(1);
		String source = appiumUtil.driver.getPageSource();
		appiumUtil.waitForElementToLoad(10, APPLYTAX_WEBVIEWIMG_CENTORIMG);
		Assertion.assertTrue(appiumUtil.doesElementsExist(APPLYTAX_WEBVIEWIMG_CENTORIMG),"经检查：申报缴税页面中心图片 不存在");
		appiumUtil.waitForElementToLoad(10, APPLYTAX_WEBVIEWIMG_CONTENT);
		Assertion.assertTrue(appiumUtil.doesElementsExist(APPLYTAX_WEBVIEWIMG_CONTENT),"经检查：申报缴税页面内容信息 不存在");
		appiumUtil.waitForElementToLoad(10, APPLYTAX_WEBCIEWA_APPLYBUTTON);
		Assertion.assertTrue(appiumUtil.doesElementsExist(APPLYTAX_WEBCIEWA_APPLYBUTTON),"经检查：申报缴税页面'我也想用此功能'按钮 不存在");
	}
	public static void checkContent(AppiumUtil appiumUtil){
		String content = appiumUtil.getText(APPLYTAX_WEBVIEWIMG_CONTENT);
		String contentPre =  appiumUtil.getText(APPLYTAX_WEBVIEWIMG_CONTENTPRE);
		String contentCount = appiumUtil.getText(APPLYTAX_WEBVIEWIMG_CONTENTCOUNT);
		Assertion.assertTrue(content!=null &&contentPre!=null && Integer.parseInt(contentCount)>0 , "经检查：申报缴税页面内容信息 不完整");
		
	}
	
	public static void wantToUseThisFunction(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.findElement(APPLYTAX_WEBCIEWA_APPLYBUTTON).click();
		appiumUtil.pause(2);
		Assertion.assertTrue(appiumUtil.findElement(APPLYTAX_WEBCIEWA_APPLYBUTTON).isEnabled()==false,"经检查：点击‘我也想用’按钮后，按钮未灰掉");
	}
	
	public static void backToHome(AppiumUtil appiumUtil){
		appiumUtil.switchWebviewByKeyWord("NATIVE_APP");
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, APPLYTAX_IMGBUTTON_BACKTOHOME);
		appiumUtil.click(APPLYTAX_IMGBUTTON_BACKTOHOME);
		appiumUtil.waitForElementToLoad(10, Android_HomePage.HOMEPAGE_TEXTVIEW_CITY);
		Assertion.assertTrue(appiumUtil.doesElementsExist(Android_HomePage.HOMEPAGE_TEXTVIEW_CITY),"经检查：未成功返回主页");
	}
}
