package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class paymentDonePage extends BasePage{
    public paymentDonePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    WebElement btn_download;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btn_Continue;

    public void setBtn_download(){
        btn_download.click();
    }

    public void setBtn_Continue(){
        btn_Continue.click();
    }
}
