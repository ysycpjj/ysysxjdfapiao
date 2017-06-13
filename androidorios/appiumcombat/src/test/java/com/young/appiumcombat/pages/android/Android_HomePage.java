package com.young.appiumcombat.pages.android;

import java.io.File;

import org.openqa.selenium.By;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;


/**@author Young
 * @description APP首页元素
 * */

public class Android_HomePage {
	/**地区，对应获取方法：getCity()*/
	 public static final By HOMEPAGE_TEXTVIEW_CITY = By.id("com.ysyc.itaxer:id/city"); 
	/**申报缴税*/
	 public static final By HOMEPAGE_LINEARLAYOUT_APPLYTAX = By.xpath("//android.widget.GridView/android.widget.LinearLayout[1]");
	/**票据融资*/
	 public static final By HOMEPAGE_LINEARLAYOUT_BILLFINANCE =By.xpath("//android.widget.GridView/android.widget.LinearLayout[2]");
	 /**电子发票*/
	public static final By HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE = By.xpath("//android.widget.GridView/android.widget.LinearLayout[4]"); 
		
	/**办税指南*/
	public static final By HOMEPAGE_LINEARLAYOUT_TAXGUIDE = By.xpath("//android.widget.GridView/android.widget.LinearLayout[5]"); 
	
	 
	 public static String getCity(AppiumUtil appiumUtil){
		 return appiumUtil.findElement(HOMEPAGE_TEXTVIEW_CITY).getAttribute("name");
	 }
	 
	 public static void pageCheck(AppiumUtil appiumUtil){
		 /**检查地区*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_TEXTVIEW_CITY);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_TEXTVIEW_CITY),"经检查：地区 不存在" );
		 /**申报缴费*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_APPLYTAX);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_APPLYTAX),"经检查：申报缴费 不存在" );
		 /**票据融资*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_BILLFINANCE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_BILLFINANCE),"经检查：票据融资 不存在" );
		 /**办税指南*/
		 appiumUtil.waitForElementToLoad(10,HOMEPAGE_LINEARLAYOUT_TAXGUIDE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(HOMEPAGE_LINEARLAYOUT_TAXGUIDE),"经检查：办税指南 不存在" );
		 assert Assertion.flag;
	 }
	 
	 public static void intoTaxGuide(AppiumUtil appiumUtil){
		 appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_TAXGUIDE);
		 appiumUtil.click(HOMEPAGE_LINEARLAYOUT_TAXGUIDE);
		 appiumUtil.pause(5);
	 }
	 
	 public static void intoElectronicInvoice(AppiumUtil appiumUtil){
		 appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE);
		 appiumUtil.click(HOMEPAGE_LINEARLAYOUT_ELECTRONICINVOICE);
		 appiumUtil.pause(5);
	 }
	public static void intoApplyTax(AppiumUtil appiumUtil){
		appiumUtil.waitForElementToLoad(10, HOMEPAGE_LINEARLAYOUT_APPLYTAX);
		appiumUtil.click(HOMEPAGE_LINEARLAYOUT_APPLYTAX);
		appiumUtil.pause(5);
		
	}
	
}
