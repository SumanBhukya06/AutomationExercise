package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class Testcase18_Search_Products_and_Verify_Cart_After_Login extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
     */

    @Test
    public void verify_search_products_and_verify_cart_after_login(){
    //homepage
        homePage hp=new homePage(driver);
        hp.setBtn_products();
        //products page
        productsPage pp=new productsPage(driver);
        Assert.assertTrue(pp.msz_all_products(),"all products text displayed");
        pp.setInput_search_box(p.getProperty("searchP"));
        pp.setBtn_search_product();
        //products search page
        products_search_page psp=new products_search_page(driver);
        Assert.assertTrue(psp.ispolotshirttextvisible(),"premium polo tshirt text visible");
        psp.setBtn_tshirt_add_to_cart();
        pp.setBtn_view_cart();
        //login page
        hp.setClk_signup_login();
        LoginPage lp=new LoginPage(driver);
        lp.setTxt_login_email(p.getProperty("email"));
        lp.setTxt_login_password(p.getProperty("password"));
        lp.setBtn_login();
        //homepage
        hp.setBtn_cart();
        viewCartPage vcp=new viewCartPage(driver);
        vcp.isItemTextSame();
    }
}
