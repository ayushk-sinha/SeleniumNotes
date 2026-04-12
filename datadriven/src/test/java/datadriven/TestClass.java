package datadriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ilovepdf.com/jpg_to_pdf");

        String location = "/home/kali/Downloads/photo.jpg";

        // 🔥 Step 1: Find the real input element
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

        // 🔥 Step 2: Upload directly
        fileInput.sendKeys(location);
        System.out.println("File uploaded successfully!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='processTask']")).click();


    }
}