package com.bagal.demo;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementInputAction {
    void input(WebElement element, String value);
}