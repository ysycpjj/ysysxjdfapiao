package com.young.appiumcombat.pages.ios;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.Assertion;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

public class iOS_TaxGuidePage {
	/**页面标题*/
	//.navigationBars()[0].staticTexts()[0]
	public static final String TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE ="iOSUIAutomation";
	public static final String  TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE =".navigationBars()[0].staticTexts()[0]";

	 /**申报纳税*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '申报纳税'")
	 public static final String TAXGUIDEPAGE_CELL_APPLYTAX_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_APPLYTAX_LOCATEVALUE = ".tableViews()[0].cells().withPredicate(\"name CONTAINS  '申报纳税'\")";

	 /**税务登记*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '税务登记'")
	 public static final String TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATEVALUE =".tableViews()[0].cells().withPredicate(\"name CONTAINS  '税务登记'\")";

	 /**发票管理*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '发票管理'")
	 public static final String TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATEVALUE =".tableViews()[0].cells().withPredicate(\"name CONTAINS  '发票管理'\")";

	 /**税务认证*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '税务认定'")
	 public static final String TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATEALUE = ".tableViews()[0].cells().withPredicate(\"name CONTAINS  '税务认定'\")";

	 /**优惠备案*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '优惠备案'")
	 public static final String TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATEVALUE = ".tableViews()[0].cells().withPredicate(\"name CONTAINS  '优惠备案'\")";

	 /**证明管理*/
	 //.tableViews()[0].cells().withPredicate("name CONTAINS  '证明管理'")
	 public static final String TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATEVALUE = ".tableViews()[0].cells().withPredicate(\"name CONTAINS  '证明管理'\")";

	 /**返回主页*/
	 public static final String TAXGUIDEPAGE_CELL_BACHTOHOMEPAGE_LOCATETYPE ="iOSUIAutomation";
	 public static final String TAXGUIDE_CELL_BACHTOHOMEPAGE_LOCATEVALUE =".navigationBars()[0].buttons()[0]";

	 public static class ChildModer{
		 /**页面标题*/
		 //.navigationBars()[0].staticTexts()[0]
		 public static final String APPLYTAX_STATICTEXT_TITLE_LOCATETYPE ="iOSUIAutomation";
		 public static final String APPLYTAX_STATICTEXT_TITLE_LOCATEVALUE = ".navigationBars()[0].staticTexts()[0]";

		 /**文章列表*/
		 //.tableViews()
		 public static final String APPLYTAX_TABLEVIEW_ARTICLELIST_LOCATETYPE ="iOSUIAutomation";
		 public static final String APPLYTAX_TABLEVIEW_ARTICLELIST_LOCATEVALUE = ".tableViews()[0].cells()";

		 /**第一条文章-阅读全部内容*/
		 //.tableViews()[0].cells()[0].staticTexts()[2]
		 public static final String APPLYTAX_STATICTEXT_FIRSTARTICLE_LOCATETYPE ="iOSUIAutomation";
		 public static final String APPLYTAX_STATICTEXT_FIRSTARTICLE_READALL_LOCATEVALUE = ".tableViews()[0].cells()[0].staticTexts()[2]";

		 /**返回税务指南页*/
		 //.navigationBars()[0].buttons()[0]
		 public static final String APPLYTAX_BUTTON_BACKTO_LOCATETYPE ="iOSUIAutomation";
		 public static final String APPLYTAX_BUTTON_BACKTO_LOCATEVALUE = ".navigationBars()[0].buttons()[0]";
		 
		 public static class Article{
			 /**页面收藏按钮*/
			 //.navigationBars()[0].buttons()[2]
			 public static final String ARTICLE_BUTTON_CLOOECT_LOCATETYPE ="iOSUIAutomation";
			 public static final String ARTICLE_BUTTON_CLOOECT_LOCATEVALUE = ".navigationBars()[0].buttons()[2]";

			 /**返回*/
			 //.navigationBars()[0].buttons()[0]
			 public static final String ARTICLE_BUTTON_BACK_LOCATETYPE ="iOSUIAutomation";
			 public static final String ARTICLE_BUTTON_BACK_LOCATEVALUE = ".navigationBars()[0].buttons()[0]";
		 }
	 }
	 
