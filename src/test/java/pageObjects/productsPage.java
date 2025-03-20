package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class productsPage extends BasePage{
    public productsPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement msz_allproducts;

    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/i[1]")
    WebElement btn_viewproduct;
    //product 1
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement btn_firstproduct;

    /*@FindBy(xpath = "//div[@class='modal-content']")
    WebElement modal_content;*/

    //Inside modal-content
    //@FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    @FindBy(xpath = "//div[@class='modal-content']//div[3]")
    WebElement btn_continue_shopping;

    //product 2
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]" )
    WebElement btn_secondproduct;

    //view cart
    @FindBy(xpath = "//div[@class='modal-content']//div[2]//p//a")
    WebElement btn_view_cart;

    @FindBy(xpath = "//tbody")
    List<WebElement>products_list;

    //Action methods
    public boolean msz_all_products(){
        return msz_allproducts.isDisplayed();
    }
    public void setBtn_viewproduct(){
        btn_viewproduct.click();
    }
    //product 1
    public void setBtn_firstproduct(){
        Actions action=new Actions(driver);
        action.moveToElement(btn_firstproduct).click().build().perform();
    }
    /*public void setmodal_content(){
        WebElement modal=modal_content;
        Assert.assertTrue(modal.isDisplayed());
        //continue shopping
        WebElement con_shopping=btn_continue_shopping;
        try {
            con_shopping.click();
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", con_shopping);
        }

    }*/
   public void setBtn_continue_shopping(){
       //Actions action=new Actions(driver);
        //action.moveToElement(btn_continue_shopping).click().build().perform();
        //btn_continue_shopping.click();
        btn_continue_shopping.click();
    }
    public void setBtn_secondproduct(){
        Actions action=new Actions(driver);
        action.moveToElement(btn_secondproduct).click().build().perform();
    }
    public void setBtn_view_cart(){
        btn_view_cart.click();
    }
    public void setProducts_list(){
        for (WebElement pl:products_list){
            String p1=pl.getText();
            if (p1.equalsIgnoreCase("Blue Top")){
                Assert.assertTrue(true);
            } else if (p1.equalsIgnoreCase("Men Tshirt")) {
                Assert.assertTrue(true);
            }
            else {
                Assert.fail();
            }
        }
    }
}
