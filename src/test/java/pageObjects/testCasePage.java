package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class testCasePage extends BasePage{
    public testCasePage(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(xpath = "//span[contains(text(),'Below is the list of test Cases for you to practic')]")
    WebElement msz_testcase_list;
    //List of test cases
    @FindBy(xpath = "//div[@class='panel-heading']")
    List<WebElement>list_testcases;

    //Action methods
    public boolean get_testcase_msz(){
        return msz_testcase_list.isDisplayed();
    }

    public void setList_testcases(){
        logger.info("fetching list of testcases");
        for (WebElement ls_testcase:list_testcases){
            String tc_text=ls_testcase.getText();
            logger.info(tc_text);
        }
        logger.info("all test cases printed successfully");
    }
}
