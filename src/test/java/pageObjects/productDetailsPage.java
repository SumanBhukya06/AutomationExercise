package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends BasePage{
    public productDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement product_name;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement p_category;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'In Stock')]")
    WebElement p_availability;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'New')]")
    WebElement p_condition;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'Polo')]")
    WebElement p_brand;

    //Action methods
    public String getProduct_name(){
        return product_name.getText();
    }
    public String getCategory(){
        return p_category.getText();
    }
    public String getavailability(){
        return p_availability.getText();
    }
    public String getcondition(){
        return p_condition.getText();
    }
    public String getbrand(){
        return p_brand.getText();
    }
}
