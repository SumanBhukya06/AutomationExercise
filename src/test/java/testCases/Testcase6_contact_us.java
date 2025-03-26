package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.contact_usPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase6_contact_us extends BaseClass {

    //home page
    @Test(groups = {"Master","Sanity"})
    public void verify_contact_us() {
        homePage hp = new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_contact_us();
        //contact us
        contact_usPage cu=new contact_usPage(driver);
        if (cu.getmszgetintouch()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        cu.setTxt_contact_name(randomString());
        cu.setTxt_contact_email(randomString()+"@gmail.com");
        cu.setTxt_contact_subject(randomString());
        cu.setTxt_contact_message(randomString());
        scrollDown(250);
        cu.setFile_upload();
        cu.setContact_submit();
        alerteElements();
        String success_cu=cu.setMsz_success_contact();
        if (success_cu.equalsIgnoreCase("Success! Your details have been submitted successfully."))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        cu.setBtn_home();
    }
}
