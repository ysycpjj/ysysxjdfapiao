package testcaseobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageobject.*;
import util.Config;
import util.Log;

/**
 * Created by a on 2017/6/8.
 */
public class TestCasePage extends Page {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static InvoiceList invoiceList;
    public static WebDriver driver = PageConfig.getInstance().getWebdriver();
    public static Boolean isNeedLogin=false;

    @BeforeSuite
    public void intoURL(){
        sleep(2);
        get(driver);
        sleep(2);
        waitForPageLoad();
        loginPage =initPageElement(driver, LoginPage.class);
        Log.logInfo("实例化登陆页面");
        sleep(2);
    }

    @BeforeMethod
    public void initLogin(){
        if(isNeedLogin){
            waitForPageLoad();
            LoginPage.login(Config.emaliAddress, Config.passWord);
            isNeedLogin=false;
            sleep(2);
            waitForPageLoad();
            homePage = initPageElement(driver,HomePage.class);
            Log.logInfo("登陆成功，并构建了主页页面元素");
            sleep(2);
        }else
            Log.logInfo("isNeedLogin = false,不需要登陆");
    }

    @AfterSuite
    public void closeDriver(){
        if(driver!=null){
            driver.close();
            sleep(2);
            driver.quit();
        }else
            Log.logWarn("浏览器已关闭");

    }
}
