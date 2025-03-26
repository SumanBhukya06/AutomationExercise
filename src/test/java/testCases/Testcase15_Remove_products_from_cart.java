package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productsPage;
import pageObjects.viewCartPage;
import testBase.BaseClass;

public class Testcase15_Remove_products_from_cart extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
     */

    @Test
    public void verify_remove_products_from_cart() throws InterruptedException {
        //homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        //products page
        productsPage pp=new productsPage(driver);
        scrollDown(700);
        pp.setBtn_firstproduct();
        pp.setBtn_view_cart();
        String url=driver.getCurrentUrl();
        if (url.equalsIgnoreCase("https://automationexercise.com/view_cart")){
            System.out.println("on cart page"+url);
        }
        else {
            System.out.println("url not matched..");
        }
        //view cart page
        viewCartPage vcp=new viewCartPage(driver);
        vcp.setBtn_quantity_delete();
        Thread.sleep(3000);
        if (vcp.setMessagecartempty()) {
            Assert.assertTrue(true, "Cart is empty as expected.");
        } else {
            Assert.fail("Cart is NOT empty, but it was expected to be.");
        }

    }
}
