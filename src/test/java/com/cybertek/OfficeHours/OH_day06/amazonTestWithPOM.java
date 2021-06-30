package com.cybertek.OfficeHours.OH_day06;

import com.cybertek.pages.amazonPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class amazonTestWithPOM {
    //1.	Go to https://www.amazon.com

   @Test
    public void testAmazon(){
      // opening page
       Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
       BrowserUtils.sleep(1);
       // creating object to reach POM variables and methods
       amazonPage amazon = new amazonPage();

       // get the list of all the tabs


       for (int i = 0; i < amazon.tabs.size(); i++) {
           String Text = amazon.tabs.get(i).getText();
           amazon.Tab(Text).click();

       }



   }
}
