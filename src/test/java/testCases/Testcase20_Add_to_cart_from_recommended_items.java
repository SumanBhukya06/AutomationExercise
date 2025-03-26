package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productsPage;
import pageObjects.viewCartPage;
import testBase.BaseClass;

public class Testcase20_Add_to_cart_from_recommended_items extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
     */
    @Test
    public void verify_add_to_cart_from_recommended_items() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        homePage hp=new homePage(driver);
        Assert.assertTrue(hp.areRecommendedItemsVisible(),"Not displayed!");
        Assert.assertTrue(hp.isWinterTopVisible(),"not visible");
        hp.clickWinterTop();
        productsPage pp=new productsPage(driver);
        pp.setBtn_view_cart();
        Thread.sleep(2000);
        hp.setBtn_cart();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/view_cart");
    }
}
