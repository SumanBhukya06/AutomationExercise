package testCases;

import org.testng.annotations.Test;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase11_verify_subscription_cart extends BaseClass {
    @Test
    public void verify_subscription_cart(){
        //Home page
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_cart();
        //scrollToBottom();
        hp.getSubcription();
        hp.setTxt_subscribe_mail(randomString()+"@gmail.com");
        hp.setBtn_send_mail();
        hp.getsuccessmsz();

    }
}
