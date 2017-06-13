package com.young.appiumcombat.pages.ios;

import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;


//com.young.appiumcombat.testcases.android.electronicinvoice
public class iOS_ElectronicInvoice {
	/**电票开通：webView*/
//	public static final By ELECTRONICINVOICE_WBNVIEW_PAGEVIEW = By.className("android.webkit.WebView");
	
	/**电票开通-webView:页面标题*/
	public static final String ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATETYPE  ="iOSUIAutomation";
	public static final String ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATEVALUE  =".scrollViews()[0].webViews()[0].staticTexts().withPredicate(\"name CONTAINS  '电票开通'\")";
	//.scrollViews()[0].webViews()[0].staticTexts().withPredicate("name CONTAINS  '电票开通'")
	
	/**电票开通-webView：介绍*/
	public static final String ELECTRONICINVOICE_STATICTEXT_PAGEINTRACTION_LOCATETYPE  ="iOSUIAutomation";
	public static final String ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE = ".scrollViews()[0].webViews()[0].staticTexts().withPredicate(\"name CONTAINS  '首家'\")";
	//.scrollViews()[0].webViews()[0].staticTexts().withPredicate("name CONTAINS  '首家'")
	
	/**电票开通-webView：中心图片*/
	public static final String ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATETYPE = "iOSUIAutomation";	
	public static final String ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATEVALUE =".scrollViews()[0].webViews()[0].images()[1]";	
	//.scrollViews()[0].webViews()[0].images()[1]
	
	/**电票开通-webView：电票开通按钮*/
	public static final String ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE =  "iOSUIAutomation";
	public static final String ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE = ".scrollViews()[0].webViews()[0].staticTexts().withPredicate(\"name CONTAINS  '申请开通电子发票服务'\")";
	//.scrollViews()[0].webViews()[0].staticTexts().withPredicate("name CONTAINS  '申请开通电子发票服务'")
	
	/**电票开通-webview-提交表单*/
	public static final String ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATETYPE= "iOSUIAutomation";
	public static final String ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATEVALUE=".scrollViews()[0].webViews()[0].textFields()"; 
	//.scrollViews()[0].webViews()[0].textFields()[0],[1],[2],[3],[4],下滑。[4]
	
	/**电票开通-确认提交*/
	//.scrollViews()[0].webViews()[0].staticTexts().withPredicate("name CONTAINS  '确认提交'")
	public static final String ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATION= "iOSUIAutomation";
	public static final String ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATEVALUE= ".scrollViews()[0].webViews()[0].staticTexts().withPredicate(\"name CONTAINS  '确认提交'\")";
	
	/**提交结果-提交结果*/
	//.scrollViews()[0].webViews()[0].staticTexts().withPredicate("name CONTAINS  '提交成功'")
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATETYPE  ="iOSUIAutomation";
	public static final String ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATEVALUE  =".scrollViews()[0].webViews()[0].staticTexts().withPredicate(\"name CONTAINS  '提交成功'\")";
	
	/**提交结果-返回提交申请页*/
	//.scrollViews()[0].webViews()[0].links().withPredicate("name CONTAINS  '返回'")
	public static final String ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATION  ="iOSUIAutomation";
	public static final String ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATIONVALUE  =".scrollViews()[0].webViews()[0].links().withPredicate(\"name CONTAINS  '返回'\")";
	
