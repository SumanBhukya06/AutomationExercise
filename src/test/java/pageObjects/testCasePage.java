package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class testCasePage extends BasePage{
    public testCasePage(WebDriver driver){
        super(driver);
    }
    //locators
    @FindBy(xpath = "//span[contains(text(),'Below is the list of test Cases for you to practic')]")
    WebElement msz_testcase_list;

    //Action methods
    public boolean get_testcase_msz(){
        return msz_testcase_list.isDisplayed();
    }
}
