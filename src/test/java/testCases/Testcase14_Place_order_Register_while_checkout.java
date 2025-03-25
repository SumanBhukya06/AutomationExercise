package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class Testcase14_Place_order_Register_while_checkout extends BaseClass {
    @Test
    public void verify_place_order_while_checkout(){
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
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */
        //homePage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        //hp.setBtn_cart();
        //products page
        productsPage pp=new productsPage(driver);
        pp.setBtn_firstproduct();
        scrollDown(400);
        pp.setBtn_view_cart();

        String url=driver.getCurrentUrl();
        if (url.equalsIgnoreCase("https://automationexercise.com/view_cart")){
            System.out.println("on cart page"+url);
        }
        else {
            System.out.println("url not matched..");
        }

        //view cart
        viewCartPage vcp=new viewCartPage(driver);
        vcp.setBtn_proceed_to_checkout();
        vcp.setBtn_Register_login();
        //Register page
        RegisterPage rp=new RegisterPage(driver);
        rp.setTxt_name(randomString());
        rp.setTxt_email(randomString()+"@gmail.com");
        rp.setBtn_clk_signup();
        rp.setChk_mr_radio();
        scrollToBottom();
        rp.setTxt_password(randomAlphanumeric());
        rp.setSelect_days();
        rp.setSelect_months();
        rp.setSelect_years();
        rp.setChk_newsletter();
        rp.setChk_special_offers();
        rp.setTxt_firstname(randomString());
        rp.setTxt_lastname(randomAlphanumeric());
        rp.setTxt_company(randomString());
        rp.setTxt_address1(randomString());
        rp.setTxt_address2(randomString());
        rp.setSelect_country();
        rp.setTxt_state(randomString());
        rp.setTxt_city(randomString());
        rp.setTxt_zipcode(randomNumber());
        rp.setTxt_telephone(randomNumber());
        scrollToBottom();
        rp.setBtnclk_create_account();
        if(rp.isAccountCreated()){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }
        rp.setBtnclk_continue();
        //homepage
        hp.setTxt_is_logged_in_username();
        hp.setBtn_cart();
        //view cart
        vcp.setBtn_proceed_to_checkout();
        //checkoutPage
        checkoutpage cop=new checkoutpage(driver);
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
        if (payp.setSucessMsz()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        rp.setBtn_delete();
        rp.setTxt_msz_delete_acc();
        rp.setBtnclk_continue();
    }
}
