package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class Testcase21_verify_address_details_in_checkout extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void verify_address_details() throws InterruptedException {
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setClk_signup_login();
        //registration page
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
        hp.setTxt_is_logged_in_username();
        //products page
        productsPage pp=new productsPage(driver);
        pp.setBtn_firstproduct();
        Thread.sleep(1000);
        pp.setBtn_continue_shopping();
        pp.setBtn_secondproduct();
        pp.setBtn_view_cart();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/view_cart");
        viewCartPage vcp=new viewCartPage(driver);
        vcp.setBtn_proceed_to_checkout();
        //checkout page
        checkoutpage cop=new checkoutpage(driver);
        Assert.assertTrue(cop.compareAddresses(),"Billing and Delivery Addresses do NOT match!");
    }
}
