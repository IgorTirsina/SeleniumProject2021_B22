package com.cybertek.OfficeHours.OH_day05;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class techCrunch {
// author : (//article[@class='post-block post-block--image post-block--unread'])[1]//a[contains(@aria-label,'Posts by')]
// pictures : (//article[@class='post-block post-block--image post-block--unread'])[1]//img[contains(@sizes,'min-width: 1024px')]
    @Test
    public void test(){
        // Go to https://techcrunch.com/
        Driver.getDriver().get("https://techcrunch.com/");

        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
        System.out.println(latestNews.size());
        BrowserUtils.sleep(2);
        for (int i = 1; i <= latestNews.size(); i++) {
            // Verify each article has an author
    String authorLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//a[contains(@aria-label,'Posts by')]";
    WebElement authorElement = Driver.getDriver().findElement(By.xpath(authorLocator));
            Assert.assertTrue(authorElement.isDisplayed());

    String pictureLocator = "(//article[@class='post-block post-block--image post-block--unread'])["+i+"]//img[contains(@sizes,'min-width: 1024px')]";
    WebElement pictureElement = Driver.getDriver().findElement(By.xpath(pictureLocator));
    Assert.assertTrue(pictureElement.isDisplayed());

        }
    }
}
