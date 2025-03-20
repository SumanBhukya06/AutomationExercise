package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase10_verify_subscription extends BaseClass {

    @Test
    public void verify_subscription(){
        //Home page
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        scrollToBottom();
        hp.setTxt_subscribe_mail(randomString()+"@gmail.com");
        hp.setBtn_send_mail();
        if(hp.getsuccessmsz()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
