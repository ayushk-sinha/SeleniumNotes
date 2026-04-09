package day1locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdTestCase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://amazon.com");

        Thread.sleep(3000);

        List<WebElement> clicklink = driver.findElements(By.tagName("a"));

        System.out.println(clicklink.size());

        driver.quit();
    }
}
