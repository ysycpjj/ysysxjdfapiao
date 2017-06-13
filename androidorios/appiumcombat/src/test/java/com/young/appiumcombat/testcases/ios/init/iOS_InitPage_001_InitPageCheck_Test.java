package com.young.appiumcombat.testcases.ios.init;

import java.io.IOException;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.ios.iOS_InitPage;
import com.young.appiumcombat.utils.Assertion;
import com.young.appiumcombat.utils.PropertiesDataProvider;

import org.junit.Assert;
import org.testng.annotations.Test;

public class iOS_InitPage_001_InitPageCheck_Test extends BasePrepare {

	@Test
	public void Case_001_InitPageCheck(){
		/**初始化步骤已经在BeforeMethod里面实现了*/
		iOS_InitPage.verifyTheVersion(appiumUtil);
		/**此处已进行了初始化，该字段设置为false*/
		Assert.assertTrue("经检查：首页显示不完整",Assertion.flag);
	}
	
	
}
