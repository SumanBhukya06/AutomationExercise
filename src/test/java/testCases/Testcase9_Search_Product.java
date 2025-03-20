package testCases;

import org.testng.annotations.Test;
import pageObjects.homePage;
import pageObjects.searchPage;
import testBase.BaseClass;

public class Testcase9_Search_Product extends BaseClass {

    @Test
    public void verify_search_product(){
        //Home page
        homePage hp=new homePage(driver);
        hp.setTxt_home();
        hp.setBtn_products();
        //search page
        searchPage sp=new searchPage(driver);
        sp.setTxt_search_box(p.getProperty("search"));
        sp.setBtn_search();
        sp.getProductslist();
    }
}