	 public static void  verifyPageViewCorrect(AppiumUtil appiumUtil){
		 /**检查页面title*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE, TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE,TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE),"经检查：页面标题 不存在" );
		 /**检查：申请纳税 是否存在*/
		 appiumUtil.waitForElementToLoad(10, TAXGUIDEPAGE_CELL_APPLYTAX_LOCATETYPE,TAXGUIDEPAGE_CELL_APPLYTAX_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_APPLYTAX_LOCATETYPE,TAXGUIDEPAGE_CELL_APPLYTAX_LOCATEVALUE),"经检查：申请纳税 不存在" );
		 /**检查：税务登记 是否存在*/
		 appiumUtil.waitForElementToLoad(10, TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATETYPE,TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATETYPE,TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATEVALUE),"经检查：税务登记 不存在" );
		 /**检查：发票管理 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATETYPE,TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATETYPE,TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATEVALUE),"经检查：发票管理 不存在" );
		 /**检查：税务认证 是否存在*/
		 appiumUtil.waitForElementToLoad(10, TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATETYPE,TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATEALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATETYPE,TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATEALUE),"经检查：税务认证 不存在" );
		 /**检查：优惠备案 是否存在*/
		 appiumUtil.waitForElementToLoad(10, TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATETYPE,TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATETYPE,TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATEVALUE),"经检查：优惠备案 不存在" );
		 /**检查：证明管理 是否存在*/
		 appiumUtil.waitForElementToLoad(10,TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATETYPE, TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATETYPE,TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATEVALUE),"经检查：检查证明 不存在" );
		 assert Assertion.flag;
	 }
	 

	 public static String getPageTitle(AppiumUtil appiumUtil){
		 return (appiumUtil.doesElementsExist(TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE,TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE) ? appiumUtil.findElement(TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE,TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE).getAttribute("name").trim():null);
	 }
	 
	 public static void backToHomePage(AppiumUtil appiumUtil){
		 if(getPageTitle(appiumUtil).equals("办税指南")){
			 appiumUtil.findElement(TAXGUIDEPAGE_CELL_BACHTOHOMEPAGE_LOCATETYPE,TAXGUIDE_CELL_BACHTOHOMEPAGE_LOCATEVALUE).click();
			 appiumUtil.pause(2);
		 }else{
			 appiumUtil.logWriter("info", "当前页面不是：办税指南");
//			 System.out.println("当前页面不是：办税指南");
		 }
	 }
	 
	 /**根据类中的属性的值获取属性名称*/
	 public static String getPropertyNameByValue(By by){
		 Field[] field = iOS_TaxGuidePage.class.getDeclaredFields();
		 for(int j=0 ; j<field.length ; j++){     //遍历所有属性
             if(field[j].equals(by))
            	 return field[j].getName();
		 }
		 return null;
	 }
	 
	
	 public static void checkChildModerPage(AppiumUtil appiumUtil,String locateWay, String locateValue, String childModerName){
		 appiumUtil.waitForElementToLoad(10, locateWay,locateValue);
		 appiumUtil.click(locateWay,locateValue);
		 appiumUtil.pause(3);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(ChildModer.APPLYTAX_STATICTEXT_TITLE_LOCATETYPE,ChildModer.APPLYTAX_STATICTEXT_TITLE_LOCATEVALUE), "经检查："+childModerName+"-标题 不存在");;
		 appiumUtil.pause(3);
		 Assertion.assertTrue(appiumUtil.findElements(ChildModer.APPLYTAX_TABLEVIEW_ARTICLELIST_LOCATETYPE,ChildModer.APPLYTAX_TABLEVIEW_ARTICLELIST_LOCATEVALUE).size()>0, "经检查："+childModerName+"-文章列表 不存在");
		 if(Assertion.flag){
			 appiumUtil.pause(3);
			 appiumUtil.findElement(ChildModer.APPLYTAX_STATICTEXT_FIRSTARTICLE_LOCATETYPE,ChildModer.APPLYTAX_STATICTEXT_FIRSTARTICLE_READALL_LOCATEVALUE).click();
			 appiumUtil.pause(3);
			 Assertion.assertTrue(appiumUtil.doesElementsExist(ChildModer.Article.ARTICLE_BUTTON_CLOOECT_LOCATETYPE,ChildModer.Article.ARTICLE_BUTTON_CLOOECT_LOCATEVALUE),"经检查："+childModerName+"-文章详情页-收藏 不存在");
			 appiumUtil.pause(3);
			 appiumUtil.click(ChildModer.Article.ARTICLE_BUTTON_BACK_LOCATETYPE,ChildModer.Article.ARTICLE_BUTTON_BACK_LOCATEVALUE);
			 
		 }
		 appiumUtil.pause(3);
		 appiumUtil.click(ChildModer.APPLYTAX_BUTTON_BACKTO_LOCATETYPE,ChildModer.APPLYTAX_BUTTON_BACKTO_LOCATEVALUE);
		 Assertion.assertTrue(appiumUtil.doesElementsExist(TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE,TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE) && getPageTitle(appiumUtil).equals("办税指南"),"经检查：未成功从"+childModerName+"返回-办税指南页");
		 
	 }
	 

}
