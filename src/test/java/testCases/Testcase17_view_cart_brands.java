package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.brandProductsPage;
import pageObjects.homePage;
import pageObjects.productsPage;
import testBase.BaseClass;

public class Testcase17_view_cart_brands extends BaseClass {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
     */
    @Test
    public void verify_view_cart_brands(){
        //homepage
        homePage hp=new homePage(driver);
        hp.setBtn_products();
        //products page
        productsPage pp=new productsPage(driver);
        scrollDown(500);
        Assert.assertTrue(pp.brandsVisible(),"brands are visible");
        pp.setClkbrandname();
        //brandsproductspage
        brandProductsPage bpp=new brandProductsPage(driver);
        Assert.assertTrue(bpp.isbrandpoloproductsvisible(),"polo brand products visible");
        //products page
        pp.setClk_brand_hm();
        scrollDown(100);
        Assert.assertTrue(bpp.isbrandhmproductsvisible(),"h&m products visible");
    }
}
