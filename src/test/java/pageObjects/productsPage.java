package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class productsPage extends BasePage{
    public productsPage(WebDriver driver){
        super(driver);
    }
    //Locators
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement msz_allproducts;

    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/i[1]")
    WebElement btn_viewproduct;
    //product 1
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement btn_firstproduct;

    //Inside modal-content
    @FindBy(xpath = "//div[@class='modal-content']//div[3]")
    WebElement btn_continue_shopping;

    //product 2
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]" )
    WebElement btn_secondproduct;

    //view cart
    @FindBy(xpath = "//div[@class='modal-content']//div[2]//p//a")
    WebElement btn_view_cart;

    @FindBy(xpath = "//tbody//tr")
    List<WebElement>products_list;

    @FindBy(xpath = "//tr[@id='product-1']//td[3]//p")
    WebElement p_price;

    @FindBy(xpath = "//tr[@id='product-1']//td[4]//button")
    WebElement p_quantity;

    @FindBy(xpath = "//input[@id='quantity']")
    WebElement product_details_quantity;

    @FindBy(xpath = "//tr[@id='product-1']//td[5]//p")
    WebElement p_total;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btn_addtocart;

    //are brands visible
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//li")
    List<WebElement> areBrandsVisible;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//li[1]")
    WebElement clkbrandname;

    //click on any other brand i chosen h&m
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    WebElement clk_brand_hm;

    //Action methods
    public boolean msz_all_products(){
        return msz_allproducts.isDisplayed();
    }
    public void setBtn_viewproduct(){
        btn_viewproduct.click();
    }
    //product 1
    public void setBtn_firstproduct(){
        Actions action=new Actions(driver);
        action.moveToElement(btn_firstproduct).click().build().perform();
    }

   public void setBtn_continue_shopping(){
       //Actions action=new Actions(driver);
        //action.moveToElement(btn_continue_shopping).click().build().perform();
        //btn_continue_shopping.click();
        btn_continue_shopping.click();
    }
    public void setBtn_secondproduct(){
        Actions action=new Actions(driver);
        action.moveToElement(btn_secondproduct).click().build().perform();
    }
    public void setBtn_view_cart(){
        btn_view_cart.click();
    }
    public void setProducts_list(){
        boolean foundBluetop=false;
        boolean foundMenTshirt=false;

        for (WebElement pl:products_list){
            String p1=pl.getText();
            if (p1.contains("Blue Top")){
                foundBluetop=true;
            } else if (p1.contains("Men Tshirt")) {
                foundMenTshirt=true;
            }
        }
        Assert.assertTrue(foundBluetop,"Blue Top not found");
        Assert.assertTrue(foundMenTshirt,"Men Tshirt not found");
    }
   /* public float setPricetotal(){
        float product_total=p_price*p_quantity;
        if (product_total==p_price*p_quantity){
            return product_total;
        }
        return p_price*p_quantity;
    }*/
   public float setPriceTotal() {
       // Extract text and clean non-numeric characters
       String priceText = p_price.getText().replaceAll("[^0-9.]", ""); // Removes everything except numbers & '.'
       String quantityText = p_quantity.getText().replaceAll("[^0-9]", ""); // Removes non-numeric characters
       String totalText = p_total.getText().replaceAll("[^0-9.]", ""); // Cleans total price

       // Convert to numeric values
       float price = Float.parseFloat(priceText);
       int quantity = Integer.parseInt(quantityText);
       float expectedTotal = Float.parseFloat(totalText);

       // Calculate total
       float calculatedTotal = price * quantity;

       // Print values for debugging
       System.out.println("Price: " + price);
       System.out.println("Quantity: " + quantity);
       System.out.println("Calculated Total: " + calculatedTotal);
       System.out.println("Expected Total: " + expectedTotal);

       // Validate total price (optional assertion)
       if (calculatedTotal != expectedTotal) {
           System.out.println("Warning: Calculated total does not match expected total!");
       }

       return calculatedTotal;
   }
    /*public boolean verify_total_price(){
        return setPriceTotal()==Float.parseFloat(p_total.getText().replaceAll("[^0-9]", ""));
    }*/
    public String setP_quantity(){
        return p_quantity.getText();
        /*p_quantity.click();
        p_quantity.clear();
        p_quantity.sendKeys("4");*/
    }

    public void setBtn_addtocart(){
        btn_addtocart.click();
    }
    public void setProduct_details_quantity(){
        product_details_quantity.clear();
        product_details_quantity.sendKeys("4");
    }

    public boolean brandsVisible(){
        return areBrandsVisible.size()>0;
    }

    public void setClkbrandname(){
        clkbrandname.click();
    }

    public void setClk_brand_hm(){
        clk_brand_hm.click();
    }
}
