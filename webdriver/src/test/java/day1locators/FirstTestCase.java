package day1locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        //driver.findElement(By.className("nav-input nav-progressive-attribute")).sendKeys("Mac");
       // Thread.sleep(10000);
       // driver.findElement(By.name("field-keywords")).sendKeys("Mac");
        //driver.findElement(By.id("nav-search-submit-button")).click();
        //Thread.sleep(2000);
       // driver.findElement(By.className("a-button-input")).click();
       Thread.sleep(6000);
       // driver.findElement(By.linkText("Gift Cards")).click();

       List<WebElement> all_link = driver.findElements(By.tagName("a"));

       System.out.println(all_link);

       driver.quit();
    }
}
