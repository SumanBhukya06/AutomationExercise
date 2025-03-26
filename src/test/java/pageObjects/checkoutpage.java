package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class checkoutpage extends BasePage{
    public checkoutpage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement txt_message_area;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement btn_place_order;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(@class, 'address')]")
    List<WebElement> deliveryAddress;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[contains(@class, 'address')]")
    List<WebElement> billingAddress;

    public void setTxt_message_area(String messageArea){
        txt_message_area.sendKeys(messageArea);
    }

    public void setBtn_proceed(){
        btn_place_order.click();
    }

    public String getFormattedAddress(List<WebElement> addressList) {
        return addressList.stream()
                .map(e -> e.getText().replaceAll("\\s+", " ").trim())  // Normalize spaces & trim
                .filter(text -> !text.equalsIgnoreCase("YOUR DELIVERY ADDRESS") &&
                        !text.equalsIgnoreCase("Your Billing address"))  // Exclude headers
                .collect(Collectors.joining("\n"));  // Keep structure
    }

    // Method to compare addresses
    public boolean compareAddresses() {
        String deliveryAddress1 = getFormattedAddress(deliveryAddress);
        String billingAddress2 = getFormattedAddress(billingAddress);

        System.out.println("Delivery Address:\n" + deliveryAddress1);
        System.out.println("Billing Address:\n" + billingAddress2);

        return deliveryAddress1.equals(billingAddress2);
    }
}
