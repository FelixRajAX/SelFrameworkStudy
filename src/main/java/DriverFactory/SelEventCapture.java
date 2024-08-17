package DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;


public class SelEventCapture implements WebDriverListener {
    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);

    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        System.out.println("Before navigating to: '" + url + "'");
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        System.out.println("After navigating to: '" + url + "'");
    }

    @Override
    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
        WebDriverListener.super.beforeAnyWebDriverCall(driver, method, args);
        System.out.println("Before WebDriver Call" + method);
    }
}
