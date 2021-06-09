package com.cybertek.OfficeHours.OH_day03;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.OfficeHoursUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class adidasPractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }


    @Test
    public void adidasTest(){
        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Laptops","Sony vaio i5");
        // Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Phones","Samsung galaxy s6");
        // Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Monitors","Apple monitor 24");

        // Remove  Apple monitor 24
        OfficeHoursUtils.productRemover(driver,"Apple monitor 24");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
