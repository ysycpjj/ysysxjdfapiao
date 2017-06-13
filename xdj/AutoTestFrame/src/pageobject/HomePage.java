package pageobject;

import com.oracle.tools.packager.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Assertion;
import util.Config;

/**
 * Created by a on 2017/6/5.
 */
public class HomePage extends Page {

    /**发票小当家logo*/
    @FindBy(xpath = "//div[@class='header_left']/img")
    public static WebElement logo;

    /**公司名称*/
    @FindBy(xpath = "//li[@class='companyClick']/span")
    public static WebElement company;

    /**登陆邮箱*/
    @FindBy(xpath = "//div[@class='accountRight']/p[@class='email']")
    public static WebElement email;

    /**设置*/
    @FindBy(id = "setting")
    public static WebElement setting;

    /**当前展示的页面-父级*/
    //li[@class='bg_button']/span
    @FindBy(xpath = "//li[@class='bg_button']/parent::*/parent::*/div/span")
    public static WebElement currentShowParentPage;

    /**当前展示的页面-子级*/
    @FindBy(xpath = "//li[@class='bg_button']/span")
    public static WebElement currentShowChildPage;

    /**重置密码*/
    @FindBy(xpath = "id('resetPassword')/span")
    public static WebElement resetPassword;
        /**重置密码提示*/
        @FindBy(xpath = "//p[@class='tishi']")
        public static WebElement resetPasswordTiShi;
        /**重置密码确认按钮*/
        @FindBy(xpath = "//div[@class='submitButton']")
        public static WebElement resetPasswordSubmit;

    /**退出*/
    @FindBy(xpath = "id('exit')/span")
    public static WebElement exit;

    /**发票清单*/
    @FindBy(xpath = "//span[contains(text(),'发票清单')]")
    public static WebElement invoiceList;
        /**待处理
         * 获取text，下同*/
        @FindBy(xpath = "id('processed')/span")
        public static WebElement processed;
        /**已归档*/
        @FindBy(xpath = "id('archive')/span")
        public static WebElement archive;
        /**已退回*/
        @FindBy(xpath = "id('returned')/span")
        public static WebElement returned;

    /**发票管理*/
    @FindBy(xpath = "//span[contains(text(),'发票管理')]")
    public static WebElement invoicesManager;
        /**发票库
         * 获取text，下同*/
        @FindBy(xpath = "id('invoiceLibrary')/span")
        public static WebElement invoiceLibrary;
        /**专票可抵扣*/
        @FindBy(xpath = "id('invoiceLibrary_zhuan')/span")
        public static WebElement invoiceLibrary_zhuan;
        /**纸质普票*/
        @FindBy(xpath = "id('invoiceLibrary_zhi')/span")
        public static WebElement invoiceLibrary_zhi;
        /**电子普票*/
        @FindBy(xpath = "id('invoiceLibrary_dianzi')/span")
        public static WebElement invoiceLibrary_dianzi;


    /**销项发票管理*/
    @FindBy(xpath = "//span[contains(text(),'销项发票管理')]")
    public static WebElement xiaoInvoiceManager;
        /**销项发票库*/
        @FindBy(xpath = "id('xiaoInvoice')/span")
        public static WebElement xiaoInvoice;

    /**企业管理*/
    @FindBy(xpath = "//span[contains(text(),'企业管理')]")
    public static WebElement companyManager;
        /**邀请员工*/
        @FindBy(xpath = "id('invitation')/span")
        public static WebElement invitation;
        /**发票抬头*/
        @FindBy(xpath = "id('invoiceTitle')/span")
        public static WebElement invoiceTitle;

    /**我的账号*/
    @FindBy(xpath = "//span[contains(text(),'我的账户')]")
    public static WebElement myAccount;
        /**账户一览*/
        @FindBy(xpath = "id('accountShow')/span")
        public static WebElement accountShow;
        /**团队管理*/
        @FindBy(xpath = "id('teamManage')/span")
        public static WebElement teamManage;
        /**我的订单*/
        @FindBy(xpath = "id('myorder')/span")
        public static WebElement myorder;


    public static boolean isIntoHomePage(){
        waitElement(logo);
        waitElement(company);
        waitElement(email);
        return isExist(logo) && isExist(company) && isExist(email);

    }

