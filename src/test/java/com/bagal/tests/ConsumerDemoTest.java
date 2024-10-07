package com.bagal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemoTest {
    @Test
    public void testConsumer() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        List<WebElement> list = driver.findElements(By.tagName("a"));

        Consumer<WebElement> consumer=ele->System.out.println(ele.getText());
        Consumer<WebElement> consumer1=ele-> {
            if(!ele.getText().isBlank()) {
                System.out.println(ele.getText());
            }
        };
        list.forEach(consumer1);
        driver.quit();
    }
    @Test
    public void testSelectDropDown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        Thread.sleep(3000);
        WebElement select1 = driver.findElement(By.id("select-demo"));
        Thread.sleep(3000);
        selectDropDown(select1,select->select.selectByVisibleText("Monday"));
        Thread.sleep(3000);
        selectDropDown(select1,select->select.selectByValue("Wednesday"));
        Thread.sleep(3000);
        selectDropDown(select1,select->select.selectByIndex(5));
        Thread.sleep(4000);
        driver.quit();

    }

    static void selectDropDown(WebElement element, Consumer<Select> selectConsumer){
        Select select = new Select(element);
        selectConsumer.accept(select);
    }

}
