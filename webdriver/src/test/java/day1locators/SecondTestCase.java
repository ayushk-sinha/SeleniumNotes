package day1locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        Thread.sleep(3000);
        driver.findElement(By.name("field-keywords")).sendKeys("Mackbook");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.close();
    }
}
