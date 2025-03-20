package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.productsPage;
import testBase.BaseClass;

import java.util.List;

public class Testcase12_Add_products_in_cart extends BaseClass {

    @Test
    public void verify_add_products_in_cart() throws InterruptedException {
        //home page
        homePage hp = new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_products();
        //products page
        productsPage pp = new productsPage(driver);
        pp.setBtn_firstproduct();
        Thread.sleep(3000);
        pp.setBtn_continue_shopping();
        Thread.sleep(3000);
        pp.setBtn_secondproduct();
        Thread.sleep(3000);
        pp.setBtn_view_cart();
        Thread.sleep(3000);
        //scrollUp(150);
        //pp.setmodal_content();
       // pp.setBtn_continue_shopping();

    }
    }

