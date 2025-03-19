package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BasePage {
    //constructor invoke

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement txt_new_user;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_new_user_name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement txt_email;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement btn_clk_signup;

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement txt_is_account_info;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement chk_mr_radio;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txt_password;

    @FindBy(xpath = "//select[@id='days']//option[@value='10']")
    WebElement select_days;

    @FindBy(xpath = "//select[@id='months']//option[@value='10']")
    WebElement select_months;

    @FindBy(xpath = "//select[@id='years']//option[@value='2000']")
    WebElement select_years;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement chk_newsletter;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement chk_special_offers;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement txt_firstname;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement txt_lastname;

    @FindBy(xpath = "//input[@id='company']")
    WebElement txt_company;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement txt_address1;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement txt_address2;

    @FindBy(xpath = "//select[@id='country']//option[@value='India']")
    WebElement select_country;

    @FindBy(xpath = "//input[@id='state']")
    WebElement txt_state;

    @FindBy(xpath = "//input[@id='city']")
    WebElement txt_city;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement txt_zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement txt_telephone;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement btnclk_create_account;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement txt_isAccountCreated;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnclk_continue;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement btn_delete;

    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement txt_verify_acc_delete;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btn_del_continue;

    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement msz_email_already_exists;

    //Action Methods
    public void isNewuserexists() {
        txt_new_user.click();
        //return txt_new_user.isDisplayed();
    }

    public void setTxt_name(String newuser) {
        //wait.until(ExpectedConditions.visibilityOf(txt_new_user));
        txt_new_user_name.sendKeys(newuser);

    }

    public void setTxt_email(String email) {
        txt_email.sendKeys(email);
    }

    public void setBtn_clk_signup() {
        btn_clk_signup.click();
    }

    public boolean isAccountInfoExists() {
        return txt_is_account_info.isDisplayed();
    }

    public void setChk_mr_radio() {
        chk_mr_radio.click();
    }

    public void setTxt_password(String pwd) {
        txt_password.sendKeys(pwd);
    }

    public void setSelect_days() {
        select_days.click();
    }

    public void setSelect_months() {
        select_months.click();
    }

    public void setSelect_years() {
        select_years.click();
    }

    public void setChk_newsletter() {
        chk_newsletter.click();
    }

    public void setChk_special_offers() {
        chk_special_offers.click();
    }

    public void setTxt_firstname(String fname) {
        txt_firstname.sendKeys(fname);
    }

    public void setTxt_lastname(String lname) {
        txt_lastname.sendKeys(lname);
    }

    public void setTxt_company(String comp) {
        txt_company.sendKeys(comp);
    }

    public void setTxt_address1(String add1) {
        txt_address1.sendKeys(add1);
    }

    public void setTxt_address2(String add2) {
        txt_address2.sendKeys(add2);
    }

    public void setSelect_country() {
        select_country.click();
    }

    public void setTxt_state(String state) {
        txt_state.sendKeys(state);
    }

    public void setTxt_city(String city) {
        txt_city.sendKeys(city);
    }

    public void setTxt_zipcode(String zipCode) {
        txt_zipcode.sendKeys(zipCode);
    }

    public void setTxt_telephone(String telep) {
        txt_telephone.sendKeys(telep);
    }

    public void setBtnclk_create_account() {
        btnclk_create_account.click();
    }

    public boolean isAccountCreated() {
        return txt_isAccountCreated.isDisplayed();
    }

    public void setBtnclk_continue() {
        btnclk_continue.click();
    }

    public void setBtn_delete() {
        btn_delete.click();
    }

    public String setTxt_msz_delete_acc() {
        try {
            return txt_verify_acc_delete.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void setBtn_del_continue() {
        btn_del_continue.click();
    }

    public boolean getEmailalreadyexists() {
        return msz_email_already_exists.isDisplayed();
    }
}
