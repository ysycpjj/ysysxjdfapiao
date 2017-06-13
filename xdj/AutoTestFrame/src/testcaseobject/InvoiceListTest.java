package testcaseobject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.InvoiceList;
import util.Assertion;

/**
 * Created by a on 2017/6/8.
 */
@Listeners({listener.TestResultListener.class})
public class InvoiceListTest extends TestCasePage {

    @Test
    public void case_001_checkInvoiceList_ProcessedPage(){
        sleep(3);
        homePage.intoChildPage("发票清单-待处理",homePage.processed);
        sleep(3);
        invoiceList = initPageElement(driver, InvoiceList.class);
        sleep(3);
        Assertion.assertTrue(invoiceList.isIntoInvoiceList("发票清单-待处理"),"未成功进入：发票清单-待处理页面");
        invoiceList.invoiceListPageUICheck("发票清单-待处理");
        Assert.assertTrue(Assertion.flag,"用例执行失败");
    }

    @Test
    public void case_002_checkInvoiceList_ArchivePage(){
        sleep(3);
        homePage.intoChildPage("发票清单-已归档",homePage.archive);
        sleep(3);
        invoiceList = initPageElement(driver, InvoiceList.class);
        sleep(3);
        Assertion.assertTrue(invoiceList.isIntoInvoiceList("发票清单-已归档"),"未成功进入：发票清单-已归档页面");
        invoiceList.invoiceListPageUICheck("发票清单-已归档");
        Assert.assertTrue(Assertion.flag,"用例执行失败");
    }

    @Test
    public void case_003_checkInvoiceList_ReturnedPage(){
        sleep(3);
        homePage.intoChildPage("发票清单-已退回",homePage.returned);
        sleep(3);
        invoiceList = initPageElement(driver, InvoiceList.class);
        sleep(3);
        Assertion.assertTrue(invoiceList.isIntoInvoiceList("发票清单-已退回"),"未成功进入：发票清单-已退回页面");
        invoiceList.invoiceListPageUICheck("发票清单-已退回");
        Assert.assertTrue(Assertion.flag,"用例执行失败");
    }

    /*@Test
    public void case_004_checkinvoicesManager_invoiceLibrary(){
        sleep(3);
        homePage.intoChildPage("发票管理-发票库",homePage.invoiceLibrary);
        sleep(3);
        invoiceList = initPageElement(driver, InvoiceList.class);
        sleep(3);
        Assertion.assertTrue(invoiceList.isIntoInvoiceList("发票管理-发票库"),"未成功进入：发票管理-发票库页面");
        invoiceList.invoiceListPageUICheck("发票管理-发票库");
        Assert.assertTrue(Assertion.flag,"用例执行失败");
    }*/
}
