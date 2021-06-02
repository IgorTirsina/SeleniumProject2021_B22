package com.cybertek.OfficeHours.OH_day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity1 {
/*
Scenario: Checking the account activity page features of ZeroBank Application

1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
2. The user logs in with the user "username" and the password "password"
3. The user navigates to Account Activity page
4. Then The page should have the title "Zero - Account Activity"
5. Then Account drop down should have the following options :
(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
6. Brokerage option should have "No results."

 */

    // Declare our driver object

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

        // login

        driver.findElement(By.cssSelector("[id*='user_log']")).sendKeys("username");
        driver.findElement(By.cssSelector("[id*='user_pass']")).sendKeys("password");
        driver.findElement(By.cssSelector("[type*='sub']")).click();
        driver.findElement(By.cssSelector("[id*='primary-']")).click();
   }

    @Test
    public void accountActivity(){
        //    Then The page should have the title "Zero - Account Activity"

        driver.findElement(By.cssSelector("[id*='acco']")).click();
        String expectedTitle = "Zero - Account Activity1";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"verify Title");

        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan",
                "Credit Card", "Brokerage"));

    }

    @AfterClass
    public void tearDownClass(){
        driver.quit();

    }

}
