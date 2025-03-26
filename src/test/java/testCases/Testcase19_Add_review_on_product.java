package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productDetailsPage;
import pageObjects.productsPage;
import testBase.BaseClass;

public class Testcase19_Add_review_on_product extends BaseClass {

    @Test
    public void verify_add_review_on_product(){
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
         */
        homePage hp=new homePage(driver);
        hp.setBtn_products();
        //products page
        productsPage pp=new productsPage(driver);
        pp.msz_all_products();
        pp.setBtn_viewproduct();
        //products details page
        productDetailsPage pdp=new productDetailsPage(driver);
        Assert.assertTrue(pdp.isWriteYourReviewVisible(),"Is visible");
        pdp.setText_name(randomString());
        pdp.setText_email(randomString()+"@gmail.com");
        pdp.setText_review(randomString());
        pdp.setBtn_review();
        Assert.assertTrue(pdp.verifySuccessMessage(),"Success message not displayed!");
        Assert.assertEquals(pdp.getSuccessMessageText(),"Thank you for your review.", "Message mismatch!");


    }
}
