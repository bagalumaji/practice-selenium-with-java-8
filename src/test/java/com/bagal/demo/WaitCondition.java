package com.bagal.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface WaitCondition {
    WebElement apply(WebDriver driver, WebElement element);
}
