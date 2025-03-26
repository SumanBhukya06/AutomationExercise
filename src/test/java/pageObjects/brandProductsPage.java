package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class brandProductsPage extends BasePage{
    public brandProductsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='Brand - Polo Products']")
    WebElement isBrandPoloproductsvisible;
    //h&m text visible
    @FindBy(xpath = "//h2[normalize-space()='Brand - H&M Products']")
    WebElement isBrandHMproductsvisible;



    public boolean isbrandpoloproductsvisible(){
        return isBrandPoloproductsvisible.isDisplayed();
    }

    public boolean isbrandhmproductsvisible(){
        return isBrandHMproductsvisible.isDisplayed();
    }
}
