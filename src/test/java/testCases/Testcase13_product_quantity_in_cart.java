package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productsPage;
import testBase.BaseClass;

public class Testcase13_product_quantity_in_cart extends BaseClass {

    @Test
    public void verify_product_quantity(){
        //home page
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        //products page
        productsPage pp=new productsPage(driver);
        scrollDown(600);
        pp.setBtn_viewproduct();
        pp.setProduct_details_quantity();
        //pp.setP_quantity();
        pp.setBtn_addtocart();
        pp.setBtn_view_cart();
        String quantity_txt=pp.setP_quantity();
        if (quantity_txt.equals("4")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