    public static void homePageUiCheck(){
        waitElement(logo);
        Assertion.assertTrue(isExist(logo),"经检查：主页-logo不存在");
        waitElement(company);
        Assertion.assertTrue(isExist(company),"经检查：主页-公司名称不存在");
        waitElement(email);
        Assertion.assertTrue(isExist(email),"经检查：主页-登陆邮箱不存在");
        waitElement(invoiceList);
        Assertion.assertTrue(isExist(invoiceList),"经检查：主页-发票清单不存在");
        waitElement(processed);
        Assertion.assertTrue(isExist(processed),"经检查：主页-发票清单-待处理不存在");
        waitElement(archive);
        Assertion.assertTrue(isExist(archive),"经检查：主页-发票清单-已归档不存在");
        waitElement(returned);
        Assertion.assertTrue(isExist(returned),"经检查：主页-发票清单-已退回不存在");
        waitElement(invoicesManager);
        Assertion.assertTrue(isExist(invoicesManager),"经检查：主页-发票管理不存在");
        waitElement(invoiceLibrary);
        Assertion.assertTrue(isExist(invoiceLibrary),"经检查：主页-发票管理-发票库不存在");
        waitElement(invoiceLibrary_zhuan);
        Assertion.assertTrue(isExist(invoiceLibrary_zhuan),"经检查：主页-发票管理-专票可抵扣不存在");
        waitElement(invoiceLibrary_zhi);
        Assertion.assertTrue(isExist(invoiceLibrary_zhi),"经检查：主页-发票管理-纸质发票不存在");
        waitElement(invoiceLibrary_dianzi);
        Assertion.assertTrue(isExist(invoiceLibrary_dianzi),"经检查：主页-发票管理-电子普票不存在");
        waitElement(xiaoInvoiceManager);
        Assertion.assertTrue(isExist(xiaoInvoiceManager),"经检查：主页-销项发票管理不存在");
        waitElement(xiaoInvoice);
        Assertion.assertTrue(isExist(xiaoInvoice),"经检查：主页-销项发票管理-销项发票库不存在");
        waitElement(companyManager);
        Assertion.assertTrue(isExist(companyManager),"经检查：主页-企业管理不存在");
        waitElement(invitation);
        Assertion.assertTrue(isExist(invitation),"经检查：主页-企业管理-邀请员工不存在");
        waitElement(invoiceTitle);
        Assertion.assertTrue(isExist(invoiceTitle),"经检查：主页-企业管理-发票抬头不存在");
        waitElement(myAccount);
        Assertion.assertTrue(isExist(myAccount),"经检查：主页-我的账号不存在");
        waitElement(accountShow);
        Assertion.assertTrue(isExist(accountShow),"经检查：主页-我的账户-账户一览不存在");
        waitElement(teamManage);
        Assertion.assertTrue(isExist(teamManage),"经检查：主页-我的账户-团队管理不存在");
        waitElement(myorder);
        Assertion.assertTrue(isExist(myorder),"经检查：主页-我的账户-我的订单不存在");
        waitElement(email);
        Assertion.assertTrue(email.getText().equals(Config.emaliAddress),"经检查：主页-登陆账号与实际账号不符");
    }



    public static void intoChildPage(String childPageName,WebElement elementToClick){
        waitElement(elementToClick);
        clickElement(elementToClick);
        Log.info("进入："+childPageName+"页面");

    }

    public static void logOut(){
        waitElement(setting);
        clickElement(setting);
        waitElement(resetPassword);
        waitElement(exit);
        clickElement(exit);
        waitElement(LoginPage.login);
        Assertion.assertTrue(isExist(LoginPage.login),"未成功退出");
    }

    public static void resetPassword(){
        waitElement(setting);
        clickElement(setting);
        waitElement(resetPassword);
        waitElement(exit);
        clickElement(resetPassword);
        waitElement(resetPasswordTiShi);
        Assertion.assertTrue(resetPasswordTiShi.getText().contains("邮件验证发送成功"),"密码重置提示信息有误");
        waitElement(resetPasswordSubmit);
        clickElement(resetPasswordSubmit);
    }


    public static String getCurrentShowPage(){
        waitElement(currentShowParentPage);
        waitElement(currentShowChildPage);
        return (isExist(currentShowParentPage)&&isExist(currentShowChildPage))?currentShowParentPage.getText()+"-"+currentShowChildPage.getText():null;
    }
    public HomePage() {
        super();
    }

}
