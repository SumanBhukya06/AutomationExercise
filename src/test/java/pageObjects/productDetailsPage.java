package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class productDetailsPage extends BasePage{
    public productDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement product_name;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement p_category;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'In Stock')]")
    WebElement p_availability;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'New')]")
    WebElement p_condition;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(), 'Polo')]")
    WebElement p_brand;

    @FindBy(xpath = "//a[normalize-space()='Write Your Review']")
    WebElement textWriteYourReview;

    @FindBy(xpath = "//input[@id='name']")
    WebElement text_name;

    @FindBy(xpath = "//input[@id='email']")
    WebElement text_email;

    @FindBy(xpath = "//textarea[@id='review']")
    WebElement text_review;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement btn_review;

    @FindBy(xpath = "//span[contains(text(),'Thank you for your review.')]")
    WebElement getSuccessMessage;

    //Action methods
    public String getProduct_name(){
        return product_name.getText();
    }
    public String getCategory(){
        return p_category.getText();
    }
    public String getavailability(){
        return p_availability.getText();
    }
    public String getcondition(){
        return p_condition.getText();
    }
    public String getbrand(){
        return p_brand.getText();
    }
    public boolean isWriteYourReviewVisible(){
        return textWriteYourReview.isDisplayed();
    }
    public void setText_name(String r_name){
        text_name.sendKeys(r_name);
    }

    public void setText_email(String r_email){
        text_email.sendKeys(r_email);
    }

    public void setText_review(String r_review){
        text_review.sendKeys(r_review);
    }

    public void setBtn_review(){
        btn_review.click();
    }
    public boolean verifySuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getSuccessMessage));
        return getSuccessMessage.isDisplayed();
    }
    public String getSuccessMessageText() {
        return getSuccessMessage.getText();
    }

}
