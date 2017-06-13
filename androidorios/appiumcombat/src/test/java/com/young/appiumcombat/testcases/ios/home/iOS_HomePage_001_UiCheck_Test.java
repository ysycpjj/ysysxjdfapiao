package com.young.appiumcombat.testcases.ios.home;


import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.ios.iOS_HomePage;
import com.young.appiumcombat.utils.Assertion;
import org.junit.Assert;
import org.testng.annotations.Test;


public class iOS_HomePage_001_UiCheck_Test extends BasePrepare{
	
	/**e税客主页页面检查*/
	@Test
	public void Case_001_HomePageUiCheck(){
//		HelloPage.intoSettingPage(appiumUtil);
//		appiumUtil.pause(3);
//		SettingPage.setToNationalVersion(appiumUtil);
		appiumUtil.pause(3);
		iOS_HomePage.pageCheck(appiumUtil);
		Assert.assertTrue("经检查：主页显示不完整", Assertion.flag);
		
	}
	
	
	

}
