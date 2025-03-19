package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.testCasePage;
import testBase.BaseClass;

public class Testcase7_testcase_page extends BaseClass {
    @Test
    public void verify_testcase_page(){
        logger.info("Testcase7_testcase_page started...");
        //Homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_Testcases();
        //test case page
        testCasePage tcp=new testCasePage(driver);
        if(tcp.get_testcase_msz()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        tcp.setList_testcases();
        logger.info("Testcase7_testcase_page ended");
    }
}
