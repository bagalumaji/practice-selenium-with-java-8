package com.bagal.demo;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementCondition {
    boolean check(WebElement element);
}
