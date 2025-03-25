package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutpage extends BasePage{
    public checkoutpage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement txt_message_area;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement btn_place_order;

    public void setTxt_message_area(String messageArea){
        txt_message_area.sendKeys(messageArea);
    }

    public void setBtn_proceed(){
        btn_place_order.click();
    }
}
