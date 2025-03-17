package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    //Action methods
    public void setTxt_home(){
        txt_home.isDisplayed();
    }

    public void setClk_signup_login(){
        clk_signup_login.click();
    }

    public void setTxt_is_logged_in_username(){
        txt_is_logged_in_username.isDisplayed();
    }
}
