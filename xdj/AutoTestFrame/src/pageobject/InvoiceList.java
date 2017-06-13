package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import util.Assertion;

import java.util.List;

/**
 * Created by a on 2017/6/7.
 */
public class InvoiceList extends Page {

    /**发票清单-右侧列表表头*/
    @FindAll(@FindBy(xpath = "id('inspectionListUl')/tbody/tr[1]/th/span"))
    public static List<WebElement> listTitle;

    /**发票清单-右侧表单无数据时提示*/
    @FindBy(xpath = "id('inspectionListUl')/tbody/tr/td[contains(text(),'没有发票清单')]")
    public static WebElement listNoDataPrompt;

    /**发票清单-右侧表单数据*/
    @FindAll(@FindBy(xpath =  "id('inspectionListUl')/tbody/tr[@class='content']"))
    public static List<WebElement> listData;

    @FindBy(xpath = "//div[@class='search_right']/span[contains(text(),'批量归档')]")
    public static WebElement batchArchiving;



    public boolean isIntoInvoiceList(String pageName){
        sleep(3);
        waitForPageLoad();
        return listTitle.size()>0 && HomePage.getCurrentShowPage().contains(pageName);
    }
    public void invoiceListPageUICheck(String pageName){
        sleep(3);
        switch (pageName){
            case "发票清单-待处理":
                waitElement(batchArchiving);
                Assertion.assertTrue(isExist(batchArchiving),"经检查："+pageName+"-批量归档不存在");
                break;
            default:
                break;
        }
        Assertion.assertTrue(listTitle!=null && listTitle.size()>0,"经检查："+pageName+"-表头不存在");
        if(isExist(listNoDataPrompt))
            Assertion.assertTrue(listData!=null && listData.size()-1== 0,"经检查：："+pageName+"-数据不存在的提示不应该出现，但是出现了");
        else
            Assertion.assertTrue(listData!=null && listData.size()>0,"经检查："+pageName+"发票列表数字不存在但是没有数据不存在的提示信息");
    }

}
