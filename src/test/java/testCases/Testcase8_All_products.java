package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productDetailsPage;
import pageObjects.productsPage;
import testBase.BaseClass;

public class Testcase8_All_products extends BaseClass {
    @Test
    public void verify_all_products(){
        logger.info("The test case is started..");
        //Homepage
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_products();
        //products page
        productsPage pp=new productsPage(driver);
        if (pp.msz_all_products()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        scrollDown(320);
        pp.setBtn_viewproduct();
        //productDetailsPage
        productDetailsPage pdp=new productDetailsPage(driver);
        //product name
        String p_name=pdp.getProduct_name();
        if (p_name.equalsIgnoreCase("Blue Top")){
            Assert.assertTrue(true,p_name);
        }
        else {
            Assert.assertFalse(false,p_name);
        }
        //category
        String p_cat=pdp.getCategory();
        if (p_cat.equalsIgnoreCase("Category: Women > Tops")) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        //availability
        String p_avial=pdp.getavailability();
        if (p_avial.equalsIgnoreCase(" In Stock")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertFalse(false);
        }
        //condition
        String condition=pdp.getcondition();
        if (condition.equalsIgnoreCase("New")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }
        //brand
        String brand=pdp.getbrand();
        if (brand.equalsIgnoreCase("Polo")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }

    }
}
