package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase4_Logout extends BaseClass {
    @Test(groups = {"Master","Sanity"})
    public void verify_logout(){
        logger.info("Testcase4_Logout started..");
        //Homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //Login page
        LoginPage lp=new LoginPage(driver);
        String loginmsz=lp.getLogintoaccmsz();
        if (loginmsz.equalsIgnoreCase("Login to your account")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        lp.setTxt_login_email(p.getProperty("email"));
        lp.setTxt_login_password(p.getProperty("password"));
        lp.setBtn_login();
        //Home page
        hp.setTxt_is_logged_in_username();
        //Homepage
        hp.setBtn_logout();
        if (hp.setClk_signup_login1()){
            System.out.println("The signup displayed");
        }
        else {
            System.out.println("The signup not displayed");
        }
        logger.info("Testcase4_Logout ended");
    }
}
