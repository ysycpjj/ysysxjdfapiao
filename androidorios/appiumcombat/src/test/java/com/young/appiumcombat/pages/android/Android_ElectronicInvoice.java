package com.young.appiumcombat.pages.android;


import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;


//com.young.appiumcombat.testcases.android.electronicinvoice
public class Android_ElectronicInvoice {
	/**电票开通：webView*/
	public static final By ELECTRONICINVOICE_WBNVIEW_PAGEVIEW = By.className("android.webkit.WebView");
	/**电票开通-webView:页面标题*/
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATION= "AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATEVALUE  ="电票开通";

	/**电票开通-webView：介绍*/
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATETYPE ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE="首家";
	/**电票开通-webView：中心图片*/
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON_LOCATETYPE ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON ="tu";	
	/**电票开通-webView：电票开通按钮*/
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATETYPE = "AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATEVALYE="申请开通电子发票服务";
	
	/**电票开通，整个页面CONTENT元素，用于获取页面大小*/
//	public static final String ELECTRONICINVOICE_FrameLayout_Page_LOCATETYPE ="ClassName";
//	public static final String ELECTRONICINVOICE_FrameLayout_Page_LOCATEVALUE  ="android.widget.FrameLayout";
	public static final By ELECTRONICINVOICE_IFREAMFORM_PAGELOCATION =By.className("handleForm");
	public static final By ELECTRONICINVOICE_IFREAM_THIRDPARTYPAGE = By.id("mkinCUfRZMa");

	/**电票开通-webview-提交表单*/
//	public static final String ELECTRONICINVOICE_WBNVIEWINPUT_LIST_LOCATETYPE ="ClassName";
//	public static final String ELECTRONICINVOICE_WBNVIEWINPUT_LIST_LOCATEVALUE ="android.widget.EditText";
	public static final By ELECTRONICINVOICE_WBNVIEWINPUT_LIST=By.xpath("//input[@class='fbi_input']");
	/**电票开通-确认提交-WebVeiw中查找的方法*/
	public static final By ELECTRONICINVOICE_WEBVIEWA_SUBMIT=By.id("form_submit");
	/**该元素在Navite_APP中的查找方法*/
	public static final String ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_LOCATION= "AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_VALUE= "确认提交";
	/**提交结果-提交结果*/
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATION  ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_VALUE  ="提交成功！";
	/**提交结果-返回提交申请页*/
	public static final String ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATION  ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_VALUE  ="返回";
	/**提交结果-返回主页*/
	public static final String ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATETYPE ="AccessibilityId";
	public static final String ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATEVALUE="back";
	
	public static void switchWebView(AppiumUtil appiumUtil){
		appiumUtil.switchWebviewByKeyWord("WEBVIEW_com.ysyc.itaxer");
		appiumUtil.pause(2);
		
	}
	public static void switchNative(AppiumUtil appiumUtil){
		appiumUtil.switchWebviewByKeyWord("NATIVE_APP");
		appiumUtil.pause(2);
	}
	public static boolean isInElectronicInvoicePage(AppiumUtil appiumUtil){
		 appiumUtil.pause(2);
		 return appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEW_PAGEVIEW);
				
	}
	
	public static void introducePageUICheck(AppiumUtil appiumUtil){
		appiumUtil.click(ELECTRONICINVOICE_WBNVIEW_PAGEVIEW);
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10,ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATION,ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATEVALUE );
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATION,ELECTRONICINVOICE_WBNVIEWDIV_PAGETITLE_LOCATEVALUE), "经检查：电票开通-WebView-页面标题不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE), "经检查：电票开通-WebView-公司介绍不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_CNETERICON), "经检查：电票开通-WebView-页面图片不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATEVALYE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATEVALYE), "经检查：电票开通-WebView-开通电票按钮不存在");
	}
	public static void submitPageUICheck(AppiumUtil appiumUtil){
		appiumUtil.pause(4);
		List<WebElement> list =(List<WebElement>) appiumUtil.findElements(ELECTRONICINVOICE_WBNVIEWINPUT_LIST);
		for(int i=0;i<list.size();i++){
			WebElement element = list.get(i);
			appiumUtil.logWriter("info","第"+i+"个元素是否显示："+element.isDisplayed()+";是否可用："+element.isEnabled());
			
		}
		Assertion.assertTrue(list.size()==5, "经检查：显示的列表项不足五项");
	}
	
	public static void enableElectronicInvoice(AppiumUtil appiumUtil,String[] value){
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATEVALYE);
		appiumUtil.click(ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_FOOTERENABLE_LOCATEVALYE);
		appiumUtil.pause(3);
		switchWebView(appiumUtil);
		String source =appiumUtil.driver.getPageSource();
		appiumUtil.pause(2);
		WebElement ifream  = appiumUtil.findElement(ELECTRONICINVOICE_IFREAM_THIRDPARTYPAGE);
		appiumUtil.driver.switchTo().frame(ifream);
		appiumUtil.pause(2);
		String ifreamSource =appiumUtil.driver.getPageSource();
		submitPageUICheck(appiumUtil);
		List<WebElement> list =(List<WebElement>) appiumUtil.findElements(ELECTRONICINVOICE_WBNVIEWINPUT_LIST);
		for(int i=0;i<list.size();i++){
			appiumUtil.pause(1);
			appiumUtil.focusOnElement(list.get(i));
			appiumUtil.pause(2);
			appiumUtil.typeContentForAndroid(list.get(i),value[i] );
			appiumUtil.pause(3);
		}
		appiumUtil.pause(2);
		appiumUtil.scrollToWebElement(ELECTRONICINVOICE_WEBVIEWA_SUBMIT);
		appiumUtil.pause(3);
		WebElement element = appiumUtil.findElement(ELECTRONICINVOICE_WEBVIEWA_SUBMIT);
		appiumUtil.findElement(ELECTRONICINVOICE_WEBVIEWA_SUBMIT).click();
		appiumUtil.pause(3);
	}
	
	public static boolean  verifySubmitResult(AppiumUtil appiumUtil){
		switchNative(appiumUtil);
		try{
			appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATION,ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_VALUE);
		}catch(WebDriverException e){
			return false;
		}
		return true;
		
	}
	
/*	public static void   backToSumitInvoiceApplyPage(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.click(appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATION, ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_VALUE));
		appiumUtil.pause(2);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_LOCATION,ELECTRONICINVOICE_WBNVIEWA_CONFIMSUBMIT_VALUE),"经检查：未成功提交申请页");
		
	}*/
	
	public static void   backToHomePage(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.click(ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATEVALUE);
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, Android_HomePage.HOMEPAGE_TEXTVIEW_CITY);
		Assertion.assertTrue(appiumUtil.doesElementsExist(Android_HomePage.HOMEPAGE_TEXTVIEW_CITY),"经检查：未成功返回主页");
		
	}
	
}
