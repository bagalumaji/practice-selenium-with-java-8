package com.bagal.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActionsUtil {

    final private WebDriver driver;
    final private WebDriverWait wait;

    public PageActionsUtil(WebDriver driver, long waitTimeInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    }

    public void clickElement(WebElement element, WaitCondition waitCondition) {
        WebElement clickableElement = applyExplicitWait(element, waitCondition);
        performAction(clickableElement, WebElement::click);
    }

    public void sendKeysToElement(WebElement element, String text, WaitCondition waitCondition) {
        WebElement visibleElement = applyExplicitWait(element, waitCondition);
        inputAction(visibleElement, (el, value) -> el.sendKeys(value), text);
    }

    public boolean isElementDisplayed(WebElement element, WaitCondition waitCondition) {
        WebElement visibleElement = applyExplicitWait(element, waitCondition);
        return checkCondition(visibleElement, WebElement::isDisplayed);
    }

    private void performAction(WebElement element, ElementAction action) {
        action.perform(element);
    }

    private void inputAction(WebElement element, ElementInputAction inputAction, String value) {
        inputAction.input(element, value);
    }

    private boolean checkCondition(WebElement element, ElementCondition condition) {
        return condition.check(element);
    }

    private WebElement applyExplicitWait(WebElement element, WaitCondition waitCondition) {
        return wait.until(driver -> waitCondition.apply(driver, element));
    }
}