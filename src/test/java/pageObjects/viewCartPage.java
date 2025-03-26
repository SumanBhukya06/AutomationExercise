package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class viewCartPage extends BasePage{
    public viewCartPage(WebDriver driver){
        super(driver);
    }
    //proceed to checkout
    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement btn_proceed_to_checkout;

    @FindBy(xpath = "//div[@class='modal-content']//a[normalize-space()='Register / Login']//u")
    WebElement btn_Register_login;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement btn_quantity_delete;

    @FindBy(xpath = "//p[contains(text(),'Click')]")
    WebElement getMessageCartEmpty;

    public void setBtn_proceed_to_checkout(){
        btn_proceed_to_checkout.click();
    }

    public void setBtn_Register_login(){
        btn_Register_login.click();
    }

    public void setBtn_quantity_delete(){
        btn_quantity_delete.click();
    }
    public boolean setMessagecartempty(){
        return getMessageCartEmpty.isDisplayed();
    }
}
