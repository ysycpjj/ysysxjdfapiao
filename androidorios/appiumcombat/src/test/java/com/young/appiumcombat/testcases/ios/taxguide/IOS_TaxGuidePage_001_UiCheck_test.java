package com.young.appiumcombat.testcases.ios.taxguide;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.ios.iOS_HomePage;
import com.young.appiumcombat.pages.ios.iOS_TaxGuidePage;
import com.young.appiumcombat.utils.Assertion;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class IOS_TaxGuidePage_001_UiCheck_test extends BasePrepare{
	
	@Test
	public void Case_001_intoTaxGuide(){
		iOS_HomePage.intoTaxGuide(appiumUtil);
		appiumUtil.pause(3);
		assert appiumUtil.doesElementsExist(iOS_TaxGuidePage.TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_STATICTEXT_PAGETITLE_LOCATEVALUE);
	}

	
	/**办税指南页面检查*/
	@Test
	public void Case_002_TaxGuidePageUiCheck(){
		/*appiumUtil.pause(3);
		HomePage.intoTaxGuide(appiumUtil);*/
		appiumUtil.pause(3);
		iOS_TaxGuidePage.verifyPageViewCorrect(appiumUtil);
	}
	/**申报纳税页面检查*/
	@Test
	public void Case_003_ApplyTaxPageUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_APPLYTAX_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_APPLYTAX_LOCATEVALUE,"申报纳税");
		if(Assertion.flag)
			logger.info("申报纳税页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**税务登记页面检查*/
	@Test
	public void Case_004_RegisterTaxUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_REGISTERTAX_LOCATEVALUE,"税务登记");
		if(Assertion.flag)
			logger.info("税务登记页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**发票管理页面检查*/
	@Test
	public void Case_005_InvoiceManagementUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_INVOICEMANAGEMENT_LOCATEVALUE,"发票管理");
		if(Assertion.flag)
			logger.info("发票管理页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**税务认定页面检查*/
	@Test
	public void Case_006_TaxAuthenticationUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_TAXAUTHENTICATION_LOCATEALUE,"税务认证");
		if(Assertion.flag)
			logger.info("税务认证页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**优惠备案页面检查*/
	@Test
	public void Case_007_DiscountRecordUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_DISCOUNTRECORD_LOCATEVALUE,"优惠备案");
		if(Assertion.flag)
			logger.info("优惠备案页检查完毕，未发现异常");
		else
			assert Assertion.flag;
	}
	/**证明管理页面检查*/
	@Test
	public void Case_008_ProveManagerUiCheck(){
		appiumUtil.pause(3);
		iOS_TaxGuidePage.checkChildModerPage(appiumUtil,iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATETYPE,
				iOS_TaxGuidePage.TAXGUIDEPAGE_CELL_PROVEMANAGER_LOCATEVALUE,"证明管理");
		if(Assertion.flag)
			logger.info("证明管理页检查完毕，未发现异常");
		else    
			assert Assertion.flag;
	}
	
	@AfterClass 
	public void backToHomePage(){
		iOS_TaxGuidePage.backToHomePage(appiumUtil);
		appiumUtil.pause(2);
	}
}
