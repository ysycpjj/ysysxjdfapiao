package com.young.appiumcombat.base;

import com.young.appiumcombat.pages.ios.iOS_InitPage;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import com.young.appiumcombat.pages.android.Android_InitPage;

import com.young.appiumcombat.utils.AppiumUtil;
import com.young.appiumcombat.utils.ExcelDataProvider;
import com.young.appiumcombat.utils.LogConfiguration;
import com.young.appiumcombat.utils.SelectDriver;
import com.young.appiumcombat.utils.PropertiesDataProvider;
import com.young.appiumcombat.utils.Assertion;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author young
 * @description 启动和结束测试，以及数据提供者，提供测试数据
 * */
public class BasePrepare {
	public static AppiumDriver<WebElement> driver;
	public static AppiumUtil appiumUtil = new AppiumUtil();
	public static Logger logger = Logger.getLogger(BasePrepare.class);
	public static  String platformName;
	protected static int elementTimeOut;
	/* 以上几个属性为iOS和Android 共有的属性，以下两个为Android独有的 */
	protected static String appFilePath;
	protected static String appPackage;
	/*以下属性为ios特有属性*/
	protected static  String iosAppPath;
	protected static  String iosAppPackage;
	/*是否需要重新打开*/
	public static boolean isNeedInit = true;
	

	
	@BeforeSuite
	public void initTest(ITestContext context) {
		System.out.println("-------调用BeforeSuite方法--------");
		// 使log4j的配置生效，以便输出日志
		LogConfiguration.initLog(this.getClass().getSimpleName());
		// 获取platform、appFilePath、appPackage的值，这个值是从testng的配置文件获取的
		platformName = context.getCurrentXmlTest().getParameter("platformName");
  		switch (platformName) {
		case "iOS":
			iosAppPath = context.getCurrentXmlTest().getParameter("iosAppPath");
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
			iosAppPackage =context.getCurrentXmlTest().getParameter("iosAppPackage");
			break;
		case "Android":
			appFilePath = context.getCurrentXmlTest().getParameter(
					"appFilePath");
			appPackage = context.getCurrentXmlTest().getParameter("appPackage");
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
			break;
		default:
			elementTimeOut = Integer.valueOf(context.getCurrentXmlTest()
					.getParameter("elementTimeOut"));
		}
		// 调用SelectDriver类的selectDriver方法，生成driver对象
		driver = new SelectDriver().selectDriver(context, appiumUtil);
//		ChromedriverHandler.chromeDriverHandlerThread().start();
	}


	@AfterSuite
	public void clenTest() {
		System.out.println("-------调用AfterSuite方法--------");
		if (driver != null) {
			switch(platformName){
			case "iOS":
				String x =iosAppPath.substring(iosAppPath.lastIndexOf("/")+1, iosAppPath.lastIndexOf("."));
				System.out.println("----------"+x);
				appiumUtil.closeApp(iosAppPath.substring(iosAppPath.lastIndexOf("/")+1, iosAppPath.lastIndexOf("."))) ;
				appiumUtil.pause(3);
				//ios中会保留设置，为了让程序每次都从初始开始，每次运行完了，卸载app
				try {
					appiumUtil.uninstallIOSAPP(iosAppPackage);
				} catch (IOException e) {
					appiumUtil.logWriter("info", "卸载APP出错");
				}
				break;
			case "Android":
				appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath,
						appPackage));// appium模式
				appiumUtil.pause(2);
				appiumUtil.uninstallAndroidAPP(appPackage);
				break;
			default:
				appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath,
						appPackage));// appium模式
				break;
			}
			driver.quit(); //selendroid 模式
		} else {
			Assert.fail("driver没有获得对象,退出操作失败");
		}
		
	}
	
	/**如果方法执行之时，尚未初始化地区等信息，isNeedInit=true,则初始化一下，如果已经初始化，则不再初始化*/
	@BeforeMethod
	public void initSoftware(){
		if(isNeedInit){
			if(platformName.equals("Android")) {
				appiumUtil.pause(2);
				Android_InitPage.premissionAllow(appiumUtil);
				appiumUtil.pause(2);
				Android_InitPage.initPageAndCheckPageView(appiumUtil);
				isNeedInit = false;
			}else if(platformName.equals("iOS")){
				appiumUtil.pause(2);
				iOS_InitPage.initPageAndCheckPageView(appiumUtil);
				isNeedInit = false;
			}
		}
	}
	

	
	
	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {
			/**这里的calssName原始值大概是这样的：com.young.appiumcombat.testcases.login.LoginPage_001_loginError_Test
			 * 那么下面这段代码className.substring(33, className.lastIndexOf("."))是什么意思？substring方法参数有两个
			 * 一个开始位置，一个结束位置，33表示这个字符串的第33个位置，这个位置当前字符是l,className.lastIndexOf(".")表示返回这字符串最后一个.所在
			 * 的位置，它是38，那么className.substring(33, className.lastIndexOf("."))可以转换成：className.substring(33, 38)，最终取得的值是login，
			 * 也就是moduleName的值
			 * 修改如下：该代码即取倒数第二个.到倒数第一个.直接的字符串，先将className截取，截取位置为：开头到倒数第一个.,不包含. ,讲截取下来的字符串找最后.的位置，
			 * 加一即为开始的位置，结束的位置机位倒数第一个点的位置
			 * 
			 * */
			
			moduleName = className.substring(className.substring(0,className.lastIndexOf(".")).lastIndexOf(".")+1, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			//这个分析方法和moduleName的分析方法一样
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum,this.platformName);
	}


}
