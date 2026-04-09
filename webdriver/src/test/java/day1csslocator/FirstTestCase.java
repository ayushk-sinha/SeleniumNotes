package day1csslocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
    public static void main(String[] args) throws  InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://amazon.com");

        Thread.sleep(2000);

        //tag + id
        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("T-Shirt");

        Thread.sleep(2000);

        //tag + attribute
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
        Thread.sleep(2000);

        //tag + class + attribute
        driver.findElement(By.cssSelector("input.nav-input[role='searchbox']")).sendKeys("Iphone");

        driver.findElement(By.cssSelector("input[type = 'submit']")).click();

        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        
        System.out.println("sucess");
        driver.quit();
        
    }

}
