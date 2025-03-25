package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class homePage extends BasePage{
    //constructor invoke
    public homePage(WebDriver driver){
        super(driver);
    }
    //home page visible
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement txt_home;
    //click on signup/login
    @FindBy(xpath = "//li//a//i[@class='fa fa-lock']")
    WebElement clk_signup_login;

    @FindBy(xpath = "//li[10]//a[1]")
    WebElement txt_is_logged_in_username;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btn_logout;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement btn_contact_us;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement btn_Testcases;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement btn_products;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement txt_subscribe_mail;

    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement btn_send_mail;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement txt_success_msz;

    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    WebElement btn_cart;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement verify_subcription;



    //Action methods
    public void setTxt_home(){
        txt_home.isDisplayed();
    }

    public void setClk_signup_login(){
        clk_signup_login.click();
    }
    public boolean setClk_signup_login1(){
        try {
            return clk_signup_login.isDisplayed();
        }
        catch (Exception e){
            e.getMessage();
            return false;
        }
    }
    public void setTxt_is_logged_in_username(){
        txt_is_logged_in_username.isDisplayed();
    }
    public void setBtn_logout(){
        btn_logout.click();
    }
    public void setBtn_contact_us(){
        btn_contact_us.click();
    }
    public void setBtn_Testcases(){
        btn_Testcases.click();
    }
    public void setBtn_products(){
        btn_products.click();
    }
    public void setTxt_subscribe_mail(String semail){
        txt_subscribe_mail.sendKeys(semail);
    }
    public void setBtn_send_mail(){
        btn_send_mail.click();
    }
    public boolean getsuccessmsz(){
        return txt_success_msz.isDisplayed();
    }
    public void setBtn_cart(){
        btn_cart.click();
    }
    public boolean getSubcription(){
        return verify_subcription.isDisplayed();
    }

}
