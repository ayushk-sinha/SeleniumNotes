package day3xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone");
        Thread.sleep(1000);
        driver.quit();
    }

}
