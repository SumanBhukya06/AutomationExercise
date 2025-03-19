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

}
