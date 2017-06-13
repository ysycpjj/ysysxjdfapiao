package com.young.appiumcombat.testcases.android.taxguide;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.young.appiumcombat.base.*;
import com.young.appiumcombat.pages.android.Android_HomePage;
import com.young.appiumcombat.pages.android.Android_TaxGuidePage;
import com.young.appiumcombat.utils.Assertion;

public class Android_TaxGuidePage_001_UiCheck_test extends BasePrepare{
	
	@Test
	public void Case_001_intoTaxGuide(){
		Android_HomePage.intoTaxGuide(appiumUtil);
		appiumUtil.pause(3);
		assert appiumUtil.doesElementsExist(Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_PAGETITLE);
	}

	
	/**办税指南页面检查*/
	@Test
	public void Case_002_TaxGuidePageUiCheck(){
		/*appiumUtil.pause(3);
		HomePage.intoTaxGuide(appiumUtil);*/
		appiumUtil.pause(3);
		Android_TaxGuidePage.verifyPageViewCorrect(appiumUtil);
	}
	/**申报纳税页面检查*/
	@Test
	public void Case_003_ApplyTaxPageUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_APPLYTAX,"申报纳税");
		if(Assertion.flag)
			logger.info("申报纳税页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**税务登记页面检查*/
	@Test
	public void Case_004_RegisterTaxUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_REGISTERTAX,"税务登记");
		if(Assertion.flag)
			logger.info("税务登记页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**发票管理页面检查*/
	@Test
	public void Case_005_InvoiceManagementUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_INVOICEMANAGEMENT,"发票管理");
		if(Assertion.flag)
			logger.info("发票管理页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**税务认定页面检查*/
	@Test
	public void Case_006_TaxAuthenticationUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_TAXAUTHENTICATION,"税务认证");
		if(Assertion.flag)
			logger.info("税务认证页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**优惠备案页面检查*/
	@Test
	public void Case_007_DiscountRecordUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_DISCOUNTRECORD,"优惠备案");
		if(Assertion.flag)
			logger.info("优惠备案页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**证明管理页面检查*/
	@Test
	public void Case_008_ProveManagerUiCheck(){
		appiumUtil.pause(3);
		Android_TaxGuidePage.checkChildModerPage(appiumUtil,Android_TaxGuidePage.TAXGUIDEPAGE_RELATIVELAYOUT_PROVEMANAGER,"证明管理");
		if(Assertion.flag)
			logger.info("证明管理页检查完毕，未发现异常");
		else    
			assert Assertion.flag;
	}
	
	@AfterClass 
	public void backToHomePage(){
		Android_TaxGuidePage.backToHomePage(appiumUtil);
		appiumUtil.pause(2);
	}
}
