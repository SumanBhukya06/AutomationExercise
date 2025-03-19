package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement txt_login_email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_login_password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btn_login;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement msz_email_pwd_incorrect;

    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement msz_login_to_your_acc;

    //Action methods
    public void setTxt_login_email(String lemail){
        txt_login_email.sendKeys(lemail);
    }

    public void setTxt_login_password(String lpwd){
        txt_login_password.sendKeys(lpwd);
    }
    public void setBtn_login(){
        btn_login.click();
    }
    public String getIncorrectmsz(){
        try {
            return msz_email_pwd_incorrect.getText();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public String getLogintoaccmsz(){
        try {
            return msz_login_to_your_acc.getText();
        }
        catch (Exception e){
            e.getMessage();
            return null;
        }
    }

}
