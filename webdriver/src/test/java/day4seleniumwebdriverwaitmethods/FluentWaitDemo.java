package day4seleniumwebdriverwaitmethods;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        WebElement txtusernmae = mywait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }
                       
        });

        txtusernmae.sendKeys("Admin");
    }
}
/*
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        driver.get("https://xyz.com");

        WebElement txtusername = mywait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//*[xpath]"));
            }
        });

        txtusername.sendKeys("Admin");

 */