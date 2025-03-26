package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase1_RegisterUser extends BaseClass {

    @Test(groups = {"master","Regressipn","Sanity"})
    public void verify_register_user() throws InterruptedException {
        logger.info("**Testcase1_RegisterUser is started..**");
        //Homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //Register page
        RegisterPage rp=new RegisterPage(driver);
        rp.isNewuserexists();
        rp.setTxt_name(randomString());
        rp.setTxt_email(randomString()+"@gmail.com");
        rp.setBtn_clk_signup();
        rp.isAccountInfoExists();
        scrollDown(500);
        rp.setChk_mr_radio();
        rp.setTxt_password(randomAlphanumeric());
        rp.setSelect_days();
        rp.setSelect_months();
        rp.setSelect_years();
        rp.setChk_newsletter();
        rp.setChk_special_offers();
        rp.setTxt_firstname(randomString());
        rp.setTxt_lastname(randomString());
        rp.setTxt_company(randomString());
        rp.setTxt_address1(randomString());
        rp.setTxt_address2(randomString());
        rp.setSelect_country();
        rp.setTxt_state(randomString());
        rp.setTxt_city(randomString());
        rp.setTxt_zipcode(randomNumber());
        rp.setTxt_telephone(randomNumber());
        rp.setBtnclk_create_account();
        rp.isAccountCreated();
        rp.setBtnclk_continue();
        //homepage
        hp.setTxt_is_logged_in_username();
        rp.setBtn_delete();
        String msz_txt_delete=rp.setTxt_msz_delete_acc();
        if (msz_txt_delete.equalsIgnoreCase("Account Deleted!")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }

        rp.setBtn_del_continue();
        logger.info("**Testcase1_RegisterUser is ended..**");
    }
}
