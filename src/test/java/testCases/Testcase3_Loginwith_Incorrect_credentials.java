package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase3_Loginwith_Incorrect_credentials extends BaseClass {
    @Test
    public void verify_loginwith_incorrect_details(){
        logger.info("Testcase3_Loginwith_Incorrect_credentials");
        //Homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //Login page
        LoginPage lp=new LoginPage(driver);
        //lp.setTxt_login_email(p.getProperty("email"));
        //lp.setTxt_login_password(p.getProperty("password"));
        lp.setTxt_login_email("rajaram@gmail.com");
        lp.setTxt_login_password("rajaram@123");
        lp.setBtn_login();
        String incorrect_msz=lp.getIncorrectmsz();
        if (incorrect_msz.equalsIgnoreCase("Your email or password is incorrect!")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
