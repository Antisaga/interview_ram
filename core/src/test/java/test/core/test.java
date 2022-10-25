package test.core;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test {

    WebDriver driver;

    @Test()
    public void test1(){
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/");
        driver.findElement(By.id("signupModalButton")).click();
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
        WebElement title = driver.findElement(By.id("//div[1]/div"));
        Assert.assertTrue(title.getText().contains("browserstack"));
        driver.quit();
    }
}
