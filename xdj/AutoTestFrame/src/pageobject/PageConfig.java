package pageobject;


import function.Browser;
import util.Config;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;


public class PageConfig
{
    private PropertiesConfiguration config;
    private WebDriver webdriver;
    private static PageConfig pageConfig;

    public PageConfig(){
        config = Config.config;
        webdriver = Browser.getWebDriver();
    }

    public static PageConfig getInstance(){

        if(pageConfig == null){
            synchronized (PageConfig.class) {
                if (pageConfig == null) {
                    pageConfig = new PageConfig();
                }
            }
        }
        return pageConfig;
    }

    public String getValue(String key){
        return config.getString(key);
    }

   /* public WebDriver getWebDriver() {
        return webdriver;
    }*/

    public void setValue(String key,String value){
        try{
            this.config.setProperty(key, value);
            config.save();
        } catch (Exception e){
            System.out.println("This key "+key+" has not been updated");
        }
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }


}