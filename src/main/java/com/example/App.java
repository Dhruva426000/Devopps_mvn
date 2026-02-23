package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Set the path to the ChromeDriver (change this path to where your chromedriver is located)
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        
        WebDriver driver = new ChromeDriver();
        
        // Open Sauce Demo website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Wait for the username field to be present (up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("standard_user")));
        
        // Log in with valid credentials
        driver.findElement(By.id("standard_user")).sendKeys("standard_user");
        driver.findElement(By.id("secret_sauce")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}


