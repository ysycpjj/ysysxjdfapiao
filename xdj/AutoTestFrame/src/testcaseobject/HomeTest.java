package testcaseobject;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.Assertion;

/**
 * Created by a on 2017/6/7.
 */
@Listeners({listener.TestResultListener.class})
public class HomeTest extends TestCasePage {


    @BeforeClass
    public void configIsNeedLogin(){
        isNeedLogin =true;
    }

    @Test
    public void case_001_homePageUIChcek(){
        String errorInfo=null;
        Assertion.assertTrue(homePage.isIntoHomePage(),"未成功进入主页");
        sleep(2);
        if(Assertion.flag)
            homePage.homePageUiCheck();
        else
            errorInfo="未成功进入主页"+"\n";
        Assert.assertTrue(Assertion.flag,errorInfo+"\n用例执行失败，页面应加载的内容未显示");
    }

    @Test
    public void case_002_resetPassword(){
        homePage.resetPassword();
        Assert.assertTrue(Assertion.flag,"用例失败，提示内容有误");
    }

    @Test
    public void case_003_logOut(){
        homePage.logOut();
        sleep(3);
        Assert.assertTrue(Assertion.flag,"用例失败，未成功退出");
    }

    @AfterClass
    public void setisNeedLogin(){
        isNeedLogin=true;
    }
}
