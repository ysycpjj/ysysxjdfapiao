package com.young.appiumcombat.pages.ios;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;


/**@author Young
 * @description APP首页元素
 * */

public class iOS_HomePage {
	/**地区，对应获取方法：getCity()*/
	 public static final String HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE ="iOSUIAutomation"; //uiautomatin:
	 public static final String  HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE =".navigationBars()[0].buttons()[1]";
	/**申报缴税*/
	 public static final String HOMEPAGE_LINEARLAYOUT_APPLYTAX_LOCATETYPE ="iOSUIAutomation";
	 public static final String HOMEPAGE_LINEARLAYOUT_APPLYTAXTE_LOCATEVALUE = ".tableViews()[0].cells()[0].buttons().withPredicate(\"name CONTAINS  '申报缴税'\")";
	/**票据融资*/
	 public static final String HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATETYPE ="iOSUIAutomation";
	 public static final String HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATEVLUE =".tableViews()[0].cells()[0].buttons().withPredicate(\"name CONTAINS  '票据融资'\")";
	 /**电子发票*/
	 public static final String HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATETYPE ="iOSUIAutomation";
	 public static final String HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATEVALUE= ".tableViews()[0].cells()[0].buttons().withPredicate(\"name CONTAINS  '电子发票'\")";
		
	/**办税指南*/
	 public static final String HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATETYPE ="iOSUIAutomation";
	 public static final String HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATEVALUE = ".tableViews()[0].cells()[0].buttons().withPredicate(\"name CONTAINS  '办税指南'\")";
	
	 /**获取首页显示的地区信息*/
	 public static String getCity(AppiumUtil appiumUtil){
		 return appiumUtil.findElement(HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE,HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE).getAttribute("name");
	 }
	 /**检查页面各元素是否存在*/
	 public static void pageCheck(AppiumUtil appiumUtil){
		 /**检查地区*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE,HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_TEXTVIEW_CITY_LOCATETYPE,HOMEPAGE_TEXTVIEW_CITY_LOCATEVALUE),"经检查：地区 不存在" );
		 /**申报缴费*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_APPLYTAX_LOCATETYPE, HOMEPAGE_LINEARLAYOUT_APPLYTAXTE_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_APPLYTAX_LOCATETYPE, HOMEPAGE_LINEARLAYOUT_APPLYTAXTE_LOCATEVALUE),"经检查：申报缴费 不存在" );
		 /**票据融资*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATEVLUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_BILLFINANCE_LOCATEVLUE),"经检查：票据融资 不存在" );
		 /**办税指南*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATEVALUE),"经检查：办税指南 不存在" );
//		 assert Assertion.flag;
	 }
	 /**进入办税指南页面*/
	 public static void intoTaxGuide(AppiumUtil appiumUtil){
		 appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATEVALUE);
		 appiumUtil.click(appiumUtil.findElement(HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_TAXGUIDE_LOCATEVALUE));
		 appiumUtil.pause(5);
	 }
	 /**进入电子发票页面*/
	 public static void intoElectronicInvoice(AppiumUtil appiumUtil){
		 appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATEVALUE);
		 appiumUtil.click(appiumUtil.findElement(HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE_LOCATEVALUE));
		 appiumUtil.pause(5);
	 }
	 /**进入申报缴税页面*/
	public static void intoApplyTax(AppiumUtil appiumUtil){
		appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_APPLYTAX_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_APPLYTAXTE_LOCATEVALUE);
		appiumUtil.click(appiumUtil.findElement(HOMEPAGE_LINEARLAYOUT_APPLYTAX_LOCATETYPE,HOMEPAGE_LINEARLAYOUT_APPLYTAXTE_LOCATEVALUE));
		appiumUtil.pause(5);
		
	}
	
}
