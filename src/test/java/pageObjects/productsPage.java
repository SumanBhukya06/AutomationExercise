package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productsPage extends BasePage{
    public productsPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement msz_allproducts;

    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/i[1]")
    WebElement btn_viewproduct;

    //Action methods
    public boolean msz_all_products(){
        return msz_allproducts.isDisplayed();
    }
    public void setBtn_viewproduct(){
        btn_viewproduct.click();
    }
}