	/**提交结果-返回主页*/
	//.scrollViews()[0].webViews()[0].images()[0]
	public static final String ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATION  ="iOSUIAutomation";
	public static final String ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_VALUE =".scrollViews()[0].webViews()[0].images()[0]";
//	
	
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
		 return appiumUtil.doesElementsExist(ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE);
				
	}
	
	public static void introducePageUICheck(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist( ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_PAGETITLE_LOCATEVALUE),"经检查：电票开通-WebView-页面标题不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_STATICTEXT_PAGEINTRACTION_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_STATICTEXT_PAGEINTRACTION_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWDIV_PAGEINTRACTION_LOCATEVALUE), "经检查：电票开通-WebView-公司介绍不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATETYPE,ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATETYPE,ELECTRONICINVOICE_IMAGE_CNETERICON_LOCATEVALUE), "经检查：电票开通-WebView-页面图片不存在");
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE), "经检查：电票开通-WebView-开通电票按钮不存在");
	}
	
	public static void submitPageUICheck(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		List<WebElement> list =(List<WebElement>) appiumUtil.findElements(ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATETYPE,ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATEVALUE);
		for(int i=0;i<list.size();i++){
			WebElement element = list.get(i);
			System.out.println("第"+i+"个元素是否显示："+element.isDisplayed()+";是否可用："+element.isEnabled());
			
		}
		Assertion.assertTrue(list.size()==5, "经检查：显示的列表项不足五项");
	}
	
	public static void enableElectronicInvoice(AppiumUtil appiumUtil,String[] value){
		appiumUtil.waitForElementToLoad(10, ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE);
		appiumUtil.findElement(ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATETYPE,ELECTRONICINVOICE_STATICTEXT_FOOTERENABLE_LOCATEVALUE).click();
		appiumUtil.pause(3);
//		switchNative(appiumUtil);
		submitPageUICheck(appiumUtil);
		appiumUtil.pause(2);
//		switchNative(appiumUtil);
		appiumUtil.pause(2);
		String[] invoiceApplyListElementName ={"联系人姓名：*","联系电话*","企业名称全称*","企业开票主体数量（税号数量）*","企业年开票数量*"};
		List<WebElement> list = (List<WebElement>) appiumUtil.findElements(ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATETYPE,ELECTRONICINVOICE_TEXTFIELDS_LIST_LOCATEVALUE);
		for(int i=0;i<list.size();i++){
			appiumUtil.pause(1);
			WebElement element  = list.get(i);
			if(i==4)
				appiumUtil.swipeForiOS("Up",300,1);
//				appiumUtil.swipByTouchAction("Up");
			appiumUtil.pause(2);
			appiumUtil.click(element);
			appiumUtil.pause(2);
			appiumUtil.typeContentForIos(element,value[i] );
			appiumUtil.pause(3);
		}
//		appiumUtil.driver.scrollToExact("确认提交");
		appiumUtil.pause(3);
		WebElement element = appiumUtil.findElement(ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATION, ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATEVALUE);
		appiumUtil.click(element);
		appiumUtil.pause(3);
	}
	
	public static boolean  verifySubmitResult(AppiumUtil appiumUtil){
		try{
			appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATETYPE,ELECTRONICINVOICE_WBNVIEWA_SUBMITRESULT_LOCATEVALUE);
		}catch(WebDriverException e){
			return false;
		}
		return true;
		
	}
	
	public static void   backToSumitInvoiceApplyPage(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATION, ELECTRONICINVOICE_WBNVIEWA_BACKTOAPPLYPAGE_LOCATIONVALUE).click();
		appiumUtil.pause(2);
		Assertion.assertTrue(appiumUtil.doesElementsExist(ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATION,ELECTRONICINVOICE_STATICTEXT_CONFIMSUBMIT_LOCATEVALUE),"经检查：未成功返回提交申请页");
		
	}
	
	public static void   backToHomePage(AppiumUtil appiumUtil){
		appiumUtil.pause(2);
		appiumUtil.findElement(ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_LOCATION,ELECTRONICINVOICE_WBNVIEWIMG_BACKTOHOME_VALUE).click();
		appiumUtil.pause(2);
//		switchNative(appiumUtil);
		appiumUtil.waitForElementToLoad(10, iOS_HomePage.HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE,iOS_HomePage.HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE);
		Assertion.assertTrue(appiumUtil.doesElementsExist(iOS_HomePage.HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE,iOS_HomePage.HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE),"经检查：未成功返回主页");
		
	}
	
}
