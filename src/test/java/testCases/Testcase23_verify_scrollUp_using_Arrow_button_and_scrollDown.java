package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.homePage;
import testBase.BaseClass;

public class Testcase23_verify_scrollUp_using_Arrow_button_and_scrollDown extends BaseClass {
            /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
         */

    @Test
    public void verify_scrollUp_and_scroll_Down() throws InterruptedException {
    //home page
     homePage hp=new homePage(driver);
     hp.setTxt_home();
     scrollToBottom();
     Thread.sleep(1000);
     Assert.assertTrue(hp.getSubscription(),"Not visible");
     Thread.sleep(8000);
     hp.setScrollUp();
     Assert.assertTrue(hp.getTextAutomationEngn(),"Not visible");
    }
}
