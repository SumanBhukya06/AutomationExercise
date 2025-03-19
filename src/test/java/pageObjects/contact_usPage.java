package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contact_usPage extends BasePage{
    public contact_usPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement msz_getintouch;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_contact_name;

    @FindBy(xpath ="//input[@placeholder='Email']" )
    WebElement txt_contact_email;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    WebElement txt_contact_subject;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement txt_contact_message;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement file_upload;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement btn_contact_submit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement msz_success_contact;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    WebElement btn_home;

    //Action methods
    public boolean getmszgetintouch(){
        return msz_getintouch.isDisplayed();
    }

    public void setTxt_contact_name(String cname){
        txt_contact_name.sendKeys(cname);
    }

    public void setTxt_contact_email(String cmail){
        txt_contact_email.sendKeys(cmail);
    }

    public void setTxt_contact_subject(String csubject){
        txt_contact_subject.sendKeys(csubject);
    }

    public void setTxt_contact_message(String cmessage){
        txt_contact_message.sendKeys(cmessage);
    }
    public void setFile_upload(){
        file_upload.sendKeys("C:\\Users\\GRL\\Desktop\\test.txt");
    }
    public void setContact_submit(){
        btn_contact_submit.click();
    }
    public String setMsz_success_contact(){
        return msz_success_contact.getText();
    }
    public void setBtn_home(){
        btn_home.click();
    }

}
