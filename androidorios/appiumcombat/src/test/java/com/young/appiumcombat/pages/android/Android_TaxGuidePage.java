package com.young.appiumcombat.pages.android;

import java.lang.reflect.Field;

import org.openqa.selenium.By;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;

public class Android_TaxGuidePage {
	/**页面标题*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE = By.id("com.ysyc.itaxer:id/title"); 
	 /**申报纳税*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_APPLYTAX = By.xpath("//android.widget.ListView/android.widget.RelativeLayout[1]");
	 /**税务登记*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_REGISTERTAX = By.xpath("//android.widget.ListView/android.widget.RelativeLayout[2]");
	 /**发票管理*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_INVOICEMANAGEMENT = By.xpath("//android.widget.ListView/android.widget.RelativeLayout[3]");
	 /**税务认证*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_TAXAUTHENTICATION= By.xpath("//android.widget.ListView/android.widget.RelativeLayout[4]");
	 /**优惠备案*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_DISCOUNTRECORD= By.xpath("//android.widget.ListView/android.widget.RelativeLayout[5]");
	 /**证明管理*/
	 public static final By TAXGUIDEPAGE_RELATIVELAYOUT_PROVEMANAGER= By.xpath("//android.widget.ListView/android.widget.RelativeLayout[6]");
	 /**返回主页*/
	 public static final By TAXGUIDE_IMAGEBUTTON_BACHTOHOMEPAGE =By.id("com.ysyc.itaxer:id/left");
	 public static class ChildModer{
		 /**页面标题*/
		 public static final By APPLYTAX_TESTVIEW_TITLE = By.id("com.ysyc.itaxer:id/title"); 
		 /**文章列表*/
		 public static final By APPLYTAX_LISTVIEW_ARTICLELIST = By.xpath("//android.widget.ListView/android.widget.RelativeLayout");
		 /**第一条文章-阅读全部内容*/
		 public static final By APPLYTAX_TESTVIEW_FIRSTARTICLE_READALL = By.id("com.ysyc.itaxer:id/tvReadALL");
		 /**返回税务指南页*/
		 public static final By APPLYTAX_IMAGEBUTTON_BACKTO = By.id("com.ysyc.itaxer:id/left");
		 
		 public static class Article{
			 /**页面收藏按钮*/
			 public static final By ARTICLE_IMAGEVIEW_CLOOECT = By.id("com.ysyc.itaxer:id/iv_collect"); 
			 /**返回*/
			 public static final By ARTICLE_IMAGEVIEW_BACK = By.id("com.ysyc.itaxer:id/btn_back"); 
		 }
	 }
	 
	 public static void  verifyPageViewCorrect(AppiumUtil appiumUtil){
		 /**检查页面title*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE),"经检查：页面标题 不存在" );
		 /**检查：申请纳税 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_APPLYTAX);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_APPLYTAX),"经检查：申请纳税 不存在" );
		 /**检查：税务登记 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_REGISTERTAX);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_REGISTERTAX),"经检查：税务登记 不存在" );
		 /**检查：发票管理 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_INVOICEMANAGEMENT);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_INVOICEMANAGEMENT),"经检查：发票管理 不存在" );
		 /**检查：税务认证 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_TAXAUTHENTICATION);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_TAXAUTHENTICATION),"经检查：税务认证 不存在" );
		 /**检查：优惠备案 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_DISCOUNTRECORD);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_DISCOUNTRECORD),"经检查：优惠备案 不存在" );
		 /**检查：证明管理 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_RELATIVELAYOUT_PROVEMANAGER);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_PROVEMANAGER),"经检查：检查证明 不存在" );
		 assert Assertion.flag;
	 }
	 

	 public static String getPageTitle(AppiumUtil appiumUtil){
		 return (appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE) ? appiumUtil.findElement(TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE).getAttribute("name").trim():null);
	 }
	 
	 public static void backToHomePage(AppiumUtil appiumUtil){
		 if(getPageTitle(appiumUtil).equals("办税指南")){
			 appiumUtil.click(TAXGUIDE_IMAGEBUTTON_BACHTOHOMEPAGE);
			 appiumUtil.pause(2);
		 }else{
			 appiumUtil.logWriter("info", "当前页面不是：办税指南");
//			 System.out.println("当前页面不是：办税指南");
		 }
	 }
	 
	 /**根据类中的属性的值获取属性名称*/
	 public static String getPropertyNameByValue(By by){
		 Field[] field = Android_TaxGuidePage.class.getDeclaredFields();  
		 for(int j=0 ; j<field.length ; j++){     //遍历所有属性
             if(field[j].equals(by))
            	 return field[j].getName();
		 }
		 return null;
	 }
	 
	
	 public static void checkChildModerPage(AppiumUtil appiumUtil,By by,String childModerName){
		 appiumUtil.waitForElementToLoad(10, by);
		 appiumUtil.click(by);
		 appiumUtil.pause(3);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(ChildModer.APPLYTAX_TESTVIEW_TITLE), "经检查："+childModerName+"-标题 不存在");;
		 appiumUtil.pause(3);
		 Assertion.assertTrue(appiumUtil.findElements(ChildModer.APPLYTAX_LISTVIEW_ARTICLELIST).size()>0, "经检查："+childModerName+"-文章列表 不存在");
		 if(Assertion.flag){
			 appiumUtil.pause(3);
			 appiumUtil.click(ChildModer.APPLYTAX_TESTVIEW_FIRSTARTICLE_READALL);
			 appiumUtil.pause(3);
			 Assertion.assertTrue(appiumUtil.doesElementsExist(ChildModer.Article.ARTICLE_IMAGEVIEW_CLOOECT),"经检查："+childModerName+"-文章详情页-收藏 不存在");
			 appiumUtil.pause(3);
			 appiumUtil.click(ChildModer.Article.ARTICLE_IMAGEVIEW_BACK);
			 
		 }
		 appiumUtil.pause(3);
		 appiumUtil.click(ChildModer.APPLYTAX_IMAGEBUTTON_BACKTO);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE) && getPageTitle(appiumUtil).equals("办税指南"),"经检查：未成功从"+childModerName+"返回-办税指南页");
		 
	 }
	 

}
