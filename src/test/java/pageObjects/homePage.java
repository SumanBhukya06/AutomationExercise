package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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

    //categories
    @FindBy(xpath = "//h2[normalize-space()='Category']")
    WebElement categoryHeader;
    //List of categories
    @FindBy(xpath = "//div[@class='panel-group category-products']//div[@class='panel panel-default']")
    List<WebElement> categories;

    //women-dress
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    WebElement clkDress;

    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement btnwomenExpand;

    @FindBy(xpath = "//a[normalize-space()='Men']")
    WebElement btnMenExpand;

    @FindBy(xpath = "//div[@id='Men']//ul//li[2]//a") //div[@id='Men']//li[2]
    WebElement clkJeans;

    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement getRecommendedItems;

    @FindBy(xpath = "//p[normalize-space()='Winter Top']")
    WebElement winterTopText;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
    WebElement winterTopAddToCart;

    @FindBy(xpath = "//a[@id='scrollUp']")
    WebElement scrollUp;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement text_subscription;

    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement text_Automation_Engn;

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

    //categoryHeader
    public boolean isCategoryHeadervisible(){
        return categoryHeader.isDisplayed();
    }

    public boolean areCategoriesPresent(){
        return categories.size()>0;
    }

    public void setBtnwomenExpand(){
        btnwomenExpand.click();
    }

    public void setClkDress(){
        clkDress.click();
    }
    public void setBtnMenExpand(){
        btnMenExpand.click();
    }

    public void setClkJeans(){
        clkJeans.click();
    }

    public boolean areRecommendedItemsVisible(){
        return getRecommendedItems.isDisplayed();
    }

    public boolean isWinterTopVisible(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(winterTopText));
        return winterTopText.isDisplayed();
    }

    public void clickWinterTop(){
       /* WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(winterTopAddToCart)).click();*/
        winterTopAddToCart.click();
    }
    public void setScrollUp(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(scrollUp)).click();
    }

    public boolean getSubscription(){
        return text_subscription.isDisplayed();
    }

    public boolean getTextAutomationEngn(){
        return text_Automation_Engn.isDisplayed();
    }
}
