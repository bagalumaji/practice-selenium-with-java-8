package com.bagal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;

public class AmazonTest {
    @Test
    public void amazonTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List<String> allText = new ArrayList<>();
        for (WebElement link : allLinks) {
            String tt1 = link.getText();
            if(!tt1.isBlank()){
                allText.add(tt1);
            }
        }
        List<String> removingDuplicates = new ArrayList<>(new HashSet<>(allText));
        Collections.sort(removingDuplicates);
        System.out.println(removingDuplicates);

        driver.quit();
    }
}
