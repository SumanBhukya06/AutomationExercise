package testBase;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    /*
    setup
    Before class
    After class
     */
    public static WebDriver driver;
    public Logger logger;
    public Properties p;


    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"os", "browser"})
    public void setUp(String os, String br) throws IOException {
        //Loading config files
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        //os
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities capabilities=new DesiredCapabilities();
            if (os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WIN11);
            }
            else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }
            else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            }
            else {
                System.out.printf("No matching os");
                return;
            }
            switch (br.toLowerCase()){
                case "chrome":capabilities.setBrowserName("chrome");break;
                case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
                case "firefox":capabilities.setBrowserName("firefox");break;
                default:
                    System.out.println("No matching browser found");return;
        }
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        if (p.getProperty("execution_env").equalsIgnoreCase("local")){
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }

        }
        driver.get(p.getProperty("appURL"));
        //driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown() {
        driver.quit();
    }

    //firstname, lastname and email
    public String randomString() {
        String generate_randomstring = RandomStringUtils.randomAlphabetic(5);
        return generate_randomstring;
    }

    //email
    public String randomNumber() {
        String generate_randomNumber = RandomStringUtils.randomNumeric(10);
        return generate_randomNumber;
    }

    //Password
    public String randomAlphanumeric() {
        String ran_alpha = RandomStringUtils.randomAlphanumeric(3);
        String ran_num = RandomStringUtils.randomNumeric(3);
        return (ran_alpha + "@" + ran_num);
    }
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ");");
    }
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    // Scroll up method
    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + pixels + ");");
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public void alerteElements(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
