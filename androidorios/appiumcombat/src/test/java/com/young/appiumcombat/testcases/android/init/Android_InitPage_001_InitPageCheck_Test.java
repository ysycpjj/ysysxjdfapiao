package com.young.appiumcombat.testcases.android.init;

import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.young.appiumcombat.base.BasePrepare;
import com.young.appiumcombat.pages.android.Android_InitPage;
import com.young.appiumcombat.utils.Assertion;

public class Android_InitPage_001_InitPageCheck_Test extends BasePrepare {

	@Test
	public void Case_001_InitPageCheck(){
		Android_InitPage.verifyTheVersion(appiumUtil);
		/**此处已进行了初始化，该字段设置为false*/
		assert Assertion.flag;
	}
	
	
	@Test(enabled=false)
	public void test(){
		for(int i=0;i<3;i++){
			appiumUtil.swipForAndroid("Left", appiumUtil.findElement(Android_InitPage.INITPAGE_IMAGVIEW_HELLO));
			if(i==1){
				appiumUtil.swipForAndroid("Right", appiumUtil.findElement(Android_InitPage.INITPAGE_IMAGVIEW_HELLO));
			}
			
		}
		
		appiumUtil.swipForAndroid("Up", appiumUtil.driver.findElement(By.className("android.widget.FrameLayout")));
		appiumUtil.swipForAndroid("Down", appiumUtil.driver.findElement(By.className("android.widget.FrameLayout")));
		
	}
	
}
