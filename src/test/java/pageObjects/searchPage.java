package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class searchPage extends BasePage{
    public searchPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement txt_search_box;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement btn_search;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> products_list;

    //Action Methods
    public void setTxt_search_box(String searchbox){
        txt_search_box.sendKeys(searchbox);
    }

    public void setBtn_search(){
        btn_search.click();
    }

    public void getProductslist(){
        for (WebElement pl:products_list){
            System.out.println(pl.getText());
        }
    }
}
