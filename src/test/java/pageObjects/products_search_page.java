package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class products_search_page extends BasePage{
    public products_search_page(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@class='productinfo text-center']//p[contains(text(),'Premium Polo T-Shirts')]")
    WebElement isPoloTshirtsTextvisible;

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart']")
    WebElement btn_tshirt_add_to_cart;

    public boolean ispolotshirttextvisible(){
        return isPoloTshirtsTextvisible.isDisplayed();
    }

    public void setBtn_tshirt_add_to_cart(){
        btn_tshirt_add_to_cart.click();
    }
}
