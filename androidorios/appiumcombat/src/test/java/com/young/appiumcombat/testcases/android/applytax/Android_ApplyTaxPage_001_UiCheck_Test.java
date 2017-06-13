package com.young.appiumcombat.testcases.android.applytax;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.Android_ApplyTaxPage;
import com.young.appiumcombat.pages.android.Android_HomePage;
import com.young.appiumcombat.utils.Assertion;

public class Android_ApplyTaxPage_001_UiCheck_Test extends BasePrepare {

	@Test
	public void Case_001_intoApplyTax(){
		Android_HomePage.intoApplyTax(appiumUtil);
		appiumUtil.pause(2);
		Assertion.assertTrue(appiumUtil.doesElementsExist(Android_ApplyTaxPage.APPLYTAX_TETVIEW_TITLE), "经检查：未成功进入‘申报缴税’页面");
		Assert.assertTrue(Assertion.flag,"经检查：未成功进入‘申报缴税’页面");
	}
	
	@Test(dependsOnMethods ="Case_001_intoApplyTax")
	public void Case_002_applyTaxPageUICheck(){
		Android_ApplyTaxPage.applyTaxUICHeck(appiumUtil);
		appiumUtil.pause(2);
		Android_ApplyTaxPage.checkContent(appiumUtil);
		Assert.assertTrue(Assertion.flag,"经检查：‘申报缴税’页面显示内容不完整");
	}
	
	@Test(dependsOnMethods ="Case_001_intoApplyTax")
	public void Case_003_wantToUseThisFunction(){
		Android_ApplyTaxPage.wantToUseThisFunction(appiumUtil);
		appiumUtil.pause(2);
		Assert.assertTrue(Assertion.flag,"经检查：‘我也想用此功能’点击失效");
	}
	@Test(dependsOnMethods ="Case_001_intoApplyTax")
	public void Case_004_backToHomePage(){
		Android_ApplyTaxPage.backToHome(appiumUtil);
		appiumUtil.pause(2);
		Assert.assertTrue(Assertion.flag,"经检查：未成功返回主页");
	}
	
}
