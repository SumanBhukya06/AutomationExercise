package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class paymentPage extends BasePage{
    public paymentPage(WebDriver driver){
        super(driver);
    }
    //card name
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement txt_name_on_card;
    //card number
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement txt_card_number;
    //card cvc
    @FindBy(xpath = "//input[@name='cvc']")
    WebElement txt_cvc;
    //Expiration month
    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement txt_month;
    //year
    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement txt_year;
    //submit
    @FindBy(xpath = "//button[normalize-space()='Pay and Confirm Order']")
    WebElement btn_pay_and_confirm;

    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    WebElement getSuccessMsz;

    public void setTxt_name_on_card(String cardname){
        txt_name_on_card.sendKeys(cardname);
    }
    public void setTxt_card_number(String cardnumber){
        txt_card_number.sendKeys(cardnumber);
    }
    public void setTxt_cvc(String cvc){
        txt_cvc.sendKeys(cvc);
    }
    public void setTxt_month(){
        txt_month.sendKeys("04");
    }
    public void setTxt_year(){
        txt_year.sendKeys("2036");
    }
    public void setBtn_pay_and_confirm(){
        btn_pay_and_confirm.click();
    }
    public boolean setSucessMsz(){
        return getSuccessMsz.isDisplayed();
    }
}
