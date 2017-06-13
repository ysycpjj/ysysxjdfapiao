package com.young.appiumcombat.testcases.ios.electronicinvoice;


import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.ios.iOS_ElectronicInvoice;
import com.young.appiumcombat.pages.ios.iOS_HomePage;
import com.young.appiumcombat.utils.Assertion;
import org.testng.annotations.Test;


public class iOS_EletronicInvoicePage_001_UiCheck_Test extends BasePrepare{
	
	@Test
	public void Case_001_intoEletronicInvoicePage(){
		iOS_HomePage.intoElectronicInvoice(appiumUtil);
		Assertion.assertTrue(iOS_ElectronicInvoice.isInElectronicInvoicePage(appiumUtil), "经检查：未成功进入电子发票页面");
//		iOS_ElectronicInvoice.switchWebView(appiumUtil);
	}
	
	@Test(dependsOnMethods ="Case_001_intoEletronicInvoicePage" ,alwaysRun = false)
	public void Case_002_EletronicInvoicePageUiCheck(){
		iOS_ElectronicInvoice.introducePageUICheck(appiumUtil);
		assert Assertion.flag;
	}
	@Test(dependsOnMethods ="Case_001_intoEletronicInvoicePage" ,alwaysRun = false)
	public void Case_003_EnableElectronicInvoice(){
		String[] value={"测试联系人", "13333333333", "测试公司", "1", "100"};
		iOS_ElectronicInvoice.enableElectronicInvoice(appiumUtil, value);
		Assertion.assertTrue(iOS_ElectronicInvoice.verifySubmitResult(appiumUtil), "经检查：提交申请失败");
		assert Assertion.flag;
	}
	@Test(dependsOnMethods = "Case_003_EnableElectronicInvoice",alwaysRun = false)
	public void Case_004_BackToSumitPage(){
		iOS_ElectronicInvoice.backToSumitInvoiceApplyPage(appiumUtil);
		assert Assertion.flag;
	}
	
	@Test(dependsOnMethods = "Case_004_BackToSumitPage",alwaysRun = false)
	public void Case_005_BackToHomePage(){
		iOS_ElectronicInvoice.backToHomePage(appiumUtil);
		assert Assertion.flag;
	}
	
	
	

}
