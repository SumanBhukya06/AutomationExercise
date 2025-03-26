package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Category_products_page;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase16_view_category_products extends BaseClass {

    @Test
    public void verify_category_products() throws InterruptedException {
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
         */
        //homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        scrollDown(400);
        Assert.assertTrue(hp.isCategoryHeadervisible(),"Category header is not visible!");
        Assert.assertTrue(hp.areCategoriesPresent(),"Categories are not displayed on the left sidebar!");
        hp.setBtnwomenExpand();
        hp.setClkDress();
        //category page
        Category_products_page cpp=new Category_products_page(driver);
        Assert.assertTrue(cpp.isWomensdressHeadervisible(),"visible");
        hp.setBtnMenExpand();
        Thread.sleep(2000);
        hp.setClkJeans();
        Thread.sleep(1000);
        Assert.assertTrue(cpp.ismensjeansheadervisible(),"jeans text visible");
    }
}
