package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class Testcase22_Download_Invoice_after_purchase_order extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
21. Click 'Delete Account' button
22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void verify_download_invoice_after_purchase_order() throws InterruptedException {
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        //products page
        productsPage pp=new productsPage(driver);
        scrollDown(550);
        pp.setBtn_firstproduct();
        Thread.sleep(1000);
        pp.setBtn_continue_shopping();
        scrollDown(100);
        pp.setBtn_secondproduct();
        pp.setBtn_view_cart();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/view_cart");
        //homepage
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
        scrollDown(500);
        rp.setTxt_telephone(randomNumber());
        rp.setBtnclk_create_account();
        rp.isAccountCreated();
        rp.setBtnclk_continue();
        hp.setTxt_is_logged_in_username();
        hp.setBtn_cart();
        viewCartPage vcp=new viewCartPage(driver);
        vcp.setBtn_proceed_to_checkout();
        //check out page
        checkoutpage cop=new checkoutpage(driver);
        Assert.assertTrue(cop.compareAddresses(),"Billing and Delivery Addresses do NOT match!");
        cop.setTxt_message_area(randomString());
        cop.setBtn_proceed();
        //payment page
        paymentPage payp=new paymentPage(driver);
        payp.setTxt_name_on_card(randomString());
        payp.setTxt_card_number(randomNumber());
        payp.setTxt_cvc(randomNumber());
        payp.setTxt_month();
        payp.setTxt_year();
        payp.setBtn_pay_and_confirm();
        Assert.assertTrue(payp.setSucessMsz(),"displayed..");
        //payment done page
        paymentDonePage payDp=new paymentDonePage(driver);
        payDp.setBtn_download();
        payDp.setBtn_Continue();
        //login page
        LoginPage lp=new LoginPage(driver);
        rp.setBtn_delete();
        rp.setTxt_msz_delete_acc();
        rp.setBtnclk_continue();
    }
}
