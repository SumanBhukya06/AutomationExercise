package testCases;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase2_Login_Correct_credentials extends BaseClass {
    @Test(groups = {"Master","Sanity"})
    public void verify_login_page(){
        logger.info("Login_Correct_credentials started");
        //homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //Login page
        LoginPage lp=new LoginPage(driver);
        lp.setTxt_login_email(p.getProperty("email"));
        lp.setTxt_login_password(p.getProperty("password"));
        lp.setBtn_login();
        //homepage
        hp.setTxt_is_logged_in_username();
        //Register page
        RegisterPage rp=new RegisterPage(driver);
        rp.setBtn_delete();
        rp.setTxt_msz_delete_acc();
        logger.info("Login_Correct_credentials ended");
    }


}
