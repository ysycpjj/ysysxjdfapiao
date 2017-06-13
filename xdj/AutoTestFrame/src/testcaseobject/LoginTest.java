package testcaseobject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.HomePage;
import util.Assertion;


/**
 * Created by a on 2017/6/5.
 */
@Listeners({listener.TestResultListener.class})
public class LoginTest extends TestCasePage{

    @Test
    public void case_001_checkAboutInfo(){
        Assert.assertTrue(loginPage.getAboutInfo()!=null && loginPage.getAboutInfo().length()>0,"经检查：首页显示的相关信息为空");
    }


    @Test(dataProviderClass = datasource.StaticProvider.class, dataProvider = "login")
    public void case_002_loginTest(String emailAddress,String password,String isAbleToLogin){
        sleep(3);
        get(driver);
        sleep(4);
        waitForPageLoad();
        sleep(2);
        loginPage.login(emailAddress,password);
        Assertion.assertTrue(loginPage.isLoginFailed()== !Boolean.parseBoolean(isAbleToLogin),"经检查：是否弹出'登陆失败窗口'与期望不符");
        if(Assertion.flag && Boolean.parseBoolean(isAbleToLogin)){
            waitForPageLoad();
            HomePage homePage =initPageElement(driver,HomePage.class);
            Assertion.assertTrue(homePage.isIntoHomePage(),"经检查：未成功进入主页");
        }
        Assert.assertTrue(Assertion.flag,"经检查：登陆用例执行失败，因弹出登陆失败窗口或未弹出失败窗口却未成功进入主页");
    }

    @AfterClass
    public void setIsNeedLogin(){
        sleep(3);
        get(driver);
        sleep(3);
        isNeedLogin=true;
    }


}
