package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase5_Login_with_Existed_user extends BaseClass {

    @Test
    public void verify_existed_user(){
        logger.info("Testcase5_Login_with_Existed_user");

        //Home page
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //Register page
        RegisterPage rp=new RegisterPage(driver);
        rp.isNewuserexists();
        rp.setTxt_name(p.getProperty("user"));
        rp.setTxt_email(p.getProperty("email"));
        rp.setBtn_clk_signup();
        if (rp.getEmailalreadyexists()){
            logger.info("yes displayed");
            Assert.assertTrue(true);
        }
        else {
            logger.info("Not displayed");
            Assert.fail();
        }
    }
}
