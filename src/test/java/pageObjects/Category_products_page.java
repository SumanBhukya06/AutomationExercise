package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Category_products_page extends BasePage{
    public Category_products_page(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
    WebElement women_dress_text_visible;

    @FindBy(xpath = "//h2[normalize-space()='Men - Jeans Products']")
    WebElement men_jeans_product_header;


    public boolean isWomensdressHeadervisible(){
        return women_dress_text_visible.isDisplayed();
    }

    public boolean ismensjeansheadervisible(){
        return men_jeans_product_header.isDisplayed();
    }



}
