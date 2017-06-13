package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
/**
 * Created by a on 2017/6/5.
 */
public class LoginPage extends Page {

    @FindBy(xpath = "//span[@class='register']")
    public static WebElement register;

    @FindBy(xpath = "//span[@class='download']")
    public static WebElement downloadAPP;

    @FindBy(xpath = "//img[@class='code']")  //获取：src
    public static WebElement codeImg;

    @FindBy(xpath = "//input[@class='user']")
    public static WebElement user;

    @FindBy(xpath = "//input[@class='password']")
    public static WebElement Password;

    @FindBy(xpath = "//div[@class='login']")
    public static WebElement login;

    public static By failedPrompt= By.xpath("//*[@id='test']");

    @FindAll(@FindBy(xpath = "//div[@class='footer_content_item']/div"))
    public static List<WebElement> aboutInfo;

    @FindAll(@FindBy(xpath = "//div[@class='headerRight']/a"))
    public static List<WebElement> relatedLink;



    public static void login(String userName,String password){
//        navigateTo(driver);
        waitForPageLoad();
        sleep(3);
        sendKeys(user,userName);
        sleep(3);
        sendKeys(Password,password);
        sleep(4);
        clickElement(login);
    }


    public boolean isLoginFailed(){
        return isExist(failedPrompt);
    }

    public LoginPage() {
        super();
    }

    public String getAboutInfo() {
        String text=null;
        for(int i=0;i<aboutInfo.size();i++){
            text+=aboutInfo.get(i).getText();
        }
        return text;
    }


   
}
